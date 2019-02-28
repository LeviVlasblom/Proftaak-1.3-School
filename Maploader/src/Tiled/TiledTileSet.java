package Tiled;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class TiledTileSet {
    private String name;
    private BufferedImage image;


    public TiledTileSet(String fileName) {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("Resources//" + fileName));
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();
        try {
            String tilesheet = root.getJsonObject("tilemap").getString("file");
            this.image = ImageIO.read(new FileInputStream("Resources\\" + tilesheet));
            this.name = root.getJsonObject("tilesets").getString("name");
        } catch(Exception e){
        System.out.println(e.getMessage());
      }
    }

    public BufferedImage getImage() {
        return image;
    }
}
