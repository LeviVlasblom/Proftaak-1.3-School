package Maploader;

import Maploader.Tiled.Tile;
import Maploader.Tiled.TiledMap;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;


public class MapDemo extends Application {

    private static final int STUDENTS = 1;
    private TiledMap map;
    private ResizableCanvas canvas;
    private ArrayList<Person> students;
    private ArrayList<Destination> destinations;
    public Point2D position;
    //Pathfinding p;

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
                    System.out.println(tile.getLocation());
                    System.out.println(tile.toString());
                    System.out.println(tile.isCollision());
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

        map = new TiledMap("school2_met_collision.json");
        students = new ArrayList<>();
     //   p = new Maploader.Pathfinding(map.getTilesByLayer().get(0), 40, 36);
   //     for (Tile tile : p.getMap()){
    //        System.out.println(tile.getDistance());

   //     }

       for (int i = 0; i < STUDENTS; i++){
            int temp = map.getTilesByLayer().get(1).size();
            Point2D spawn = map.getTilesByLayer().get(1).get(temp-1001-(i*-4)).getLocation();
            students.add(new Person(spawn));

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
    }

    public void update(double deltaTime)
    {

    /*   for (Maploader.Person student : students) {
            student.updateTile(p.getMap());
            ArrayList<Tile> nearTiles = student.getCurrentTile().getNearTiles(map.getTilesByLayer().get(0), student.getCurrentTile());
            Tile nearest = student.getCurrentTile();
            for (Tile tile : nearTiles){
                if (tile.getDistance() < nearest.getDistance()){
                    nearest = tile;
                }
            }
            student.moveChar(student.getCurrentTile(), nearest);
        }*/
    }

    public String MapOpener() {
        String fileName = "";
        FileChooser fileChooser = new FileChooser();
        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);
        fileChooser.setInitialDirectory(userDirectory);
        File selectedFile = fileChooser.showOpenDialog(null);


        if (selectedFile != null) {
            //System.out.println("Found u my lord!");
            fileName = selectedFile.getName();
            System.out.println(fileName);

            String line = null;

            map = new TiledMap(fileName);
        }
        return fileName;
    }

        public static void main (String[]args)
        {
            launch(MapDemo.class);
        }
    }
