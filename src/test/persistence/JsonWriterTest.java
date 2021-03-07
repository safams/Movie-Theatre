package persistence;

import model.Account;
import model.Ticket;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    List<String> seats;


    @Test
    void testWriterInvalidFile() {
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
    void testWriterEmptyAccount() {
        try {
            Account acc = new Account(100);
            JsonWriterAcc writer = new JsonWriterAcc("./data/testReaderEmptyAccount.json");
            writer.open();
            writer.write(acc);
            writer.close();

            JsonReaderAcc readerAcc = new JsonReaderAcc("./data/testReaderEmptyAccount.json");
            acc = readerAcc.readAccount();
            assertEquals(100, acc.getBalance());
            List<Ticket> tickets = new ArrayList<>();
            assertEquals(tickets, acc.getTickets());
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
            JsonWriterAcc writerAcc = new JsonWriterAcc("./data/testReaderGeneralAccount.json");
            writerAcc.open();
            writerAcc.write(acc);
            writerAcc.close();

            JsonReaderAcc readerAcc = new JsonReaderAcc("./data/testReaderGeneralAccount.json");
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
