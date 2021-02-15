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

    public void addSeats(String seat) {
        seats.add(seat);
    }

    public void addTimings(Integer time) {
        timings.add(time);
    }

    public void removeSeats(String seat) {
        seats.remove(seat);
    }

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
