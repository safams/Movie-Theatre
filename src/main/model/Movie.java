package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Class to create a Movie object, with methods to add timings and seats to a movie,
// and getters to retrieve the movie name and timing and seats
public class Movie {

    private String movieName;
    private List<String> seats1;
    private List<String> seats2;
    private List<Integer> timings;

    // EFFECTS: constructs a movie with a name and two lists of seats and a list of timings
    public Movie(String movieName) {
        this.movieName = movieName;
        seats1 = new ArrayList<>();
        timings = new ArrayList<>();
        seats2 = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds seat to Movie's list of seats
    public void addSeats1(String seat) {
        seats1.add(seat);
    }

    public void addSeats2(String seat) {
        seats2.add(seat);
    }

    //MODIFIES: this
    //EFFECTS: adds time to Movie's list of timings

    public void addTimings(Integer time) {
        timings.add(time);
    }

    //REQUIRES: list != null
    //MODIFIES: this
    //EFFECTS: removes seat from movie's list of seats
    public void removeSeats1(String seat) {
        seats1.remove(seat);
    }

    public void removeSeats2(String seat) {
        seats2.remove(seat);
    }

    //REQUIRES: list != null
    //MODIFIES: this
    //EFFECTS: removes time from movie's list of timings
    public void removeTimings(Integer time) {
        timings.remove(time);
    }


    public List<String> getSeats1() {
        return seats1;
    }

    public List<String> getSeats2() {
        return seats2;
    }

    public List<Integer> getTimings() {
        return timings;
    }

    public String getMovieName() {
        return movieName;
    }

//    // code base from JsonSerializationDemo project
//    @Override
//    public JSONObject toJson() {
//        JSONObject json = new JSONObject();
//        json.put("movie name:", movieName);
//        json.put("seat list timing 1:", seats1ToJson());
//        json.put("seat list timing 2:", seats2ToJson());
//        json.put("timings:", timingsToJson());
//        return json;
//    }
//
//    // code base from JsonSerializationDemo project
//    public JSONArray seats1ToJson() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (String s : seats1) {
//            jsonArray.put(s);
//        }
//        return jsonArray;
//    }
//
//    // code base from JsonSerializationDemo project
//    public JSONArray seats2ToJson() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (String s : seats2) {
//            jsonArray.put(s);
//        }
//        return jsonArray;
//    }
//
//    // code base from JsonSerializationDemo project
//    public JSONArray timingsToJson() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (Integer i : timings) {
//            jsonArray.put(i);
//        }
//        return jsonArray;
//    }

}
