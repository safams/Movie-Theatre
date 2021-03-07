package model;
import model.Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// Test Class for Ticket
public class TicketTest {

    private Ticket ticket;
    private List<String> seats;

    @BeforeEach
    public void runBefore() {
        seats = new ArrayList<>();
        seats.add("A");
        ticket = new Ticket("Safa", seats, 13);
    }

    @Test
    public void testGetters() {
        assertEquals("Safa", ticket.getName());
        assertEquals(seats, ticket.getSeats());
        assertEquals(13, ticket.getTime());
    }




}
