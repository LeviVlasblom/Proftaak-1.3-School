package Tiled;

import javax.json.*;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.*;

public class TiledLayer {

    private int ID;
    private String name;
    private ArrayList<Integer> data;
    private int width;
    private int height;



    public TiledLayer(JsonObject object) {
        object.getInt("height");
        object.getInt("width");
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources//"));

        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        //JsonObject root = reader.readObject();
        try{
            //this.ID = root.getJsonObject("layers").getInt("ID");
            //this.name = root.getJsonObject("layers").getString("name");
            //JsonArray nums = root.getJsonObject("layers").getJsonArray("data");
            //this.width = root.getJsonObject("layers").getInt("width");
            //this.height = root.getJsonObject("layers").getInt("height");
            //ArrayList<Integer> data = new ArrayList<>();
            //if (nums != null ) {
            //    for (int i=0;i<nums.size();i++){
            //        data.add(nums.getInt(i));
            //    }
            //}
            //this.data = data;
            JsonArray tileData = object.getJsonArray("data");
            for (int i = 0; i < tileData.size(); i++) {
                data.add(tileData.getInt(i));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
