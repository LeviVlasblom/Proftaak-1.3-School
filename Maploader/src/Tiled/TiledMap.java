package Tiled;


import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;




public class TiledMap {

    private ArrayList<BufferedImage> tiles;
    private int[][] map;
    private ArrayList<TiledLayer> layers;
    private ArrayList<TiledTileSet> tilesets;
    private TiledTile tile;
    private TiledTileMap tilemap;


    public TiledMap(String fileName){
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources//" +fileName));
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        layers = new ArrayList<>();
        tiles = new ArrayList<>();
        tilesets = new ArrayList<>();
        JsonObject root = reader.readObject();
        JsonArray curLayers = root.getJsonArray("layers");
        for (int i = 0; i < curLayers.size(); i++) {
            try {
                this.layers.add(new TiledLayer(curLayers.getJsonObject(i)));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        JsonArray tilesets = root.getJsonArray("layers");
        for (int i = 0; i < tilesets.size(); i++){
            try{
                this.tilesets.add(new TiledTileSet(tilesets.getJsonObject(i)));
            }
        }
        tile = new TiledTile(fileName);
        this.tilemap = new TiledTileMap(fileName);
        //load the tilemap TODO ADD WAY TO READ ALL DATA AND DISPLAY MAP
        try {
            for(int y = 0; y < tilemap.getHeight(); y += tile.getTileHeight())
            {
                for(int x = 0; x < tilemap.getWidth(); x += tile.getTileWidth())
                {
                    BufferedImage aapos = tileset.getImage();
                    BufferedImage aap = tileset.getImage().getSubimage(x, y, tile.getTileWidth(), tile.getTileHeight());
                    tiles.add(aap);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        map = new int[tilemap.getHeight()][tilemap.getWidth()];
        for (int i = 0; i < layers.size(); i++){
        for(int y = 0; y < tilemap.getHeight(); y++) {
            for (int x = 0; x < tilemap.getWidth(); x++) {
//                map[y][x] = this.layers.get(i).getData(y).getInt(x);
            }
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


