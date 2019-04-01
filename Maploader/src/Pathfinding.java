import Tiled.Tile;

import java.util.ArrayList;

public class Pathfinding {
    private ArrayList<Tile> map;
    private ArrayList<Tile> OGmap;

    public Pathfinding(ArrayList<Tile> tiles, int tileX, int tileY) {
        int x = tileX;
        int y = tileY;
        OGmap = new ArrayList<>(tiles);
        ArrayList<Tile> tempTiles = new ArrayList<>();
        ArrayList<Tile> Tiles2 = new ArrayList<>();
        map = new ArrayList<>();
        int distance = 2;
        Tile startTile;
        for (Tile tile: tiles) {
            if (tile.getX() == x && tile.getY() == y){
                startTile = tile;
                map.add(new Tile(startTile, 0));
            }
        }


        for (Tile tile : tiles) {
            if (tileup(tile, x, y, 1) || tileright(tile, x, y, 1) || tileleft(tile, x, y, 1) || tiledown(tile, x, y, 1)) {
                Tile epic = new Tile(tile, 1);
                map.add(epic);
                tempTiles.addAll(epic.getNearTiles(OGmap, tile));
            }
        }
       while(map.size() < OGmap.size()){
            for (Tile tile : tempTiles) {
                ArrayList<Tile> tempList = new ArrayList<>(tile.getNearTiles(OGmap, tile));
                for (Tile compare : tempList) {
                    if (tileup(tile, x, y, distance) || tileright(tile, x, y, distance) || tileleft(tile, x, y, distance) || tiledown(tile, x, y, distance)) {
                        Tile temp = new Tile(tile, distance);
                        map.add(temp);
                        Tiles2.addAll(temp.getNearTiles(OGmap, tile));
                    }
                }
            }
            tempTiles.clear();
            tempTiles.addAll(Tiles2);
            Tiles2.clear();
            distance++;
        }

    }


    public boolean tiledown(Tile tile, int x, int y, int distance) {
        if (tile.getX() == x && tile.getY() - 1 == y && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() > distance)){
                    return false;
                }
            }return true;
        }return false;
    }
    public boolean tileleft(Tile tile, int x, int y, int distance) {
        if (tile.getX() - 1 == x && tile.getY() == y && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() > distance)){
                    return false;
                }
            }return true;
        }return false;
    }
    public boolean tileright(Tile tile, int x, int y, int distance) {
        if (tile.getX() + 1 == x && tile.getY() == y && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() > distance)){
                    return false;
                }
            }return true;
        }return false;
    }
    public boolean tileup(Tile tile, int x, int y, int distance) {
        if (tile.getX() == x && tile.getY() + 1 == y && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() > distance)){
                    return false;
                }
            }return true;
        }return false;
    }


    public ArrayList<Tile> getMap() {
        return map;
    }
}
