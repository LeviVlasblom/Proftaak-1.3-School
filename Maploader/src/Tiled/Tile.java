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

    public Tile(Point2D location, BufferedImage image, int flags) {
        this.location = location;
        this.image = image;
        this.flags = flags;
        this.collision = false;
    }

    public Tile(Point2D location, boolean collision) {
        this.location = location;
        this.collision = collision;
    }

    public void draw(FXGraphics2D g) {
        AffineTransform transform = new AffineTransform();
        transform.translate(location.getX(), location.getY());
        g.drawImage(image, transform, null);
    }


    public Point2D getLocation() {
        return location;
    }
}
