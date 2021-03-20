package persistence;

import org.json.JSONObject;

//Interface to convert objects into JSON objects
public interface Writable {
    //EFFECTS: returns this as JSON object
    JSONObject toJson();
}
