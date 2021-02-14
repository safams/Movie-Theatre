package model;

import java.util.ArrayList;
import java.util.List;

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


    //method to add seats to movie DONE
    //method to add timings to movie DONE
    //method to remove seats from movie DONE
    //method to remove timings from movie DONE
    //method to return seats DONE
    //method to return timings DONE


}
