package model;


import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance;
    private static int MOVIE_PRICE = 100;
    private static int INITIAL_BALANCE = 500;
    private List<Ticket> tickets;


    public Account() {
        balance = INITIAL_BALANCE;
        tickets = new ArrayList<>();
    }

    public void reload(int money) {
        this.balance = getBalance() + money;

    }

    public int getBalance() {
        return balance;
    }

    public void buyTicket(Integer numSeats) {
        int purchase = numSeats * MOVIE_PRICE;
        this.balance = getBalance() - purchase;
    }

    public List<Ticket> getBookings() {
        return tickets;
    }

    public void deleteBookings(Ticket ticket) {
        tickets.remove(ticket);
    }

    //set initial balance to 500
    //method to reload money
    //method to return the balance
    //method to deduct price from balance
    //method to return list of tickets
    //method to delete ticket from list of tickets


}
