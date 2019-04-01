import Tiled.Tile;
import Tiled.TiledMap;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Destination {
    private Point2D locationStudent;
    private Point2D locationTeacher;
    private String name;

    public Destination(String name, Point2D locationTeacher , Point2D locationStudent) {
        this.locationStudent = locationStudent;
        this.locationTeacher = locationTeacher;
        this.name = name;

    }

    /**
     * Hardcoded Destinations
     * @return arraylist with destinations
     */
    public ArrayList<Destination> getDestinations(){
       ArrayList<Destination> destinations = new ArrayList<>();
       destinations.add(new Destination("L01", new Point2D.Double(150, 356), new Point2D.Double(261,277))); //Classrooms
       destinations.add(new Destination("L02", new Point2D.Double(444, 287), new Point2D.Double(552,282)));
       destinations.add(new Destination("L03", new Point2D.Double(792, 271), new Point2D.Double(912,274)));
       destinations.add(new Destination("L04", new Point2D.Double(1075, 272), new Point2D.Double(1180,279)));
       destinations.add(new Destination("L05", new Point2D.Double(160, 466), new Point2D.Double(257,462)));
       destinations.add(new Destination("L06", new Point2D.Double(441, 429), new Point2D.Double(555,467)));
       destinations.add(new Destination("L07", new Point2D.Double(159, 750), new Point2D.Double(274,741)));
       destinations.add(new Destination("L08", new Point2D.Double(447, 750), new Point2D.Double(550,746)));
       destinations.add(new Destination("C1", new Point2D.Double(1076, 468), new Point2D.Double(1076, 468))); //Kantine
       destinations.add(new Destination("TR", new Point2D.Double(873, 737), new Point2D.Double(873, 737))); //Teacherroom
       destinations.add(new Destination("BB", new Point2D.Double(1076, 739), new Point2D.Double(1076, 739))); //Boys Bathroom
       destinations.add(new Destination("GB", new Point2D.Double(1220, 739), new Point2D.Double(1220, 739))); //Girls Bathroom
       destinations.add(new Destination("Exit", new Point2D.Double(702, 988), new Point2D.Double(702, 988))); //Exit of the school
       return destinations;
    }
}
