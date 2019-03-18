package Tiled;

import org.jfree.fx.FXGraphics2D;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Tile {
    private Point2D location;
    private BufferedImage image;

    public Tile(Point2D location, BufferedImage image) {
        this.location = location;
        this.image = image;
    }

    public void draw(FXGraphics2D g) {
        AffineTransform transform = new AffineTransform();
        transform.translate(location.getX(), location.getY());
        g.drawImage(image, transform, null);
    }
}
