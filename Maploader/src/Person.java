import Tiled.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Person {
    private Point2D position;
    private double angle;
    private double speed = 0.5;
    private BufferedImage image;
    private Tile currentTile;
    private Target target;
    private Point2D dirVector;
    private boolean gender; //true = boy false = girl
    private boolean teacher;


    public Person(Point2D position)
    {
        this.teacher = false;
        this.gender = getRandomBoolean();
        this.position = position;
        this.angle = 0;
        try {
            if (gender) {
                image = ImageIO.read(this.getClass().getResource("/dude.png"));
            }else {
                image = ImageIO.read(this.getClass().getResource("/female.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.angle = Math.random()*2*Math.PI;
    }

    public Person(Point2D position, boolean teacher)
    {
        this.teacher = teacher;
        this.gender = getRandomBoolean();
        this.position = position;
        this.angle = 0;
        try {
                image = ImageIO.read(this.getClass().getResource("/teacher.png"));
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

    /**
     * Movement
     * @param
     */
  /*  public void update(ArrayList<Person> characters){
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
*/
    public void moveChar(Tile CurrentTile,Tile MoveTile){
        if ((CurrentTile.getX() + 1 == MoveTile.getX())){
            position = new Point2D.Double(MoveTile.getLocation().getX(),MoveTile.getLocation().getY());
        }else if (CurrentTile.getX() - 1 == MoveTile.getX()){
            position = new Point2D.Double((MoveTile.getLocation().getX()),MoveTile.getLocation().getY());
        }else if (CurrentTile.getY() + 1 == MoveTile.getY()){
            position = new Point2D.Double(MoveTile.getLocation().getX(),MoveTile.getLocation().getY());
        }else if (CurrentTile.getY() - 1 == MoveTile.getY()){
            position = new Point2D.Double(MoveTile.getLocation().getX(),MoveTile.getLocation().getY());
        }
    }

    public boolean isGender() {
        return gender;
    }

    //    public void moveChar(Tile CurrentTile,Tile MoveTile){
//        if ((CurrentTile.getX() + 1 == MoveTile.getX())){
//            setTarget(new Point2D.Double(MoveTile.getX(),MoveTile.getY()));
//        }else if (CurrentTile.getX() - 1 == MoveTile.getX()){
//            setTarget(new Point2D.Double(MoveTile.getX(),MoveTile.getY()));
//        }else if (CurrentTile.getY() + 1 == MoveTile.getY()){
//            setTarget(new Point2D.Double(MoveTile.getX(),MoveTile.getY()));
//        }else if (CurrentTile.getY() - 1 == MoveTile.getY()){
//            setTarget(new Point2D.Double(MoveTile.getX(),MoveTile.getY()));
//        }
//    }

    //    public void update(ArrayList<Character> characters,Destination destination){
//
//        Point2D.Double newPosition = new Point2D.Double(0,0);
//        if (position.getX() < destination.getLocationStudent().getX()){
//            dirVector.setLocation(speed,0);
//        }
//        if (position.getX() > destination.getLocationStudent().getX()){
//            dirVector.setLocation(-speed,0);
//        }
//        if (position.getY() < destination.getLocationStudent().getY()){
//            dirVector.setLocation(0,speed);
//        }
//        if (position.getY() > destination.getLocationStudent().getY()){
//            dirVector.setLocation(0,-speed);
//        }
//        if (position.distance(destination.getLocationStudent()) < 5)
//            dirVector.setLocation(0,0);
//        newPosition.setLocation(position.getX() + dirVector.getX(),position.getY() +dirVector.getY());
//    }
    public void setTarget (Target target) {
        this.target = target;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public void updateTile(ArrayList<Tile> map){
        for (Tile tile : map){
            if (position.getY() >= tile.getLocation().getY() && position.getX() >= tile.getLocation().getX() && position.getY() <= tile.getLocation().getY()+16 && position.getX() <= tile.getLocation().getX()+16 ){
                this.currentTile = tile;
            }
        }
    }

    public Tile getCurrentTile() {
        return currentTile;
    }



    public Target getTarget() {
        return target;
    }
}
