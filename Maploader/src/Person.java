import javax.imageio.ImageIO;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Person {
    private Point2D position;
    private double angle;

    private double speed = 5;
    private BufferedImage image;

    private Point2D target;

    public Person(Point2D position)
    {
        this.position = position;
        this.angle = 0;
        try {
            image = ImageIO.read(this.getClass().getResource("/dude.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.angle = Math.random()*2*Math.PI;
    }

    public void setTarget(Point2D target) {
        this.target = target;
    }
}
