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
import java.util.ArrayList;


public class MapDemo extends Application {


    private TiledMap map;
    private ResizableCanvas canvas;
    private ArrayList<Person> students;

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

        stage.setScene(new Scene(mainPane));
        stage.setTitle("Map");
        stage.show();
        draw(g2d);


    }


    public void init()
    {

        map = new TiledMap("school2_met_collision.json");
        students = new ArrayList<>();

    }



    public void draw(FXGraphics2D g)
    {
        g.setBackground(Color.black);
        g.clearRect(0,0,(int)canvas.getWidth(), (int)canvas.getHeight());
        map.draw(g);
    }

    public void update(double deltaTime)
    {


    }




    public static void main(String[] args)
    {
        launch(MapDemo.class);
    }

}
