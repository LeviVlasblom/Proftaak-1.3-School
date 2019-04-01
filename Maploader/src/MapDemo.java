import Tiled.Tile;
import Tiled.TiledMap;
import Tiled.TiledTileMap;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;
import java.awt.*;
import java.awt.geom.Point2D;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;


public class MapDemo extends Application {

    private static final int STUDENTS = 20;
    private static final int TEACHERS = 0;
    private TiledMap map;
    private ResizableCanvas canvas;
    private ArrayList<Person> students;
    private ArrayList<Person> teachers;
    private int counter;
 //   private ArrayList<Destination> destinations;
    public Point2D position;
    public static int OMEGA = 696969;
    public static ArrayList<Target> targetsStudents;
    public static ArrayList<Target> targetsTeachers;
    public Pathfind p;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        canvas.setWidth(1375);
        canvas.setHeight(1080);
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
        new AnimationTimer() {
            long last = -1;
            @Override
            public void handle(long now) {
                if(last == -1)
                    last = now;
                update((now - last) / 1000000000.0);
                last = now;
                draw(g2d);
            }
        }.start();
        canvas.setOnMouseClicked(e ->
        {
            position = new Point2D.Double(e.getX(), e.getY());
            for (Tile tile : map.getTilesByLayer().get(0)){
                if (position.getY() >= tile.getLocation().getY() && position.getX() >= tile.getLocation().getX() && position.getY() <= tile.getLocation().getY()+16 && position.getX() <= tile.getLocation().getX()+16 ){
                   // System.out.println(tile.getLocation());
                    System.out.println(tile.toString());
                }
            }
        });
        stage.setScene(new Scene(mainPane));
        stage.setTitle("Map");
        stage.show();
        draw(g2d);


    }


    public void init()
    {
        map = new TiledMap("school2_met_collision_no_tree.json");
        targetsStudents = new Targets().targetsStudents(map.getCollision());
        targetsTeachers = new Targets().targetsTeachers(map.getCollision());
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        counter = 0;





     //   p = new Pathfinding(map.getTilesByLayer().get(0), 40, 36);
   //     for (Tile tile : p.getMap()){
    //        System.out.println(tile.getDistance());

   //     }

       for (int i = 0; i < STUDENTS; i++){
            int temp = map.getTilesByLayer().get(1).size();
           Point2D spawn;
            if (!map.getTilesByLayer().get(1).get(temp-1001-(i*-4)).isCollision()) {
                spawn = map.getTilesByLayer().get(1).get(temp - 1001 - (i * -4)).getLocation();
                Person student = new Person(spawn);
                Random rand = new Random();
                student.setTarget(targetsStudents.get(rand.nextInt(11)));
                students.add(student);

            }
        }


        for (int i = 0; i < TEACHERS; i++){
            int temp = map.getTilesByLayer().get(1).size();
            Point2D spawn;
            if (!map.getTilesByLayer().get(1).get(temp-1001-(i*-4)).isCollision()) {
                spawn = map.getTilesByLayer().get(0).get(temp - 1001 - (i * -4)).getLocation();
                Person teacher = new Person(spawn, true);
                teacher.setTarget(targetsTeachers.get(1));
                teachers.add(teacher);
            }
        }
    }





    public void draw(FXGraphics2D g)
    {
        g.setBackground(Color.black);
        g.clearRect(0,0,(int)canvas.getWidth(), (int)canvas.getHeight());
        map.draw(g);


        for (Person e: students) {
            e.draw(g);
        }
        for (Person e : teachers){
            e.draw(g);
            System.out.println(e.getCurrentTile());
        }
    }

    public void update(double deltaTime)
    {
        counter++;


        ArrayList<Tile> occupiedTiles = new ArrayList<>();
        for (Person student : students) {
            occupiedTiles.add(student.getCurrentTile());
        }


      for (Person student : students) {
          if (occupiedTiles.contains(student.getCurrentTile())){
              student.updateTile(map.getTilesByLayer().get(0));
              int lol = OMEGA;
              Tile nearest = student.getCurrentTile();
              for (Tile tile : student.getCurrentTile().getNearTiles(map.getTilesByLayer().get(0), student.getCurrentTile())){
                  if (student.getTarget().getPathfind().getDistancemap()[tile.getX()][tile.getY()] < lol && student.getTarget().getPathfind().getDistancemap()[tile.getX()][tile.getY()] > 0 ){
                      lol = student.getTarget().getPathfind().getDistancemap()[tile.getX()][tile.getY()];
                      nearest = tile;
                  }
              }
              if (lol > 1){
                  student.moveChar(student.getCurrentTile(), nearest);
              }
          }
      }


        for (Person teacher : teachers) {
            if (occupiedTiles.contains(teacher.getCurrentTile())){
                teacher.updateTile(map.getTilesByLayer().get(0));
                int lol = OMEGA;
                Tile nearest = teacher.getCurrentTile();
                for (Tile tile : teacher.getCurrentTile().getNearTiles(map.getTilesByLayer().get(0), teacher.getCurrentTile())){
                    if (teacher.getTarget().getPathfind().getDistancemap()[tile.getX()][tile.getY()] < lol && teacher.getTarget().getPathfind().getDistancemap()[tile.getX()][tile.getY()] > 0 ){
                        lol = teacher.getTarget().getPathfind().getDistancemap()[tile.getX()][tile.getY()];
                        nearest = tile;
                    }
                }
                if (lol > 1){
                    teacher.moveChar(teacher.getCurrentTile(), nearest);
                }
            }
        }

        if (counter == 10){
            for (Person p : students){
                Random rand = new Random();
                p.setTarget(targetsStudents.get(rand.nextInt(11)));
            }
        }


    }




    public static void main(String[] args)
    {
        launch(MapDemo.class);
    }

}
