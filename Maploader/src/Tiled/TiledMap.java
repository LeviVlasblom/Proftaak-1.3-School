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

    ArrayList<BufferedImage> tilesImages;
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
        tilesets = new ArrayList<>();
        tilesImages = new ArrayList<>();
        JsonObject root = reader.readObject();
        JsonArray curLayers = root.getJsonArray("layers");
        for (int i = 0; i < curLayers.size(); i++) {
            try {
                this.layers.add(new TiledLayer(curLayers.getJsonObject(i)));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        JsonArray tilesets = root.getJsonArray("tilesets");
        ArrayList<Integer> limits = new ArrayList<>();
        for (int i = 0; i < tilesets.size(); i++){
            try{
                this.tilesets.add(new TiledTileSet(tilesets.getJsonObject(i)));
                limits.add((new TiledTileSet(tilesets.getJsonObject(i)).getFirstgid()));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        tile = new TiledTile(fileName);
        this.tilemap = new TiledTileMap(fileName);
        //load the tilemap TODO ADD WAY TO READ ALL DATA AND DISPLAY MAP

        try {
            for (int i = 0; i < layers.size(); i++) {
                int correcttileset = 0;
                for (int y = 0; y < tilemap.getHeight(); y += tile.getTileHeight()) {
                    for (int x = 0; x < tilemap.getWidth(); x += tile.getTileWidth()) {
                        for (int n = 0; n < limits.size(); n++) {
                            if (layers.get(i).getData().get(y) > limits.get(n)) {
                                correcttileset = n;
                            }
                        }
                        BufferedImage bf = this.tilesets.get(correcttileset).getImage();
                        BufferedImage subimage = bf.getSubimage(x, y, tile.getTileWidth() ,tile.getTileHeight());
                        tilesImages.add(subimage);
                     //   tilesImages.add(this.tilesets.get(correcttileset).getImage().getSubimage(x, y, tile.getTileWidth(), tile.getTileHeight()));

                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        map = new int[tilemap.getHeight()][tilemap.getWidth()];
        for (TiledLayer layer : this.layers) {
            for(int y = 0; y < tilemap.getHeight(); y++) {
                for (int x = 0; x < tilemap.getWidth(); x++) {
                this.map[y][x] = layer.getData().get(x);
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
                    if(this.map[y][x] < 0)
                        continue;

                    g2d.drawImage(
                            tilesImages.get(this.map[y][x]),
                            AffineTransform.getTranslateInstance(x*tile.getTileWidth(), y*tile.getTileHeight()),
                            null);
                }
            }


        }

}


