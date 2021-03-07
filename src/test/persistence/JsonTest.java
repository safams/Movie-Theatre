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
}