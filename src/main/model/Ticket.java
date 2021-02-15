package model;

import java.util.List;
// Class to construct a Ticket object, and getters to access the ticket's information

public class Ticket {

    //constructor to make a ticket with seat(s), movie name, movie time
    //add ticket to account's list of tickets
    //add a name DONE
    //add a seat DONE
    //add a time

    private String name;
    private List<String> seats;
    private Integer time;

    public Ticket(String name, List<String> seatList, Integer time) {
        this.name = name;
        seats = seatList;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nName: " + name + " | Seats: " + seats + " | Time: " + time;
    }


}
