package Tiled;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;

public class Tile {
    private int width;
    private int height;
    private long id;


    public Tile(String fileName, long id) {

        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("Resources//" +fileName));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();
        try {

            this.height = root.getInt("tileheight");
            this.width = root.getInt("tilewidth");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        this.id = id;
    }
}
