package Tiled;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;

public class Layer {
    private ArrayList<Tile> tiles;
    private int id;
    private String name;

    public Layer(JsonObject object, String fileName) {
        this.id = object.getInt("id");
        this.name = object.getString("name");
        this.tiles = new ArrayList<>();
        try {
            JsonArray nums = object.getJsonArray("data");
            if (nums != null) {
                for (int i = 0; i < nums.size()-1; i++) {
                    this.tiles.add(new Tile(fileName, Long.parseLong(nums.get(i).toString())));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

