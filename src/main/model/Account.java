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

    public int getInitialBalance() {
        return INITIAL_BALANCE;
    }


    public void reload(int money) {
        this.balance = getBalance() + money;

    }

    public int getBalance() {
        return balance;
    }


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
    public void deleteTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }




    //set initial balance to 500 DONE
    //method to reload money DONE
    //method to return the balance DONE
    //method to deduct price from balance DONE
    //method to return list of tickets DONE
    //method to delete ticket from list of tickets DONE
    //method to add ticket to list of tickets DONE


}
