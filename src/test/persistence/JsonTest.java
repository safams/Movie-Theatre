package persistence;

import model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTicket(String movieName, List<String> seats, int time, Ticket ticket) {
        assertEquals(movieName, ticket.getName());
        assertEquals(seats, ticket.getSeats());
        assertEquals(time, ticket.getTime());
    }

    protected void checkMovie(String movieName, List seats1, List seats2, List time, Movie movie) {
        assertEquals(movieName, movie.getMovieName());
        assertEquals(seats1, movie.getSeats1());
        assertEquals(seats2, movie.getSeats2());
        assertEquals(time, movie.getTimings());
    }
}