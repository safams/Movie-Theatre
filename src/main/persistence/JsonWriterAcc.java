package persistence;

import model.*;
import org.json.JSONObject;


import java.io.*;

// Represents a writer that writes JSON representation of account to file
// code from JsonSerializationDemo project
public class JsonWriterAcc {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriterAcc(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of account to file
    public void write(Account acc) {
        JSONObject json = acc.toJson();
        saveToFile(json.toString(TAB));
    }



    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}
