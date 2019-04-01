package Maploader.Tiled;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TiledTileMap {

    private int width;
    private int height;

    public TiledTileMap(String fileName) {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources//" +fileName));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();

        this.width = root.getInt("width");
        this.height = root.getInt("height");
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
