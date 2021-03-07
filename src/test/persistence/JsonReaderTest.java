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

    @BeforeEach
    void runBefore() {
        seats = new ArrayList<>();

    }

    @Test
    void testReaderNonExistentFile() {
        JsonReaderAcc accReader = new JsonReaderAcc("./data/noSuchFile.json");
        try {
            Account account = accReader.readAccount();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyAccount() {
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
    void tstReaderGeneralAccount() {
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


}
