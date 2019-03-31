import Tiled.Tile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pathfind {

    private int[][] distancemap;
    private Coordinate target;
    public static final int MAX_INT = -1;
    private LinkedList<Coordinate> toSearch;
    private ArrayList<Coordinate> done;


    public Pathfind(int xDes, int yDes, boolean[][] collision){
        distancemap = new int[86][72];
        toSearch = new LinkedList<>();
        done = new ArrayList<>();
        boolean delete = false;
        target = new Coordinate(xDes, yDes);
        toSearch.add(target);
        for (int x = 0; x < 86; x++) {
            for (int y = 0; y < 72; y++) {
                this.distancemap[x][y] = MAX_INT;
            }
        }
        distancemap[target.getX()][ target.getY()] = 0;
        while(toSearch.size() > 0) {
            Coordinate bruh = new Coordinate(toSearch.peek().getX(), toSearch.peek().getY());
            toSearch.removeFirst();
            ArrayList<Coordinate> coordinates = new ArrayList<>();
            coordinates.add(new Coordinate(bruh.getX(), bruh.getY() + 1));
            coordinates.add(new Coordinate(bruh.getX() + 1, bruh.getY()));
            coordinates.add(new Coordinate(bruh.getX(), bruh.getY() - 1));
            coordinates.add(new Coordinate(bruh.getX() - 1, bruh.getY()));
            for (int i = 0; i < coordinates.size(); i++) {
                if (!collision[coordinates.get(i).getX()][coordinates.get(i).getY()]) {
                    delete = true;
                }
                if (done.contains(coordinates.get(i))) {
                    delete = true;
                }
                if (coordinates.get(i).getY() < 0 || coordinates.get(i).getY() > 72 || coordinates.get(i).getX() < 0 || coordinates.get(i).getX() > 86){
                    delete = true;
                }
                if (!delete) {
                    done.add(coordinates.get(i));
                    toSearch.add(coordinates.get(i));
                    this.distancemap[coordinates.get(i).getX()][coordinates.get(i).getY()] = this.distancemap[bruh.getX()][bruh.getY()] +1;
                }
            }
            coordinates.clear();
        }
    }


    public int[][] getDistancemap() {
        return distancemap;
    }
}
