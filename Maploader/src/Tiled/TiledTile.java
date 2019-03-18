package Tiled;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TiledTile {

    private int tileHeight;
    private int tileWidth;
    private int ID;

    public TiledTile(String fileName) {

        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("Resources//" +fileName));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();
        try {
            this.tileHeight = root.getInt("tileheight");
            this.tileWidth = root.getInt("tilewidth");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
