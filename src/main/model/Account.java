package model;


import exceptions.NegativeBalanceException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// creates an instantiation of the user's Account, has getters for the Account's
//balance, saved list of tickets, and options to add more tickets or add to balance
public class Account implements Writable {

    private int balance;
    private static int MOVIE_PRICE = 10;
    private List<Ticket> tickets;


    // EFFECTS: constructs an account with a balance and list of tickets
    public Account(int initialBalance) {
        balance = initialBalance;
        tickets = new ArrayList<>();
    }


    public int getMoviePrice() {
        return MOVIE_PRICE;
    }


    //REQUIRES: money >= 0
    //MODIFIES: this
    //EFFECTS: adds dollar amount to Accounts current balance
    public void reload(int money) throws NegativeBalanceException {
        if (money < 0) {
            throw new NegativeBalanceException();
        }
        this.balance = balance + money;

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
        if (balance >= purchase) {
            balance = balance - purchase;
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

    // code base from JsonSerializationDemo project
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("balance", balance);
        json.put("tickets", ticketsToJson());
        return json;
    }

    // code base from JsonSerializationDemo project
    private JSONArray ticketsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Ticket t : tickets) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }
}
