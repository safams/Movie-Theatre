package persistence;

import model.Account;
import model.Movie;
import model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

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
    void testWriterInvalidFileAcc() {
        try {
            Account account = new Account(100);
            JsonWriterAcc writer = new JsonWriterAcc("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException e");
        } catch (FileNotFoundException e) {
            // pass
        }
    }

    @Test
    void testWriterInvalidFileMovie() {
        try {
            JsonWriterMovie writerMovie = new JsonWriterMovie("./data/my\0illegal:fileName.json");
            writerMovie.open();
            fail("IOException e");
        } catch (FileNotFoundException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyAccount() {
        try {
            Account acc = new Account(100);
            JsonWriterAcc writer = new JsonWriterAcc("./data/testWriterEmptyAccount.json");
            writer.open();
            writer.write(acc);
            writer.close();

            JsonReaderAcc readerAcc = new JsonReaderAcc("./data/testWriterEmptyAccount.json");
            acc = readerAcc.readAccount();
            assertEquals(100, acc.getBalance());
            List<Ticket> tickets = new ArrayList<>();
            assertEquals(tickets, acc.getTickets());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyMovie() {
        try {
            JsonWriterMovie writer = new JsonWriterMovie("./data/testWriterEmptyMovie.json");
            writer.open();
            writer.write(movieList);
            writer.close();

            JsonReaderMovie readerMovie = new JsonReaderMovie("./data/testWriterEmptyMovie.json");
            movieList = readerMovie.readMovie();
            assertEquals(1, movieList.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


    @Test
    void testWriterGeneralAccount() {
        try {
            Account acc = new Account(90);
            seats = new ArrayList<>();
            seats.add("A1");
            acc.addTicket(new Ticket("Avengers", seats, 14));
            JsonWriterAcc writerAcc = new JsonWriterAcc("./data/testWriterGeneralAccount.json");
            writerAcc.open();
            writerAcc.write(acc);
            writerAcc.close();

            JsonReaderAcc readerAcc = new JsonReaderAcc("./data/testWriterGeneralAccount.json");
            acc = readerAcc.readAccount();
            assertEquals(90, acc.getBalance());
            List<Ticket> tickets = acc.getTickets();
            assertEquals(1, tickets.size());
            checkTicket("Avengers", seats, 14, tickets.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
