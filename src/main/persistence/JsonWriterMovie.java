//package persistence;
//
//import model.Movie;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.List;
//
//// Represents a writer that writes JSON representation of movie list to file
//// code from JsonSerializationDemo project
//public class JsonWriterMovie {
//    private static final int TAB = 4;
//    private PrintWriter writer;
//    private String destination;
//
//    // EFFECTS: constructs writer to write to destination file
//    public JsonWriterMovie(String destination) {
//        this.destination = destination;
//    }
//
//    // MODIFIES: this
//    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
//    // be opened for writing
//    public void open() throws FileNotFoundException {
//        writer = new PrintWriter(new File(destination));
//    }
//
//    // MODIFIES: this
//    // EFFECTS: writes JSON representation of account to file
//    public void write(List<Movie> mov) {
//        JSONArray json = new JSONArray();
//        for (Movie m : mov) {
//            json.put(m.toJson());
//        }
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", json);
//        saveToFile(jsonObject.toString(TAB));
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: closes writer
//    public void close() {
//        writer.close();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: writes string to file
//    private void saveToFile(String json) {
//        writer.print(json);
//    }
//
//}
