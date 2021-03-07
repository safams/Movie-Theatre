package persistence;

import model.Movie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReaderMovie {
    private String source;

    public JsonReaderMovie(String source) {
        this.source = source;
    }


    public List<Movie> readMovie() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMovie(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    private List<Movie> parseMovie(JSONObject jsonObject) {


        JSONArray movieJsonList = jsonObject.getJSONArray("name");
        String name1 = null;
        for (Object j : movieJsonList) {
            JSONObject json = (JSONObject) j;
            String name = json.getString("movie name:");

            JSONArray seats1 = json.getJSONArray("seat list timing 1:");
            List<String> seatList1 = new ArrayList<>();
            for (Object o : seats1) {
                seatList1.add(o.toString());
            }

            JSONArray seats2 = json.getJSONArray("seat list timing 2:");
            List<String> seatList2 = new ArrayList<>();
            for (Object o : seats2) {
                seatList2.add(o.toString());
            }

            JSONArray timingsList = json.getJSONArray("timings:");
            List<Integer> timings = new ArrayList<>();
            for (Object o : timingsList) {
                String time = o.toString();
                timings.add(Integer.parseInt(time));
            }

            name1 = name;

        }
        return jsonArray(jsonObject, name1);
    }

    private List<Movie> jsonArray(JSONObject jsonObject, String name) {
        List<Movie> movies = new ArrayList<>();
        Movie mov = new Movie(name);
        movies.add(mov);

        return movies;

    }
}
