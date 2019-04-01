package Maploader.Tiled;

import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
    private Point2D location;
    private BufferedImage image;
    private int flags = 0;
    private boolean collision;
    private boolean destination;
    private int y;
    private int x;
    private int distance;

    public Tile(Point2D location, BufferedImage image, int flags) {
        this.location = location;
        this.image = image;
        this.flags = flags;
        this.collision = false;
        this.destination = false;
        this.distance = 0;
    }

    public Tile(Tile tile, int distance){
        this.location = tile.getLocation();
        this.x = tile.getX();
        this.y = tile.getY();
        this.collision = tile.isCollision();
        this.destination = tile.isDestination();
        this.distance = distance;
    }


    public Tile(int x, int y, Point2D location, boolean collision, boolean destination) {
        this.location = location;
        this.x = x;
        this.y = y;
        this.collision = collision;
        this.destination = destination;
        this.distance = 0;
    }

    public void draw(Graphics2D g) {
        AffineTransform transform = new AffineTransform();
        transform.translate(location.getX(), location.getY());
        g.drawImage(image, transform, null);
    }

    public boolean isCollision() {
        return collision;
    }

    public boolean isDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public ArrayList<Tile> getNearTiles(ArrayList<Tile> tiles, Tile position){
        ArrayList<Tile> nearTiles = new ArrayList<>();
        for (Tile tile : tiles){
            if (tile.getX() == position.getX() + 1 && position.getY() == tile.getY()){
                nearTiles.add(tile);
            }
            if (tile.getX() == position.getX() - 1 && position.getY() == tile.getY()){
                nearTiles.add(tile);
            }
            if (tile.getX() == position.getX() && position.getY() + 1 == tile.getY()){
                nearTiles.add(tile);
            }
            if (tile.getX() == position.getX()  && position.getY() - 1 == tile.getY()){
                nearTiles.add(tile);
            }
        }
        return nearTiles;
    }


    @Override
    public String toString() {
        return "x: " + this.x + ". y: " + this.y;
    }

    public Point2D getLocation() {
        return location;
    }
}
