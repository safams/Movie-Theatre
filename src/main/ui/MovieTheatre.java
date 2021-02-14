package ui;

import com.sun.tools.javac.comp.Todo;
import com.sun.xml.internal.bind.v2.TODO;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import model.Movie;
import model.Account;
import model.Ticket;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieTheatre {

    private static final String VIEW_COMMAND = "view";
    private static final String CANCEL_COMMAND = "cancel";
    private static final String BOOK_COMMAND = "book";
    private static final String RELOAD_COMMAND = "reload";
    private static final String QUIT_COMMAND = "quit";
    private static final String GO_BACK_COMMAND = "back";

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

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                commandOptions(command);
            }
        }
    }

    private void printInstructions() {
        System.out.println("\nMenu:");
        System.out.println("\tview   - to view balance and bookings");
        System.out.println("\tcancel - to cancel a booking");
        System.out.println("\tbook   - to book a new ticket");
        System.out.println("\treload - to reload account balance");
        System.out.println("\tquit   - to quit the program");
        System.out.println("\tback   - to go back at any time");
    }

    private void commandOptions(String command) {
        switch (command) {
            case RELOAD_COMMAND:
                setReloadCommand();
                break;
            case BOOK_COMMAND:
                addMore();
                break;
            case CANCEL_COMMAND:
                setCancelCommand();
                break;
            case VIEW_COMMAND:
                setViewCommand();
                break;
            case GO_BACK_COMMAND:
                printInstructions();
                break;
            default:
                System.out.println("Selection not valid....");
        }

    }

    private void setReloadCommand() {
        System.out.println("Current balance is: $" + userAcc.getBalance());
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
        System.out.println("Current tickets are :" + userAcc.getTickets());
    }

    //TODO set the display movies choose a movie, set the choose timing, choose seats
    private void setBookCommand() {


    }

    private void setCancelCommand() {
        System.out.println("Type out the name of the movie you wish to delete a booking for:");
        String command = input.next();

        for (Ticket ticket : userAcc.getTickets()) {
            if (command.equals(ticket.getName())) {
                userAcc.deleteTicket(ticket);
                break;
            }
        }
    }

    //TODO just for testing, delete later
    private void addMore() {
        List<String> seats = new ArrayList<>();
        seats.add("3");
        Ticket ticket = new Ticket("Safa", seats, 3);
        Ticket ticket2 = new Ticket("Sara", seats, 7);
        userAcc.addTicket(ticket2);
        userAcc.addTicket(ticket);
    }



//print intstructions DONE

//print BookedMovies

//return balance

//printBooked Movies names

//printMovietitle list

//print Timings

//print SeatChart


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
        Movie movie1 = new Movie("Jumanji");
        Movie movie2 = new Movie("Avengers");
        Movie movie3 = new Movie("Choco Milk");
        initializeMovie1(movie1);
        initializeMovie2(movie2);
        initializeMovie3(movie3);
    }
}
