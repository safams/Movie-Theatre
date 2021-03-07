package ui;

import model.Movie;
import model.Account;
import model.Ticket;
import persistence.JsonReaderAcc;
import persistence.JsonReaderMovie;
import persistence.JsonWriterAcc;
import persistence.JsonWriterMovie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// UI class to handle the initialization of all data, and commands to run for each user input
// JSON code from JsonSerializationDemo project
public class MovieTheatre {

    private static final String JSON_STORE = "./data/account.json";
    private static final String JSON_STORE2 = "./data/movie.json";
    private static final String VIEW_COMMAND = "view";
    private static final String CANCEL_COMMAND = "cancel";
    private static final String BOOK_COMMAND = "book";
    private static final String RELOAD_COMMAND = "reload";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";
    private static final String QUIT_COMMAND = "quit";

    private static int INITIAL_BALANCE = 100;

    private JsonWriterAcc jsonWriterAcc;
    private JsonReaderAcc jsonReaderAcc;
    private JsonWriterMovie jsonWriterMovie;
    private JsonReaderMovie jsonReaderMovie;

    private List<Movie> movieList;

    private Scanner input;
    private Account userAcc;


    //EFFECTS: runs the movie theatre application
    public MovieTheatre() {
        movieList = new ArrayList<Movie>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        runTheatre();
    }


    Movie movie1 = new Movie("Jumanji");
    Movie movie2 = new Movie("Avengers");
    Movie movie3 = new Movie("Interstellar");

    //source: TellerApp
    //MODIFIES: this
    //EFFECTS: proccesses user input
    private void runTheatre() {

        boolean keepGoing = true;
        String command = null;

        initializeMovies();
        userAcc = new Account(INITIAL_BALANCE);
        input = new Scanner(System.in);

        jsonWriterAcc = new JsonWriterAcc(JSON_STORE);
        jsonReaderAcc = new JsonReaderAcc(JSON_STORE);
        jsonWriterMovie = new JsonWriterMovie(JSON_STORE2);
        jsonReaderMovie = new JsonReaderMovie(JSON_STORE2);

        while (keepGoing) {
            printInstructions();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals(QUIT_COMMAND)) {
                System.out.println("Thank you for using our service!");
                keepGoing = false;
            } else {
                commandOptions(command);
            }
        }
    }

    //EFFECTS: displays all menu options
    private void printInstructions() {
        System.out.println("\nMenu:");
        System.out.println("\tview   - to view balance and bookings");
        System.out.println("\treload - to reload account balance");
        System.out.println("\tbook   - to book a new ticket");
        System.out.println("\tcancel - to cancel a booking");
        System.out.println("\tsave   - to save information to file");
        System.out.println("\tload   - to load information from file");
        System.out.println("\tquit   - to quit the program");
    }

    //MODIFIES: this
    //EFFECTS: processes user commands
    private void commandOptions(String command) {
        switch (command) {
            case RELOAD_COMMAND:
                setReloadCommand();
                break;
            case BOOK_COMMAND:
                setBookCommand();
                break;
            case CANCEL_COMMAND:
                setCancelCommand();
                break;
            case VIEW_COMMAND:
                setViewCommand();
                break;
            case SAVE_COMMAND:
                saveInformation();
                break;
            case LOAD_COMMAND:
                loadInformation();
                break;
            default:
                System.out.println("Selection not valid....");
        }

    }

    //MODIFIES: this
    //EFFECTS: conducts an account balance reload
    private void setReloadCommand() {
        System.out.println("Current balance is: $" + userAcc.getBalance());
        System.out.println("Current movie ticket price/seat is: $" + userAcc.getMoviePrice());
        System.out.println("Enter dollar amount to load into your account: $ ");
        Integer amount = input.nextInt();

        if (amount >= 0) {
            userAcc.reload(amount);
            System.out.println("New balance is: \n$" + userAcc.getBalance());
        } else {
            System.out.println("Negative amount is invalid");
        }
    }

    //EFFECTS: prints out current balance and booked tickets
    private void setViewCommand() {
        System.out.println("Current balance is: $" + userAcc.getBalance());
        if (userAcc.getTickets().isEmpty()) {
            System.out.println("Sorry, no current tickets booked");
        } else {
            System.out.println("Current tickets are :");
            for (Ticket ticket : userAcc.getTickets()) {
                System.out.println(toString(ticket));
            }
        }
    }


    //EFFECTS: processes user's movie name choice
    private void setBookCommand() {
        System.out.println("Type the movie name you'd like to book");
        printMovies();
        String selection = input.next();
        if (selection.equals(movie1.getMovieName())) {
            printTiming(movie1);
        } else if (selection.equals(movie2.getMovieName())) {
            printTiming(movie2);
        } else if (selection.equals(movie3.getMovieName())) {
            printTiming(movie3);
        } else {
            System.out.println("Selection not valid");
        }

    }


    //EFFECTS: prints out all movie names to screen
    private void printMovies() {
        System.out.println(movie1.getMovieName());
        System.out.println(movie2.getMovieName());
        System.out.println(movie3.getMovieName());
    }

    //MODIFIES: this
    //EFFECTS: processes user's movie timing choice
    private void printTiming(Movie movie) {
        System.out.println(movie.getTimings());
        System.out.println("Type in the timing you'd like");
        Integer selection = input.nextInt();
        if (movie.getTimings().contains(selection)) {
            int index = movie.getTimings().indexOf(selection);
            //movie.removeTimings(selection);
            printSeatChart(movie, selection, index);
        } else {
            System.out.println("Selection is invalid");
        }

    }

    //MODIFIES: this
    //EFFECTS: processes user's seat selection choices
    private void printSeatChart(Movie movie, Integer timing, int index) {
        if (index == 0) {
            purchaseSeat1(movie, timing, index);
        } else {
            purchaseSeat2(movie, timing, index);
        }
    }

    private void purchaseSeat1(Movie movie, Integer timing, int index) {
        System.out.println(movie.getSeats1());
        System.out.println("Type in the seat you'd like");
        String selection = input.next();
        List<String> seatSelections = new ArrayList<>();
        int numSeats = 0;
        while (movie.getSeats1().contains(selection)) {
            seatSelections.add(selection);
            movie.removeSeats1(selection);
            System.out.println("Type in another seat to buy, or type exit to finish purchase");
            selection = input.next();
            numSeats++;
        }
        if (selection.equals("exit")) {
            finishPurchase(numSeats, movie.getMovieName(), seatSelections, timing);
        }
    }

    private void purchaseSeat2(Movie movie, Integer timing, int index) {
        System.out.println(movie.getSeats2());
        System.out.println("Type in the seat you'd like");
        String selection = input.next();
        List<String> seatSelections = new ArrayList<>();
        int numSeats = 0;
        while (movie.getSeats2().contains(selection)) {
            seatSelections.add(selection);
            movie.removeSeats2(selection);
            System.out.println("Type in another seat to buy, or type exit to finish purchase");
            selection = input.next();
            numSeats++;
        }
        if (selection.equals("exit")) {
            finishPurchase(numSeats, movie.getMovieName(), seatSelections, timing);
        }
    }

    //MODIFIES: this
    //EFFECTS: finalizes user's purchase, saves booking to account and prints out ticket
    private void finishPurchase(Integer n, String movieName, List<String> seats, Integer timing) {
        Integer balance = userAcc.getBalance();
        if (balance >= (n * userAcc.getMoviePrice())) {
            userAcc.buyTicket(n);
            Ticket ticket = new Ticket(movieName, seats, timing);
            userAcc.addTicket(ticket);
            System.out.println("***************************************************");
            System.out.println(toString(ticket));
            System.out.println("***************************************************");
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Insufficient funds, reload account.");
        }
    }

    // code base from JsonSerializationDemo project
    // EFFECTS: saves account to file
    private void saveInformation() {
        try {
            jsonWriterAcc.open();
            jsonWriterMovie.open();
            jsonWriterMovie.write(movieList);
            jsonWriterAcc.write(userAcc);
            jsonWriterAcc.close();
            jsonWriterMovie.close();
            System.out.println("Account info saved to " + JSON_STORE);
            System.out.println("Movie info saved to " + JSON_STORE2);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE + "and " + JSON_STORE2);
        }
    }

    // code base from JsonSerializationDemo project
    // MODIFIES: this
    // EFFECTS: loads the account from file
    private void loadInformation() {
        try {
            userAcc = jsonReaderAcc.readAccount();
            movieList = jsonReaderMovie.readMovie();
            System.out.println("Account info loaded from " + JSON_STORE);
            System.out.println("Movie info loaded from " + JSON_STORE2);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE + "and " + JSON_STORE2);
        }
    }


    //MODIFIES: this
    //EFFECTS: deletes user's selection of ticket from booked ticket list
    private void setCancelCommand() {
        System.out.println("Your current booked movie tickets are:");
        int index = 1;
        for (Ticket ticket : userAcc.getTickets()) {
            System.out.println(index + ": " + toString(ticket));
            index++;
        }
        System.out.println("\nType the number of the ticket to delete its booking:");
        int command = input.nextInt();
        if (command <= userAcc.getTickets().size()) {
            Ticket selection = userAcc.getTickets().get(command - 1);
            for (Ticket ticket : userAcc.getTickets()) {
                if (selection.equals(ticket)) {
                    userAcc.deleteTicket(ticket);
                    int refund = userAcc.getMoviePrice() * ticket.getSeats().size();
                    userAcc.reload(refund);
                    System.out.println("Successfully cancelled booking!");
                    break;
                }
            }
        } else {
            System.out.println("Invalid selection");
        }
//
    }


    //todo sold out movies

    //MODIFIES: this
    //EFFECTS: initializes movie 1
    public void initializeMovie1(Movie m1) {
        m1.addSeats1("A1");
        m1.addSeats1("A2");
        m1.addSeats1("A3");
        m1.addSeats1("B1");
        m1.addSeats1("B2");
        m1.addSeats1("B3");
        m1.addSeats1("C1");

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
        m2.addSeats1("B1");
        m2.addSeats1("B2");

        m2.addSeats2("A1");
        m2.addSeats2("A2");
        m2.addSeats2("A3");
        m2.addSeats2("B1");
        m2.addSeats2("B2");
        m2.addSeats2("B3");

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

    //MODIFIES: this
    //EFFECTS: sets up movie initializing methods
    public void initializeMovies() {
        initializeMovie1(movie1);
        initializeMovie2(movie2);
        initializeMovie3(movie3);
    }

    public String toString(Ticket ticket) {
        return "Name: " + ticket.getName() + " | Seats: " + ticket.getSeats() + " | Time: " + ticket.getTime();
    }
}
