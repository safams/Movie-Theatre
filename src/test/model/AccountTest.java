package model;
import model.Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// Test Class for Account
public class AccountTest {

    private Account acc1;

    @BeforeEach
    public void runBefore() {
         acc1 = new Account();
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("J", seats, 3);
    }

    @Test
    public void testReload(){
        // check that balance is INITIAL_BALANCE
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
        // add money
        acc1.reload(100);
        // check that new balance is equal to new money
        assertEquals(600, acc1.getBalance());
    }

    //////////////////////
    @Test
    public void testBuyTicketOncOneSeat() {
        // check that balance is INITIAL_BALANCE
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
        // buy a ticket
        assertTrue(acc1.buyTicket(1));
        // check that balance is equal to new lower balance
        assertEquals(400, acc1.getBalance());
    }

    @Test
    public void testBuyTicketMultipleOneSeat(){
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
        assertTrue(acc1.buyTicket(1));
        assertEquals(400, acc1.getBalance());
        assertTrue(acc1.buyTicket(1));
        assertEquals(300, acc1.getBalance());
    }


    @Test
        public void testBuyTicketOncMultipleSeats(){
            // check that balance is INITIAL_BALANCE
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
            // buy a ticket
            assertTrue(acc1.buyTicket(3));
            assertEquals(200, acc1.getBalance());
        }

    @Test
    public void testBuyTicketMultipleMultipleSeats(){
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
        assertTrue(acc1.buyTicket(2));
        assertEquals(300, acc1.getBalance());
        assertTrue(acc1.buyTicket(2));
        assertEquals(100, acc1.getBalance());
        }


    @Test
    public void testBuyTicketInsufficient(){
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
        assertTrue(acc1.buyTicket(1));
        assertEquals(400, acc1.getBalance());
        assertFalse(acc1.buyTicket(5));
    }

    @Test
    public void testBuyTicketJustEnough(){
        assertEquals(acc1.getInitialBalance(), acc1.getBalance());
        assertTrue(acc1.buyTicket(5));
        assertEquals(0,acc1.getBalance());
    }

    ////////////////

    @Test
    public void testDeleteTicketOnce(){
        assertEquals(new ArrayList<>(), acc1.getTickets());
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("Jas", seats, 3);
        acc1.addTicket(ticket1);
        assertTrue(acc1.getTickets().contains(ticket1));
        acc1.deleteTicket(ticket1);
        assertFalse(acc1.getTickets().contains(ticket1));
    }

    @Test
    public void testDeleteTicketMultiple(){
        assertEquals(new ArrayList<>(), acc1.getTickets());
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("Jas", seats, 3);
        acc1.addTicket(ticket1);
        assertTrue(acc1.getTickets().contains(ticket1));
        acc1.addTicket(ticket2);
        assertTrue(acc1.getTickets().contains(ticket2));
        acc1.deleteTicket(ticket1);
        assertFalse(acc1.getTickets().contains(ticket1));
        acc1.deleteTicket(ticket2);
        assertFalse(acc1.getTickets().contains(ticket2));
    }

    ////////////////
    @Test
    public void testAddTicketEmptyList(){
        assertEquals(new ArrayList<>(), acc1.getTickets());
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("Jas", seats, 3);
        acc1.addTicket(ticket1);
        assertTrue(acc1.getTickets().contains(ticket1));
    }

    @Test
    public void testAddTicketNonEmptyOnce(){
        assertEquals(new ArrayList<>(), acc1.getTickets());
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("Jas", seats, 3);
        acc1.addTicket(ticket1);
        assertTrue(acc1.getTickets().contains(ticket1));
        acc1.addTicket(ticket2);
        assertTrue(acc1.getTickets().contains(ticket2));
    }

    @Test
    public void testAddTicketNonEmptyMultiple(){
        assertEquals(new ArrayList<>(), acc1.getTickets());
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("Jas", seats, 3);
        Ticket ticket3 = new Ticket("Sara", seats, 3);
        acc1.addTicket(ticket1);
        assertTrue(acc1.getTickets().contains(ticket1));
        acc1.addTicket(ticket2);
        assertTrue(acc1.getTickets().contains(ticket2));
        acc1.addTicket(ticket3);
        assertTrue(acc1.getTickets().contains(ticket3));
    }

    public void initialize(){
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("J", seats, 3);
    }
}
