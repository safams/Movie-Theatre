package ui;

import model.Movie;
import model.Account;
import model.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// UI class to handle the initialization of all data, and commands to run for each user input
public class MovieTheatre {

    private static final String VIEW_COMMAND = "view";
    private static final String CANCEL_COMMAND = "cancel";
    private static final String BOOK_COMMAND = "book";
    private static final String RELOAD_COMMAND = "reload";
    private static final String QUIT_COMMAND = "quit";
    private static final String GO_BACK_COMMAND = "back";

    Movie movie1 = new Movie("Jumanji");
    Movie movie2 = new Movie("Avengers");
    Movie movie3 = new Movie("Interstellar");

    private Scanner input;
    private boolean run;
    private Account userAcc;

    public MovieTheatre() {
        runTheatre();
    }

    private void runTheatre() {

        boolean keepGoing = true;
        String command = null;

        initializeMovies();
        userAcc = new Account();
        input = new Scanner(System.in);

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

    private void printInstructions() {
        System.out.println("\nMenu:");
        System.out.println("\tview   - to view balance and bookings");
        System.out.println("\treload - to reload account balance");
        System.out.println("\tbook   - to book a new ticket");
        System.out.println("\tcancel - to cancel a booking");
        System.out.println("\tquit   - to quit the program");
    }

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
            default:
                System.out.println("Selection not valid....");
        }

    }

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

    private void setViewCommand() {
        System.out.println("Current balance is: $" + userAcc.getBalance());
        if (userAcc.getTickets().isEmpty()) {
            System.out.println("Sorry, no current tickets booked");
        } else {
            System.out.println("Current tickets are :" + userAcc.getTickets());
        }
    }


    private void setBookCommand() {
        System.out.println("Type the movie name you'd like to book");
        printMovies();
        String selection = input.next();
        if (selection.equals("Jumanji")) {
            printTiming(movie1);
        } else if (selection.equals("Avengers")) {
            printTiming(movie2);
        } else if (selection.equals("Interstellar")) {
            printTiming(movie3);
        } else {
            System.out.println("Selection not valid");
        }

    }

    private void printMovies() {
        System.out.println(movie1.getMovieName());
        System.out.println(movie2.getMovieName());
        System.out.println(movie3.getMovieName());
    }

    private void printTiming(Movie movie) {
        System.out.println(movie.getTimings());
        System.out.println("Type in the timing you'd like");
        Integer selection = input.nextInt();
        if (movie.getTimings().contains(selection)) {
            movie.removeTimings(selection);
            printSeatChart(movie, selection);
        } else {
            System.out.println("Selection is invalid");
        }

    }

    private void printSeatChart(Movie movie, Integer timing) {
        System.out.println(movie.getSeats());
        System.out.println("Type in the seat you'd like");
        String selection = input.next();
        List<String> seatSelections = new ArrayList<>();
        int n = 0;
        while (movie.getSeats().contains(selection)) {
            seatSelections.add(selection);
            movie.removeSeats(selection);
            System.out.println("Type in another seat to buy, or type exit to finish purchase");
            selection = input.next();
            n++;
        }
        if (selection.equals("exit")) {
            finishPurchase(n, movie.getMovieName(), seatSelections, timing);
        }
    }

    private void finishPurchase(Integer n, String movieName, List<String> seats, Integer timing) {
        Integer balance = userAcc.getBalance();
        if (balance >= (n * userAcc.getMoviePrice())) {
            userAcc.buyTicket(n);
            Ticket ticket = new Ticket(movieName, seats, timing);
            userAcc.addTicket(ticket);
            System.out.println(ticket);
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Insufficient funds, reload account.");
        }
    }


    private void setCancelCommand() {
        System.out.println("Type out the name of the movie you wish to delete a booking for:");
        String command = input.next();
        for (Ticket ticket : userAcc.getTickets()) {
            if (command.equals(ticket.getName())) {
                userAcc.deleteTicket(ticket);
                System.out.println("Successfully cancelled booking!");
                break;
            } else {
                System.out.println("Sorry, that ticket is invalid");
            }
        }
    }



    public void initializeMovie1(Movie m1) {
        m1.addSeats("A1");
        m1.addSeats("A2");
        m1.addSeats("A3");
        m1.addSeats("B1");
        m1.addSeats("B2");
        m1.addSeats("B3");
        m1.addSeats("C1");
        m1.addSeats("C2");
        m1.addSeats("C3");

        m1.addTimings(12);
        m1.addTimings(13);
        m1.addTimings(14);
        m1.addTimings(15);
        m1.addTimings(16);
        m1.addTimings(17);
        m1.addTimings(18);
        m1.addTimings(19);
        m1.addTimings(20);

    }

    public void initializeMovie2(Movie m2) {
        m2.addSeats("A1");
        m2.addSeats("A2");
        m2.addSeats("A3");
        m2.addSeats("B1");
        m2.addSeats("B2");
        m2.addSeats("B3");

        m2.addTimings(14);
        m2.addTimings(15);
        m2.addTimings(16);
        m2.addTimings(17);
        m2.addTimings(18);
        m2.addTimings(19);
    }

    public void initializeMovie3(Movie m3) {
        m3.addSeats("A1");
        m3.addSeats("A2");
        m3.addSeats("A3");
        m3.addSeats("B1");
        m3.addSeats("B2");
        m3.addSeats("B3");

        m3.addTimings(12);
        m3.addTimings(15);
        m3.addTimings(16);
        m3.addTimings(18);
        m3.addTimings(19);
        m3.addTimings(20);
    }

    public void initializeMovies() {
        initializeMovie1(movie1);
        initializeMovie2(movie2);
        initializeMovie3(movie3);
    }
}
