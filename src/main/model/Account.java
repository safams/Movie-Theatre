package model;


import java.util.ArrayList;
import java.util.List;

// creates an instantiation of the user's Account, has getters for the Account's
//balance, saved list of tickets, and options to add more tickets or add to balance
public class Account {

    private int balance;
    private static int MOVIE_PRICE = 100;
    private static int INITIAL_BALANCE = 500;
    private List<Ticket> tickets;


    public Account() {
        balance = INITIAL_BALANCE;
        tickets = new ArrayList<>();
    }

    public int getInitialBalance() {
        return INITIAL_BALANCE;
    }

    public int getMoviePrice() {
        return MOVIE_PRICE;
    }


    //REQUIRES: money >= 0
    //MODIFIES: this
    //EFFECTS: adds dollar amount to Accounts current balance
    public void reload(int money) {
        this.balance = getBalance() + money;

    }

    public int getBalance() {
        return balance;
    }


    //MODIFIES: this
    //EFFECTS: if there is sufficient balance,
    //         subtracts price from balance and returns true,
    //         else returns false
    public boolean buyTicket(Integer numSeats) {
        int purchase = numSeats * MOVIE_PRICE;
        if (getBalance() >= purchase) {
            balance = getBalance() - purchase;
            return true;
        } else {
            return false;
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    //REQUIRES: list !=null
    //MODIFIES: this
    //EFFECTS: removes ticket from saved ticket list
    public void deleteTicket(Ticket ticket) {
        tickets.remove(ticket);
    }


    //MODIFIES: this
    //EFFECTS: adds ticket to saved ticket list

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

}
