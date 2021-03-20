package ui.tools;

import model.Ticket;
import ui.MovieTheatreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketListTool extends JPanel {

    MovieTheatreGUI ui;

    private static final String CANCEL_COMMAND = "cancel";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";


    JButton save;
    JButton load;
    JList<String> ticketList;
    private Object list;
    JLabel cancelLabel;
    JButton cancel;
    String selection;
    List listt;


    public TicketListTool(MovieTheatreGUI gui) {
        this.setBackground(new Color(196, 199, 242));
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ui = gui;
        ticketListCreation();
        cancelLabel = new JLabel("Select ticket(s) to delete from the list of tickets");
        cancel = new JButton("Confirm Cancel Selection(s)");

        save();
        loadButton();
        this.add(cancelLabel);
        this.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFunction();
            }
        });


    }

    public void save() {
        save = new JButton("Save To File");
        this.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ui.save();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    public void loadButton() {
        load = new JButton("Load From File");
        this.add(load);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ui.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void cancelFunction() {
        selection = ticketList.getSelectedValue();
        int index = listt.indexOf(selection);
        ui.cancelPurchase(index);
    }

    public void ticketListCreation() {

        ticketList = new JList(parseLIst(ui.getTicketList()).toArray());
        ticketList.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(ticketList);
        this.add(scrollPane);
    }

    public List parseLIst(List<Ticket> list) {
        listt = new ArrayList();
        for (Ticket t : list) {
            listt.add(toString(t));
        }
        return listt;
    }

    public String toString(Ticket ticket) {
        return "Name: " + ticket.getName() + " | Seats: " + ticket.getSeats() + " | Time: " + ticket.getTime();
    }





}
