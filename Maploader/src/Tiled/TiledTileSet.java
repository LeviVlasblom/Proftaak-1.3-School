package Tiled;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class TiledTileSet {
    private String name;
    private BufferedImage image;
    private int firstgid;
    private int tileCount;
    private int columns;

    public TiledTileSet(JsonObject object) {
        try {
            this.image = ImageIO.read(new FileInputStream("Resources\\" + object.getString("image")));
            this.name = object.getString("name");
            this.firstgid = object.getInt("firstgid");
            this.tileCount = object.getInt("tilecount");
            this.columns = object.getInt("columns");
        } catch(Exception e){
        System.out.println(e.getMessage());
      }
    }

    public int getFirstgid() {
        return firstgid;
    }

    public int getTileCount() {
        return tileCount;
    }

    public int getColumns() {
        return columns;
    }

    public BufferedImage getImage() {
        return image;
    }
}
