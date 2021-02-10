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



    //method to add seats to movie
    //method to add timings to movie
    //method to return seats
    //method to return timings


}
