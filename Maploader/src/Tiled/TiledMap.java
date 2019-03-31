package Tiled;


import org.jfree.fx.FXGraphics2D;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Optional;


public class TiledMap {
    private static final int FLIP_H_FLAG = 0x80000000;
    private static final int FLIP_V_FLAG = 0x40000000;
    private static final int FLIP_D_FLAG = 0x20000000;

    ArrayList<BufferedImage> tilesImages;
    private BufferedImage cacheImage;
//    private int[][] map;
    private ArrayList<TiledLayer> layers;
    private ArrayList<TiledTileSet> tilesets;
    private ArrayList<ArrayList<Tile>> tilesByLayer;
//    private TiledTile tile;
//    private TiledTileMap tilemap;


    public TiledMap(String fileName){
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources\\" +fileName));
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
//        tile = new TiledTile(fileName);
//        this.tilemap = new TiledTileMap(fileName);
        //load the tilemap

        tilesByLayer = new ArrayList<>();
        for (int i = 0; i < layers.size(); i++) {
            TiledLayer layer = layers.get(i);
            ArrayList<Tile> layeredTiles = new ArrayList<>();
            int ii = 0;
            for (int y = 0; y < layer.getHeight(); y++) {
                for (int x = 0; x < layer.getWidth(); x++) {
                    int currentData = layer.getData().get(ii);
                    boolean hflip = (currentData & FLIP_H_FLAG) > 0;
                    boolean vflip = (currentData & FLIP_V_FLAG) > 0;
                    boolean dflip = (currentData & FLIP_D_FLAG) > 0;

                    int d = currentData &= ~(FLIP_H_FLAG|FLIP_V_FLAG|FLIP_D_FLAG);
                    int tileFlags = ( (hflip?FLIP_H_FLAG:0) | (vflip?FLIP_V_FLAG:0) | (dflip?FLIP_D_FLAG:0) ) - d;

                    Optional<TiledTileSet> tileSet = this.tilesets.stream().filter(f -> f.getFirstgid() <= d && (f.getFirstgid() + f.getTileCount()) >= d).findFirst();
                    if (tileSet.isPresent()) {
                        BufferedImage tileSheetImage = tileSet.get().getImage();
                        int index = currentData;
                        index -= tileSet.get().getFirstgid();
                        if (layers.get(i).getName().equals("collision")) {
                            switch (index){
                                case 1871: layeredTiles.add(new Tile(x, y, new Point2D.Double(x*16, y*16), true, false));
                                break;
                                case 1836: layeredTiles.add(new Tile(x, y, new Point2D.Double(x*16, y*16), false, true));
                                break;
                                default: layeredTiles.add(new Tile(x, y, new Point2D.Double(x*16, y*16), false, false));
                            }


                        } else {
                            BufferedImage image = tileSheetImage.getSubimage(16 * (index % tileSet.get().getColumns()), 16 * (index / tileSet.get().getColumns()), 16, 16);
                            layeredTiles.add(new Tile(new Point2D.Double(x * 16, y * 16), image, tileFlags));
                        }
                    }
                    ii++;
                }
            }
            this.tilesByLayer.add(layeredTiles);
        }

//        try {
//            for (int i = 0; i < layers.size(); i++) {
//                int correcttileset = 0;
//                for (int y = 0; y < tilemap.getHeight(); y += tile.getTileHeight()) {
//                    for (int x = 0; x < tilemap.getWidth(); x += tile.getTileWidth()) {
//                        for (int n = 0; n < limits.size(); n++) {
//                            if (layers.get(i).getData().get(y) > limits.get(n)) {
//                                correcttileset = n;
//                            }
//                        }
//                        BufferedImage bf = this.tilesets.get(correcttileset).getImage();
//                        BufferedImage subimage = bf.getSubimage(x, y, tile.getTileWidth() ,tile.getTileHeight());
//                        tilesImages.add(subimage);
//                     //   tilesImages.add(this.tilesets.get(correcttileset).getImage().getSubimage(x, y, tile.getTileWidth(), tile.getTileHeight()));
//
//                    }
//                }
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//
//        map = new int[tilemap.getHeight()][tilemap.getWidth()];
//        for (TiledLayer layer : this.layers) {
//            for(int y = 0; y < tilemap.getHeight(); y++) {
//                for (int x = 0; x < tilemap.getWidth(); x++) {
//                this.map[y][x] = layer.getData().get(x);
//                }
//            }
//        }
        redrawCache();
    }


    public ArrayList<ArrayList<Tile>> getTilesByLayer() {
        return tilesByLayer;
    }



//            for(int y = 0; y < tilemap.getHeight(); y++)
//            {
//                for(int x = 0; x < tilemap.getWidth(); x++)
//                {
//                    if(this.map[y][x] < 0)
//                        continue;
//
//                    g2d.drawImage(
//                            tilesImages.get(this.map[y][x]),
//                            AffineTransform.getTranslateInstance(x*tile.getTileWidth(), y*tile.getTileHeight()), null);
//                }
//            }




        public void redrawCache(){
        cacheImage = new BufferedImage(1376 ,1152, BufferedImage.TYPE_INT_ARGB);
        Graphics2D imageGraphics = cacheImage.createGraphics();
        drawCache(imageGraphics);
        }


        public TiledMap(){

        }

        public void draw(Graphics2D g){
        g.drawImage(cacheImage, new AffineTransform(), null);
        }

        public void drawCache(Graphics2D g){
            for (int i = 0; i < tilesByLayer.size(); i++) {
                ArrayList<Tile> sublist = tilesByLayer.get(i);
                for (int j = 0; j < sublist.size(); j++) {
                    sublist.get(j).draw(g);
                }
            }
        }


}


