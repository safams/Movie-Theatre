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

//Class that creates a TicketListTool to act as a JPanel
public class TicketListTool extends JPanel {

    MovieTheatreGUI ui;


    JList<String> ticketList;
    JLabel cancelLabel;
    JButton cancel;
    String selection;
    List listt;


    //EFFECTS: constructs a ticketList tool with gui passed in and sets up background + layout
    public TicketListTool(MovieTheatreGUI gui) {
        this.setBackground(new Color(37, 9, 2));
        ui = gui;
        ticketListCreation();
        cancelLabel = new JLabel("Select ticket(s) to delete from the list of tickets");
        cancelLabel.setForeground(Color.white);
        cancel = new JButton("Confirm Cancel Selection(s)");

        this.add(cancelLabel);
        this.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFunction();
            }
        });
    }

    //MODIFIES: this
    //EFFECTS: cancels the user's selection of ticket from their ticket list
    public void cancelFunction() {
        selection = ticketList.getSelectedValue();
        int index = listt.indexOf(selection);
        ui.cancelPurchase(index);
    }

    //MODIFIES: this
    //EFFECTS: creates a display list of the user's tickets, in a scrollable box
    public void ticketListCreation() {
        ticketList = new JList(parseLIst(ui.getTicketList()).toArray());
        ticketList.setVisibleRowCount(5);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(ticketList);
        this.add(scrollPane);
    }

    //EFFECTS: turns each list in the user's ticket list into a string to display
    public List parseLIst(List<Ticket> list) {
        listt = new ArrayList();
        for (Ticket t : list) {
            listt.add(toString(t));
        }
        return listt;
    }

    //EFFECTS: turns a ticket into a string to be displayed
    public String toString(Ticket ticket) {
        return "Name: " + ticket.getName() + " | Seats: " + ticket.getSeats() + " | Time: " + ticket.getTime();
    }





}
