package model;
import exceptions.NegativeBalanceException;
import model.Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
// Test Class for Account
public class AccountTest {

    private Account acc1;
    private static int INITIAL_BALANCE = 100;

    @BeforeEach
    public void runBefore() {
         acc1 = new Account(INITIAL_BALANCE);
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("J", seats, 3);
    }

    @Test
    public void testReloadNoException(){
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        try {
            acc1.reload(100);
        } catch (NegativeBalanceException e) {
            fail("Shouldn't have thrown exception");
        }
        assertEquals(200, acc1.getBalance());
    }

    @Test
    public void testReloadExceptionThrown(){
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        try {
            acc1.reload(-100);
            fail("Negative exception should've been thrown");
        } catch (NegativeBalanceException e) {
            //
        }
        assertEquals(100, acc1.getBalance());
    }


    @Test
    public void testBuyTicketOncOneSeat() {
        // check that balance is INITIAL_BALANCE
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        // buy a ticket
        assertTrue(acc1.buyTicket(1));
        // check that balance is equal to new lower balance
        int deduction = acc1.getMoviePrice() * 1;
        assertEquals(100 - deduction, acc1.getBalance());
    }

    @Test
    public void testBuyTicketMultipleOneSeat(){
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        assertTrue(acc1.buyTicket(1));
        assertEquals(90, acc1.getBalance());
        assertTrue(acc1.buyTicket(1));
        assertEquals(80, acc1.getBalance());
    }


    @Test
        public void testBuyTicketOncMultipleSeats(){
            // check that balance is INITIAL_BALANCE
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
            // buy a ticket
            assertTrue(acc1.buyTicket(3));
            assertEquals(70, acc1.getBalance());
        }

    @Test
    public void testBuyTicketMultipleMultipleSeats(){
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        assertTrue(acc1.buyTicket(2));
        assertEquals(80, acc1.getBalance());
        assertTrue(acc1.buyTicket(2));
        assertEquals(60, acc1.getBalance());
        }


    @Test
    public void testBuyTicketInsufficient(){
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        assertTrue(acc1.buyTicket(1));
        assertEquals(90, acc1.getBalance());
        assertFalse(acc1.buyTicket(10));
    }

    @Test
    public void testBuyTicketJustEnough(){
        assertEquals(INITIAL_BALANCE, acc1.getBalance());
        assertTrue(acc1.buyTicket(10));
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

    @Test
    public void initialize(){
        List<String>  seats = new ArrayList<>();
        Ticket ticket1 = new Ticket("Sofa", seats, 2);
        Ticket ticket2 = new Ticket("J", seats, 3);
    }
}
