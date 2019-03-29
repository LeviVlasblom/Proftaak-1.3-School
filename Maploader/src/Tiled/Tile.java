package Tiled;

import org.jfree.fx.FXGraphics2D;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Tile {
    private Point2D location;
    private BufferedImage image;
    private int flags = 0;
    private boolean collision;
    private boolean destination;

    public Tile(Point2D location, BufferedImage image, int flags) {
        this.location = location;
        this.image = image;
        this.flags = flags;
        this.collision = false;
        this.destination = false;
    }

    public Tile(Point2D location, boolean collision, boolean destination) {
        this.location = location;
        this.collision = collision;
        this.destination = destination;
    }

    public void draw(FXGraphics2D g) {
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

    public Point2D getLocation() {
        return location;
    }
}
