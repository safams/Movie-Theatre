package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
// Class to construct a Ticket object, and getters to access the ticket's information


public class Ticket implements Writable {

    private String name;
    private List<String> seats;
    private Integer time;

    // EFFECTS: constructs a booked ticket with a name, list of seats, and time
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


    // code base from JsonSerializationDemo project
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name: ", name);
        json.put("seats: ", seatsToJson());
        json.put("time: ", time);
        return json;
    }

    // code base from JsonSerializationDemo project
    public JSONArray seatsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (String s : seats) {
            jsonArray.put(s);
        }

        return jsonArray;
    }


}
