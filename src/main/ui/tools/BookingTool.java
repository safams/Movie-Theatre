package ui.tools;

import model.Ticket;
import ui.MovieTheatreGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Booking Tool panel to let user select a movie, timing, and seat, and displays purchased ticket
public class BookingTool extends JPanel {

    MovieTheatreGUI ui;
    List<Integer> timings;
    JComboBox movieTimings;
    JComboBox movieNames;
    String selectedMovie;

    List<String> finalSelection;

    List<String> rowA;
    List<String> rowB;
    List<String> rowC;

    JLabel finishedTicket;


    JButton selectTimingButton;
    JButton selectSeatsButton;
    JButton selectMovieButton;
    JButton bookMovieButton;
    List<String> list;

    Integer selectedTiming;

    JList listA;
    JList listB;
    JList listC;


    Boolean whichList;

    ImageIcon bgicon;

    IconToImage iconToImage;

    Image image;




    //EFFECTS: constructs a booking tool with gui passed in and sets up background
    public BookingTool(MovieTheatreGUI gui) {
        background();
        //this.setBackground(new Color(242, 201, 170));

        ui = gui;
        list = new ArrayList<>();
        bookMovieButton = new JButton("Book a new movie");
        this.add(bookMovieButton);
        dropDowns();
        this.setVisible(true);

    }

    //EFFECTS: creates the background image for the panel, using an Icon
    public Image background() {
        bgicon = new ImageIcon("./data/curtainsRed.jpg");
        iconToImage = new IconToImage(bgicon);
        image = iconToImage.getImage();
        return image;
    }

    //MODIFIES: this
    //EFFECTS: paints the image "g" onto the background of the panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    //MODIFIES: this
    //EFFECTS: creates buttons and dopdowns to select movies, and actionliseners for button clicks
    public void dropDowns() {
        selectMovieButton = new JButton("Confirm Movie");
        selectTimingButton = new JButton("Confirm Timing");
        selectSeatsButton = new JButton("Confirm Seat(s)");

        list.add("No Timing Chosen");
        movieNames = new JComboBox(ui.getMovieNames().toArray());
        movieTimings = new JComboBox(list.toArray());
        finishedTicket = new JLabel("");
        this.add(finishedTicket);


        bookMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookingOptions();
                finishedTicket.setText("");
                remove(finishedTicket);

            }
        });

        selectMovie();


        selectSeatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSeats();
            }
        });


    }

    //MODIFES: this
    //EFFECTS: add the movie names and buttons to the panel
    public void addBookingOptions() {
        this.add(movieNames);
        this.add(selectMovieButton);


        movieNames.revalidate();
        selectMovieButton.revalidate();

    }



    //EFFECTS: actionlistener for the movie name selection button
    //         sets up the timing methods
    public void selectMovie() {
        selectMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMovie = movieNames.getSelectedItem().toString();
                timings = ui.returnTimings(selectedMovie);
                movieTimings.removeAllItems();

                movieTimings.addItem("No Timing Chosen");
                movieTimings.addItem(timings.get(0));
                movieTimings.addItem(timings.get(1));

                timingButtons();

            }
        });


        selectTimingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTiming();
            }
        });
    }

    //MODIFIES: this
    //EFFECTS: adds timing button and dropdown options in panel
    public void timingButtons() {
        this.add(movieTimings);
        this.add(selectTimingButton);
        movieTimings.revalidate();
        selectTimingButton.revalidate();
    }


    //MODIFIES: this
    //EFFECTS: based on timing selection, creates up to 3 rows of seats and adds to panel
    public void selectTiming() {
        selectedTiming = Integer.parseInt(movieTimings.getSelectedItem().toString());
        rowA = ui.parseRowA(ui.returnSeats(ui.returnMovieFromName(selectedMovie), selectedTiming));
        rowB = ui.parseRowB(ui.returnSeats(ui.returnMovieFromName(selectedMovie), selectedTiming));
        rowC = ui.parseRowC(ui.returnSeats(ui.returnMovieFromName(selectedMovie), selectedTiming));

        whichList = ui.returnSeats1(ui.returnMovieFromName(selectedMovie), selectedTiming);

        listA = new JList(rowA.toArray());
        listB = new JList(rowB.toArray());
        listC = new JList(rowC.toArray());

        DefaultListCellRenderer renderer1 = (DefaultListCellRenderer)listA.getCellRenderer();
        renderer1.setHorizontalAlignment(JLabel.CENTER);
        DefaultListCellRenderer renderer2 = (DefaultListCellRenderer)listB.getCellRenderer();
        renderer2.setHorizontalAlignment(JLabel.CENTER);
        DefaultListCellRenderer renderer3 = (DefaultListCellRenderer)listC.getCellRenderer();
        renderer3.setHorizontalAlignment(JLabel.CENTER);

        selectimingg();
    }

    //MODIFIES: this
    //EFFECTS: adds the 3 seat rows to the panel to allow user to pick seats
    public void selectimingg() {
        listA.setVisibleRowCount(3);
        listB.setVisibleRowCount(3);
        listC.setVisibleRowCount(3);



        listA.setFixedCellHeight(30);
        listA.setFixedCellWidth(30);
        listB.setFixedCellHeight(30);
        listB.setFixedCellWidth(30);
        listC.setFixedCellHeight(30);
        listC.setFixedCellWidth(30);


        listA.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listB.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listC.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.add(listA);
        this.add(listB);
        this.add(listC);


        add(selectSeatsButton);

        listA.revalidate();
        listB.revalidate();
        listC.revalidate();
    }



    //MODIFIES: this
    //EFFECTS: creates a ticket with selected movie, timing, seat(s), and removes
    //         seats from theatre, adds ticket to user's list, and re-sets the buttons
    public void selectSeats() {
        List<String> list1 = listA.getSelectedValuesList();
        List<String> list2 = listB.getSelectedValuesList();
        List<String> list3 = listC.getSelectedValuesList();

        finalSelection = new ArrayList<>();
        finalSelection.addAll(list1);
        finalSelection.addAll(list2);
        finalSelection.addAll(list3);

        Ticket temporary = ui.finishPurchase(selectedMovie, selectedTiming, finalSelection);

        this.remove(finishedTicket);

        finishedTicket.setText(toString(temporary));
        this.add(finishedTicket);

        finishedTicket.setForeground(Color.white);
        finishedTicket.setFont(new Font("SansSerif Plain", Font.BOLD, 13));


        finishedTicket.revalidate();

        if (whichList) {
            ui.removeThingsSeats1(selectedMovie, finalSelection);
        } else {
            ui.removeThingsSeats2(selectedMovie, finalSelection);
        }

        removeBookingOptions();



    }

    //MODIFIES: this
    //EFFECTS: removes movie names and movie timings buttons
    public void removeBookingOptions() {
        this.remove(listA);
        this.remove(listB);
        this.remove(listC);
        this.remove(selectSeatsButton);
        this.remove(movieNames);
        this.remove(selectMovieButton);
        this.remove(movieTimings);
        this.remove(selectTimingButton);


    }




    //EFFECTS: turns a ticket into a string to be displayed
    public String toString(Ticket ticket) {
        return "Name: " + ticket.getName() + " | Seats: " + ticket.getSeats() + " | Time: " + ticket.getTime();
    }




}
