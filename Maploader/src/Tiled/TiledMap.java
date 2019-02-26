package Tiled;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/*TODO NEEDS TO BE UPDATED TO NEW CONSTURCTORS AND TILESET METHODS


public class TiledMap {

    private ArrayList<BufferedImage> tiles = new ArrayList<>();
    private int[][] map;
    private int layers;
    private TiledTile tile;
    private TiledTileMap tilemap;

    public TiledMap(String fileName){
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources//" +fileName));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();
        this.tile = new TiledTile(fileName);
        this.tilemap = new TiledTileMap(fileName);
        //load the tilemap
        try {
            String tilesheet = root.getJsonObject("tilemap").getString("file");
            BufferedImage tilemap = ImageIO.read(new FileInputStream("Resources\\" + tilesheet));
            for(int y = 0; y < tilemap.getHeight(); y += tile.getTileHeight())
            {
                for(int x = 0; x < tilemap.getWidth(); x += tile.getTileWidth())
                {
                    tiles.add(tilemap.getSubimage(x, y, tile.getTileWidth(), tile.getTileHeight()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        map = new int[tilemap.getHeight()][tilemap.getWidth()];
        for(int y = 0; y < tilemap.getHeight(); y++)
        {
            for(int x = 0; x < tilemap.getWidth(); x++)
            {
                map[y][x] = root.getJsonArray("map").getJsonArray(y).getInt(x);
            }
        }
    }




        public void draw(Graphics2D g2d)
        {

            for(int y = 0; y < tilemap.getHeight(); y++)
            {
                for(int x = 0; x < tilemap.getWidth(); x++)
                {
                    if(map[y][x] < 0)
                        continue;

                    g2d.drawImage(
                            tiles.get(map[y][x]),
                            AffineTransform.getTranslateInstance(x*tile.getTileWidth(), y*tile.getTileHeight()),
                            null);
                }
            }


        }

}
*/
