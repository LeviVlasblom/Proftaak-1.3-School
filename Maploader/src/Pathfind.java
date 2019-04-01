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
        distancemap = new int[87][73];
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
        done.add(target);
        distancemap[target.getX()][ target.getY()] = 0;
        while(toSearch.size() > 0) {
            Coordinate bruh = new Coordinate(toSearch.peek().getX(), toSearch.peek().getY());
            toSearch.removeFirst();
            ArrayList<Coordinate> coordinates = new ArrayList<>();
            coordinates.add(new Coordinate(bruh.getX(), bruh.getY() + 1));
            coordinates.add(new Coordinate(bruh.getX() + 1, bruh.getY()));
            coordinates.add(new Coordinate(bruh.getX(), bruh.getY() - 1));
            coordinates.add(new Coordinate(bruh.getX() - 1, bruh.getY()));
           for (Coordinate  co : coordinates){
               delete = false;
                if (this.done.contains(co)) {
                    delete = true;
                }
                if (co.getY() < 0 || co.getY() >= 72 || co.getX() < 0 || co.getX() >= 86){
                    delete = true;
                }else if (collision[co.getX()][co.getY()]){
                   delete = true;
               }
                if (!delete) {
                    done.add(co);
                    toSearch.add(co);
                    this.distancemap[co.getX()][co.getY()] = this.distancemap[bruh.getX()][bruh.getY()] +1;
                }
            }
            coordinates.clear();
        }
    }


    public int[][] getDistancemap() {
        return distancemap;
    }
}
