package Tiled;

import javax.imageio.ImageIO;
import javax.json.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Map {
    private int width;
    private int height;
    private int tileHeight;
    private int tileWidth;
    private ArrayList<Layer> layers;
    private int[][] map;
    private ArrayList<BufferedImage> tiles;

    public Map(String fileName)
    {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources//" +fileName));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();

        this.width = root.getInt("width");
        this.height = root.getInt("height");
        this.tileHeight = root.getInt("tileheight");
        this.tileWidth = root.getInt("tilewidth");
        JsonArray rawLayers = root.getJsonArray("layers");
        for (int i = 0; i < rawLayers.size(); i++)  {
            try {
                this.layers.add(new Layer(rawLayers.getJsonObject(i), fileName));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        //load the tilemap


        map = new int[height][width];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                map[y][x] = root.getJsonArray("map").getJsonArray(y).getInt(x);
            }
        }
    }


    public void draw(Graphics2D g2d)
    {

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                if(map[y][x] < 0)
                    continue;

                g2d.drawImage(
                        tiles.get(map[y][x]),
                        AffineTransform.getTranslateInstance(x*tileWidth, y*tileHeight),
                        null);
            }
        }


    }

}
