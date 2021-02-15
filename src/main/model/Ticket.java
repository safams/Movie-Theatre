package model;

import java.util.List;
// Class to construct a Ticket object, and getters to access the ticket's information

public class Ticket {

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

    //EFFECTS: overrides Java's toSTring method, prints out a Ticket
    @Override
    public String toString() {
        return "\nName: " + name + " | Seats: " + seats + " | Time: " + time;
    }


}
