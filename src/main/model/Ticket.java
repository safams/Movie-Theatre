package model;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getSeats() {
        return seats;
    }

    public Integer getTime() {
        return time;
    }



    @Override
    public String toString() {
        return "\nName: " + name + " Seats: " + seats + " Time: " + time;
    }


}
