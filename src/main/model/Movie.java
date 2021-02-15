package model;

import java.util.ArrayList;
import java.util.List;

// Class to create a Movie object, with methods to add timings and seats to a movie,
// and getters to retrieve the movie name and timing and seats
public class Movie {

    private String movieName;
    private List<String> seats;
    private List<Integer> timings;

    public Movie(String movieName) {
        this.movieName = movieName;
        seats = new ArrayList<>();
        timings = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds seat to Movie's list of seats
    public void addSeats(String seat) {
        seats.add(seat);
    }
    //MODIFIES: this
    //EFFECTS: adds time to Movie's list of timings

    public void addTimings(Integer time) {
        timings.add(time);
    }

    //REQUIRES: list != null
    //MODIFIES: this
    //EFFECTS: removes seat from movie's list of seats
    public void removeSeats(String seat) {
        seats.remove(seat);
    }

    //REQUIRES: list != null
    //MODIFIES: this
    //EFFECTS: removes time from movie's list of timings
    public void removeTimings(Integer time) {
        timings.remove(time);
    }

    public List<String> getSeats() {
        return seats;
    }

    public List<Integer> getTimings() {
        return timings;
    }

    public String getMovieName() {
        return movieName;
    }

}
