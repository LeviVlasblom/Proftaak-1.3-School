import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
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

    public void draw(Graphics2D g)
    {
        AffineTransform tx = new AffineTransform();
        tx.translate(position.getX()-16, position.getY()-16);
        tx.rotate(angle, 16, 16);

        g.drawImage(image, tx, null);

     //   g.draw(new Ellipse2D.Double(position.getX()-16, position.getY()-16,32,32));

    }
 		//Movement
    public void update(ArrayList<Character> characters){
        Point2D.Double newPosition = new Point2D.Double(0,0);
        if (position.getX() < target.getX()){
            dirVector.setLocation(speed,0);
        }
        if (position.getX() > target.getX()){
            dirVector.setLocation(-speed,0);
        }
        if (position.getY() < target.getY()){
            dirVector.setLocation(0,speed);
        }
        if (position.getY() > target.getY()){
            dirVector.setLocation(0,-speed);
        }
        if (position.distance(target) < 5)
            dirVector.setLocation(0,0);
        newPosition.setLocation(position.getX() + dirVector.getX(),position.getY() +dirVector.getY());
    }


    public void setTarget(Point2D target) {
        this.target = target;
    }
}
