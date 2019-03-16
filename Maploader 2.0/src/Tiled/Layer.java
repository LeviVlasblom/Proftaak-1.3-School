package Tiled;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;

public class Layer {
    public JsonArray getTileIDs() {
        return tileIDs;
    }

    private JsonArray tileIDs;
    private int id;
    private String name;

    public Layer(JsonObject object) {
        this.id = object.getInt("id");
        this.name = object.getString("name");
        this.tileIDs = object.getJsonArray("data");
    }
}

