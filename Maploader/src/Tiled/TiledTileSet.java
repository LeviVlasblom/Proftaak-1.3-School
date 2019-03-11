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


    public TiledTileSet(JsonObject object) {
        try {
            this.image = ImageIO.read(new FileInputStream("Resources\\" + object.getString("image")));
            this.name = object.getString("name");
        } catch(Exception e){
        System.out.println(e.getMessage());
      }
    }

    public BufferedImage getImage() {
        return image;
    }
}
