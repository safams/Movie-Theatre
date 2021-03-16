package ui;

import com.sun.tools.internal.ws.processor.model.ModelVisitor;
import model.Account;
import model.Movie;
import model.Ticket;
import ui.tools.BalanceTool;
import ui.tools.BookingTool;
import ui.tools.TicketListTool;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MovieTheatreGUI {

    private static int INITIAL_BALANCE = 100;
    private Account userAcc;
    private List<Movie> movieList;
    JFrame window;
    JPanel bookingTool;
    JPanel balanceTool;
    JPanel ticketListTool;
    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    Movie movie1 = new Movie("Jumanji");
    Movie movie2 = new Movie("Avengers");
    Movie movie3 = new Movie("Interstellar");
    private static String MOVIE1NAME = "Jumanji";
    private static String MOVIE2NAME = "Avengers";
    private static String MOVIE3NAME = "Interstellar";


    public MovieTheatreGUI() {
        userAcc = new Account(INITIAL_BALANCE);
        movieList = new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        initializeMovies();
        window = new JFrame("Safa's Theatre");
        setWindow();
    }

    public void setWindow() {
        window.setSize(1000,600);
        window.setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        setBookingTool();
        setBalanceTool();
        setTicketListTool();
        window.setVisible(true);
    }

    public void setBookingTool() {
        bookingTool = new BookingTool(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        gbl.setConstraints(bookingTool, gbc);
        window.add(bookingTool);
    }

    public void setBalanceTool() {
        balanceTool = new BalanceTool(this);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbl.setConstraints(balanceTool, gbc);
        window.add(balanceTool);
    }

    public void setTicketListTool() {
        ticketListTool = new TicketListTool(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbl.setConstraints(ticketListTool, gbc);
        window.add(ticketListTool);
    }

    public int getBalance() {
        return userAcc.getBalance();
    }

    public void initializeMovies() {
        initializeMovie1(movie1);
        initializeMovie2(movie2);
        initializeMovie3(movie3);
    }

    public void initializeMovie1(Movie m1) {
        m1.addSeats1("A1");
        m1.addSeats1("A2");
        m1.addSeats1("A3");
        m1.addSeats1("B1");
        m1.addSeats1("B2");
        m1.addSeats1("B3");
        m1.addSeats1("C1");
        m1.addSeats1("C2");
        m1.addSeats1("C3");



        m1.addSeats2("A1");
        m1.addSeats2("A2");
        m1.addSeats2("A3");

        m1.addTimings(12);
        m1.addTimings(13);
    }

    //MODIFIES: this
    //EFFECTS: initializes movie 2
    public void initializeMovie2(Movie m2) {
        m2.addSeats1("A1");
        m2.addSeats1("A2");

        m2.addSeats2("A1");
        m2.addSeats2("A2");

        m2.addTimings(14);
        m2.addTimings(15);

    }

    //MODIFIES: this
    //EFFECTS: initializes movie 3
    public void initializeMovie3(Movie m3) {
        m3.addSeats1("A1");
        m3.addSeats1("A2");
        m3.addSeats1("A3");

        m3.addSeats2("B1");
        m3.addSeats2("B2");
        m3.addSeats2("B3");

        m3.addTimings(12);
        m3.addTimings(15);

    }

    public List getMovieNames() {
        List<String> movieNames = new ArrayList<>();
        movieNames.add("No movie selected");
        movieNames.add(movie1.getMovieName());
        movieNames.add(movie2.getMovieName());
        movieNames.add(movie3.getMovieName());
        return movieNames;
    }

    public void reload(int amount) {
        userAcc.reload(amount);
    }

    public Movie returnMovieFromName(String movieName) {
        Movie movie = new Movie("");
        switch (movieName) {
            case "Jumanji":
                movie = movie1;
                break;
            case "Avengers":
                movie = movie2;
                break;
            case "Interstellar":
                movie = movie3;
                break;
        }
        return movie;
    }

    public List<Integer> returnTimings(String movie) {
        List<Integer> timings = new ArrayList<>();
        if (movie.equals(movie1.getMovieName())) {
            timings = movie1.getTimings();
        } else if (movie.equals(movie2.getMovieName())) {
            timings = movie2.getTimings();
        } else if (movie.equals(movie3.getMovieName())) {
            timings = movie3.getTimings();
        }
        return timings;
    }

    public List<String> returnSeats(Movie movie, int timing) {
        int index = movie.getTimings().indexOf(timing);
        if (index == 0) {
            return movie.getSeats1();
        } else {
            return movie.getSeats2();
        }
    }

    public List<String> parseRowA(List<String> seats) {
        List<String> rowA = new ArrayList<>();
        for (String s : seats) {
            if (s.contains("A")) {
                rowA.add(s);
            }
        }
        return rowA;
    }

    public List<String> parseRowB(List<String> seats) {
        List<String> rowB = new ArrayList<>();
        for (String s : seats) {
            if (s.contains("B")) {
                rowB.add(s);
            }
        }
        return rowB;
    }

    public List<String> parseRowC(List<String> seats) {
        List<String> rowC = new ArrayList<>();
        for (String s : seats) {
            if (s.contains("C")) {
                rowC.add(s);
            }
        }
        return rowC;
    }

}
