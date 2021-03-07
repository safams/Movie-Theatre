package persistence;

import model.Account;
import model.Movie;
import model.Ticket;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReaderAcc {
    private String source;

    public JsonReaderAcc(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Account readAccount() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAccount(jsonObject);
    }

//    public Movie readMovie() throws IOException {
//        String jsonData = readFile(source);
//        JSONObject jsonObject = new JSONObject(jsonData);
//        return parseMovie(jsonObject);
//    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Account parseAccount(JSONObject jsonObject) {
        int balance = jsonObject.getInt("balance");
        Account acc = new Account(balance);
        addTickets(acc, jsonObject);
        return acc;
    }



    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addTickets(Account acc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("tickets");
        for (Object json : jsonArray) {
            JSONObject nextTicket = (JSONObject) json;
            addTicket(acc, nextTicket);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addTicket(Account acc, JSONObject jsonObject) {
        String name = jsonObject.getString("name: ");
        JSONArray seats = jsonObject.getJSONArray("seats: ");
        List<String> seatList = new ArrayList<>();
        for (Object o : seats) {
            seatList.add(o.toString());
        }
        Integer time = jsonObject.getInt("time: ");
        Ticket ticket = new Ticket(name, seatList, time);
        acc.addTicket(ticket);
    }


}
