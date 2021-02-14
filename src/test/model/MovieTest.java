package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    Movie myMovie = new Movie("Sofa");

    @BeforeEach
    public void runBefore() {
        Movie myMovie = new Movie("Sofa");
    }

    @Test
    public void testaddSeatsEmpty() {
        assertEquals(new ArrayList<>(), myMovie.getSeats());
        myMovie.addSeats("A1");
        assertTrue(myMovie.getSeats().contains("A1"));
    }

    @Test
    public void testaddSeatsEmptyMultiple() {
        assertEquals(new ArrayList<>(), myMovie.getSeats());
        myMovie.addSeats("A1");
        assertTrue(myMovie.getSeats().contains("A1"));
        myMovie.addSeats("A3");
        assertTrue(myMovie.getSeats().contains("A3"));
    }

    @Test
    public void testaddSeatsNonEmptyMultiple() {
        assertEquals(new ArrayList<>(), myMovie.getSeats());
        myMovie.addSeats("A1");
        assertTrue(myMovie.getSeats().contains("A1"));
        myMovie.addSeats("A3");
        assertTrue(myMovie.getSeats().contains("A3"));
        myMovie.addSeats("B2");
        assertTrue(myMovie.getSeats().contains("B2"));
    }

    ////////
    @Test
    public void testdeleteSeatsOnce() {
        assertEquals(new ArrayList<>(), myMovie.getSeats());
        myMovie.addSeats("A1");
        assertTrue(myMovie.getSeats().contains("A1"));
        myMovie.removeSeats("A1");
        assertFalse(myMovie.getSeats().contains("A1"));
    }

    @Test
    public void testdeleteSeatsMultiple() {
        assertEquals(new ArrayList<>(), myMovie.getSeats());
        myMovie.addSeats("A1");
        assertTrue(myMovie.getSeats().contains("A1"));
        myMovie.addSeats("A3");
        assertTrue(myMovie.getSeats().contains("A3"));
        myMovie.removeSeats("A1");
        assertFalse(myMovie.getSeats().contains("A1"));
        myMovie.removeSeats("A3");
        assertFalse(myMovie.getSeats().contains("A3"));
    }
    ///////////

    @Test
    public void testaddTimingsEmpty() {
        assertEquals(new ArrayList<>(), myMovie.getTimings());
        myMovie.addTimings(2);
        assertTrue(myMovie.getTimings().contains(2));
    }

    @Test
    public void testaddTimingsOnce() {
        assertEquals(new ArrayList<>(), myMovie.getTimings());
        myMovie.addTimings(2);
        assertTrue(myMovie.getTimings().contains(2));
        myMovie.addTimings(10);
        assertTrue(myMovie.getTimings().contains(10));
    }

    @Test
    public void testaddTimingsMultiple() {
        assertEquals(new ArrayList<>(), myMovie.getTimings());
        myMovie.addTimings(2);
        assertTrue(myMovie.getTimings().contains(2));
        myMovie.addTimings(10);
        assertTrue(myMovie.getTimings().contains(10));
        myMovie.addTimings(19);
        assertTrue(myMovie.getTimings().contains(19));
    }

    ///////////

    @Test
    public void testremoveTimingsOnce() {
        assertEquals(new ArrayList<>(), myMovie.getTimings());
        myMovie.addTimings(2);
        assertTrue(myMovie.getTimings().contains(2));
        myMovie.removeTimings(2);
        assertFalse(myMovie.getTimings().contains(2));
    }

    @Test
    public void testremoveTimingsMultiple() {
        assertEquals(new ArrayList<>(), myMovie.getTimings());
        myMovie.addTimings(2);
        assertTrue(myMovie.getTimings().contains(2));
        myMovie.addTimings(10);
        assertTrue(myMovie.getTimings().contains(10));
        myMovie.removeTimings(2);
        assertFalse(myMovie.getTimings().contains(2));
        myMovie.removeTimings(10);
        assertFalse(myMovie.getTimings().contains(10));
    }
}
