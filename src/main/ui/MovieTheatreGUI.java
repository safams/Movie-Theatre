package ui;

import model.Account;
import model.Movie;
import model.Ticket;
import persistence.JsonReaderAcc;
import persistence.JsonWriterAcc;
import ui.tools.BalanceTool;
import ui.tools.BookingTool;
import ui.tools.ImageTool;
import ui.tools.TicketListTool;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// GUI class to handle the initialization and implementation of all shared data, and commands for each panel
// JSON code from JsonSerializationDemo project
public class MovieTheatreGUI {

    private static int INITIAL_BALANCE = 100;
    private List<Movie> movieList;
    JFrame window;
    Account userAcc;
    JPanel imageTool;
    JPanel bookingTool;
    JPanel balanceTool;
    JPanel ticketListTool;
    List<String> ticketList;

    private static final String JSON_STORE = "./data/account.json";
    private JsonWriterAcc jsonWriterAcc;
    private JsonReaderAcc jsonReaderAcc;





    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    Movie movie1 = new Movie("Jumanji");
    Movie movie2 = new Movie("Avengers");
    Movie movie3 = new Movie("Interstellar");


    //EFFECTS: runs the movie theatre application, initializes JSON files and movies
    public MovieTheatreGUI() {
        userAcc = new Account(INITIAL_BALANCE);
        movieList = new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        initializeMovies();
        window = new JFrame("Movie Theatre");
        setWindow();
        jsonWriterAcc = new JsonWriterAcc(JSON_STORE);
        jsonReaderAcc = new JsonReaderAcc(JSON_STORE);


    }


    //MODIFIES: this
    //EFFECTS: sets up window that houses all 4 panels, calls to initialize each panel
    public void setWindow() {
        window.setSize(1500,700);
        window.setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        ticketList = new ArrayList<>();
        ticketList.add("Your booked Tickets");

        setBookingTool();
        setBalanceTool();
        setTicketListTool();
        setImageTool();
        window.setVisible(true);
    }


    //MODIFIES: this
    //EFFECTS: intializes balance tool panel
    public void setBalanceTool() {
        balanceTool = new BalanceTool(this);
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(balanceTool, gbc);
        window.add(balanceTool);
    }

    //MODIFIES: this
    //EFFECTS: initializes ticket list tool panel
    public void setTicketListTool() {
        ticketListTool = new TicketListTool(this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        gbl.setConstraints(ticketListTool, gbc);
        window.add(ticketListTool);
    }

    //MODIFIES: this
    //EFFECTS: initializes booking tool panel
    public void setBookingTool() {
        bookingTool = new BookingTool(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 3;
        gbl.setConstraints(bookingTool, gbc);
        window.add(bookingTool);
    }

    //MODIFIES: this
    //EFFECTS: initializes image tool panel
    public void setImageTool() {
        imageTool = new ImageTool(this);
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbl.setConstraints(imageTool, gbc);
        window.add(imageTool);
    }

    //EFFECTS: returns user's account balance
    public int getBalance() {
        return userAcc.getBalance();
    }

    //MODIFIES: this
    //EFFECTS: calls to initalize each of the 3 movies
    public void initializeMovies() {
        initializeMovie1(movie1);
        initializeMovie2(movie2);
        initializeMovie3(movie3);
    }

    //MODIFIES: this
    //EFFECTS: initializes movie 1's seats and timings
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
        m1.addSeats2("B1");
        m1.addSeats2("B2");
        m1.addSeats2("B3");
        m1.addSeats2("C1");
        m1.addSeats2("C2");
        m1.addSeats2("C3");

        m1.addTimings(1200);
        m1.addTimings(1300);
    }

    //MODIFIES: this
    //EFFECTS: initializes movie 2
    public void initializeMovie2(Movie m2) {
        m2.addSeats1("A1");
        m2.addSeats1("A2");
        m2.addSeats1("B1");
        m2.addSeats1("B2");

        m2.addSeats2("A1");
        m2.addSeats2("A2");
        m2.addSeats2("B1");
        m2.addSeats2("B2");

        m2.addTimings(1400);
        m2.addTimings(1500);

    }

    //MODIFIES: this
    //EFFECTS: initializes movie 3
    public void initializeMovie3(Movie m3) {
        m3.addSeats1("A1");
        m3.addSeats1("A2");
        m3.addSeats1("A3");
        m3.addSeats1("B1");
        m3.addSeats1("B2");
        m3.addSeats1("B3");

        m3.addSeats2("A1");
        m3.addSeats2("A2");
        m3.addSeats2("A3");
        m3.addSeats2("B1");
        m3.addSeats2("B2");
        m3.addSeats2("B3");

        m3.addTimings(1200);
        m3.addTimings(1500);

    }

    //EFFECTS: returns the movie names as a list of strings
    public List getMovieNames() {
        List<String> movieNames = new ArrayList<>();
        movieNames.add("No movie selected");
        movieNames.add(movie1.getMovieName());
        movieNames.add(movie2.getMovieName());
        movieNames.add(movie3.getMovieName());
        return movieNames;
    }

    //MODIFIES: this
    //EFFECTS: adds "amount" into user's account balance
    public void reload(int amount) {
        userAcc.reload(amount);
    }

    //EFFECTS: given the movie name, returns its corresponding movie object
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

    //EFFECTS: returns the timings for the given movie name
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

    //EFFECTS: returns correct seatlists for the given movie's given timing
    public List<String> returnSeats(Movie movie, int timing) {
        int index = movie.getTimings().indexOf(timing);
        if (index == 0) {
            return movie.getSeats1();
        } else {
            return movie.getSeats2();
        }
    }

    //EFFECTS: stores boolean of whether seatlist 1 or 2 was chosen for given movie
    public Boolean returnSeats1(Movie movie, int timing) {
        int index = movie.getTimings().indexOf(timing);
        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }

    //EFFECTS: returns a new list of all strings in "Seats" containing "A"
    public List<String> parseRowA(List<String> seats) {
        List<String> rowA = new ArrayList<>();
        for (String s : seats) {
            if (s.contains("A")) {
                rowA.add(s);
            }
        }
        return rowA;
    }

    //EFFECTS: returns a new list of all strings in "Seats" containing "B"
    public List<String> parseRowB(List<String> seats) {
        List<String> rowB = new ArrayList<>();
        for (String s : seats) {
            if (s.contains("B")) {
                rowB.add(s);
            }
        }
        return rowB;
    }

    //EFFECTS: returns a new list of all strings in "Seats" containing "C"
    public List<String> parseRowC(List<String> seats) {
        List<String> rowC = new ArrayList<>();
        for (String s : seats) {
            if (s.contains("C")) {
                rowC.add(s);
            }
        }
        return rowC;
    }

    //MODIFIES: this
    //EFFECTS: constructs user's new purchased ticket, takes the purchase price out of their account,
    //         and updates the balance tool and ticketlist tool panels
    public Ticket finishPurchase(String movie, int timing, List seats) {
        Ticket newTicket = new Ticket(movie, seats, timing);
        userAcc.addTicket(newTicket);
        int i = seats.size();
        userAcc.buyTicket(i);
        reAdd();
        balanceTool.revalidate();
        ticketListTool.revalidate();
        return newTicket;
    }

    //EFFECTS: return's user's list of tickets
    public List<Ticket> getTicketList() {
        return userAcc.getTickets();
    }


    //MODIFIES: this
    //EFFECTS: removes user's chosen seats from the movie's available seats in seatlist 1
    public void removeThingsSeats1(String movie, List<String> seats) {
        Movie x = returnMovieFromName(movie);
        for (String s : seats) {
            if (x.getSeats1().contains(s)) {
                x.getSeats1().remove(s);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: removes user's chosen seats from the movie's available seats in seatlist 2
    public void removeThingsSeats2(String movie, List<String> seats) {
        Movie x = returnMovieFromName(movie);
        for (String s : seats) {
            if (x.getSeats2().contains(s)) {
                x.getSeats2().remove(s);
            }
        }
    }

    // code base from JsonSerializationDemo project
    //EFFECTS: save's user's account info to file
    public void save() throws FileNotFoundException {
        jsonWriterAcc.open();
        jsonWriterAcc.write(userAcc);
        jsonWriterAcc.close();
    }

    // code base from JsonSerializationDemo project
    //MODIFIES: this
    //EFFECTS: load's and updates user's account info from file
    public void load() throws IOException {
        userAcc = jsonReaderAcc.readAccount();
        reAdd();
        balanceTool.revalidate();
        ticketListTool.revalidate();
    }

    //MODIFIES: this
    //EFFECTS: re-add's ticket list tool and balance tool to window if they've been removed
    public void reAdd() {
        window.remove(balanceTool);
        window.remove(ticketListTool);
        window.setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        setBalanceTool();
        setTicketListTool();
    }



    //MODIFIES: this
    //EFFECTS: deletes ticket from user's list of tickets, and gives them a refund accordingly, and updates
    //         balance panel and ticket list panel
    public void cancelPurchase(int index) {
        Ticket delete = userAcc.getTickets().get(index);
        int numSeats = delete.getSeats().size();
        int refund = numSeats * userAcc.getMoviePrice();
        userAcc.deleteTicket(delete);
        userAcc.reload(refund);
        reAdd();
        balanceTool.revalidate();
        ticketListTool.revalidate();
    }



}
