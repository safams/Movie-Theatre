package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class JsonReaderTest extends JsonTest{

    List<String> seats;
    List<String> seats1;
    List<String> seats2;
    List<Integer> timings;
    List<Movie> movieList;

    @BeforeEach
    void runBefore() {
        seats = new ArrayList<>();
        seats1 = new ArrayList<>();
        seats2 = new ArrayList<>();
        timings = new ArrayList<>();
        movieList = new ArrayList<>();

    }

    @Test
    void testReaderNonExistentFileAcc() {
        JsonReaderAcc accReader = new JsonReaderAcc("./data/noSuchFile.json");
        try {
            Account account = accReader.readAccount();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderNonExistentFileMovie() {
        JsonReaderMovie movReader = new JsonReaderMovie("./data/noSuchFile.json");
        try {
            movieList = movReader.readMovie();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyAccountAcc() {
        JsonReaderAcc accReader = new JsonReaderAcc("./data/testReaderEmptyAccount.json");
        try {
            Account account = accReader.readAccount();
            assertEquals(100, account.getBalance());
            List<Ticket> tickets = new ArrayList<>();
            assertEquals(tickets, account.getTickets());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmptyMovie() {
        JsonReaderMovie movReader = new JsonReaderMovie("./data/testReaderEmptyMovie.json");
        try {
            movieList = movReader.readMovie();
            assertEquals(1, movieList.size());
        } catch (IOException e) {
            fail("couldn't read from file");
        }
    }

    @Test
    void tstReaderGeneralAccountAcc() {
        JsonReaderAcc reader = new JsonReaderAcc("./data/testReaderGeneralAccount.json");
        try {
            Account acc = reader.readAccount();
            assertEquals(90, acc.getBalance());
            List<Ticket> tickets = acc.getTickets();
            assertEquals(1, tickets.size());
            seats.add("A1");
            checkTicket("Avengers", seats, 14, tickets.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMovie() {
        JsonReaderMovie readerMovie = new JsonReaderMovie("./data/testReaderGeneralMovie.json");
        try {
            movieList = readerMovie.readMovie();
            checkMovie("Jumanji", seats1, seats2, timings, movieList.get(0) );
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
