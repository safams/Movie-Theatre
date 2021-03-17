package ui.tools;

import ui.MovieTheatreGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BookingTool extends JPanel implements ActionListener, ListSelectionListener {


    private static final String BOOK_COMMAND = "book";
    MovieTheatreGUI ui;
    List<Integer> timings;
    JComboBox movieTimings;
    JComboBox movieNames;
    String selectedMovie;

    List<String> rowA;
    List<String> rowB;
    List<String> rowC;



    JButton selectTimingButton;
    JButton selectSeatsButton;
    JButton selectMovieButton;
    List<String> list;

    Integer selectedTiming;
    List<String> selectedSeats;

    JList listA;
    JList listB;
    JList listC;



    public BookingTool(MovieTheatreGUI gui) {
        this.setBackground(new Color(242, 201, 170));

        ui = gui;
        list = new ArrayList<>();
        dropDowns();
        test();
        this.setVisible(true);
    }

    private void dropDowns() {
        selectMovieButton = new JButton("Select Movie");
        selectTimingButton = new JButton("Select Timing");
        selectSeatsButton = new JButton("Select Seats");

        list.add("No Timing Selected");
        movieNames = new JComboBox(ui.getMovieNames().toArray());
        movieTimings = new JComboBox(list.toArray());

        selectMovie();


        selectTimingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTiming();
            }
        });

//        selectSeatsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                selectSeats();
//            }
//        });


        this.add(movieNames);
        this.add(selectMovieButton);
        this.add(movieTimings);
        this.add(selectTimingButton);



        //this.add(selectSeatsButton);

    }

    public void selectMovie() {
        selectMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMovie = movieNames.getSelectedItem().toString();
                timings = ui.returnTimings(selectedMovie);
                movieTimings.removeAllItems();
                movieTimings.addItem(timings.get(0));
                movieTimings.addItem(timings.get(1));
            }
        });
    }


    public void selectTiming() {

        selectedTiming = Integer.parseInt(movieTimings.getSelectedItem().toString());
        rowA = ui.parseRowA(ui.returnSeats(ui.returnMovieFromName(selectedMovie), selectedTiming));
        rowB = ui.parseRowB(ui.returnSeats(ui.returnMovieFromName(selectedMovie), selectedTiming));
        rowC = ui.parseRowC(ui.returnSeats(ui.returnMovieFromName(selectedMovie), selectedTiming));

        listA = new JList(rowA.toArray());
        listB = new JList(rowB.toArray());
        listC = new JList(rowC.toArray());

        listA.setVisibleRowCount(3);
        listB.setVisibleRowCount(3);
        listC.setVisibleRowCount(3);

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

//    public void selectSeats() {
//        List<String> list1 = listA.getSelectedValuesList();
//        List<String> list2 = listB.getSelectedValuesList();
//        List<String> list3 = listC.getSelectedValuesList();
//
//        List<String> finalSelection = new ArrayList<>();
//    }

    public void test() {
        String[] colornames = {"black", "Blue", "purple", "red", "pink", "green", "orange"};
        JList list = new JList(colornames);
        list.setVisibleRowCount(3);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        add(new JScrollPane(list));
        list.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }


    //Movie name dropdown DONE
    //Movie Seats drop down
    //Movie timing dropdown DONE
    //book button
    //ticket image


}
