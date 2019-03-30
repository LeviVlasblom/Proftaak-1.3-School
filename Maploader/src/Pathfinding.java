import Tiled.Tile;

import java.util.ArrayList;

public class Pathfinding {
    private ArrayList<Tile> map;

    public Pathfinding(ArrayList<Tile> tiles, int tileX, int tileY) {
        int x = tileX;
        int y = tileY;
        ArrayList<Tile> tempTiles = new ArrayList<>();
        ArrayList<Tile> Tiles2 = new ArrayList<>();
        map = new ArrayList<>();
        int distance = 2;
            for (Tile tile : tiles) {
                    if (tileup(tile, x, y, 1) || tileright(tile, x, y, 1) || tileleft(tile, x, y, 1) || tiledown(tile, x, y, 1)) {
                        map.add(new Tile(tile, 1));
                        tempTiles.add(tile);
                    }
            }
        for (int i = 1; i < tiles.size(); i++) {
            for (Tile tile : tempTiles) {
                if (tileup(tile, x, y, distance) || tileright(tile, x, y, distance) || tileleft(tile, x, y, distance) || tiledown(tile, x, y, distance)) {
                    map.add(new Tile(tile, distance));
                    Tiles2.add(tile);
                }
            }
            tempTiles.clear();
            tempTiles.addAll(Tiles2);
            Tiles2.clear();
            distance++;
        }

    }


    public boolean tileup(Tile tile, int x, int y, int distance) {
        if (tile.getX() == x && tile.getY() == y + 1 && tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() < distance || compareTile.getDistance() == 0)){
                    return true;
                }
            }
        }return false;
    }
    public boolean tileleft(Tile tile, int x, int y, int distance) {
        if (tile.getX() == x - 1 && tile.getY() == y && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() < distance || compareTile.getDistance() == 0)){
                    return true;
                }
            }return false;
        }return false;
    }
    public boolean tileright(Tile tile, int x, int y, int distance) {
        if (tile.getX() == x + 1 && tile.getY() == y && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() < distance || compareTile.getDistance() == 0)){
                    return true;
                }
            }return false;
        }return false;
    }
    public boolean tiledown(Tile tile, int x, int y, int distance) {
        if (tile.getX() == x && tile.getY() == y - 1 && !tile.isCollision()){
            for (Tile compareTile: map){
                if (compareTile.getY() == tile.getY() && compareTile.getX() == tile.getX() && (compareTile.getDistance() < distance || compareTile.getDistance() == 0)){
                    return true;
                }
            }return false;
        }return false;
    }


    public ArrayList<Tile> getMap() {
        return map;
    }
}
