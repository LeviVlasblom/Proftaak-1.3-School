package Maploader.Tiled;

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
        this.data = new ArrayList<>();
        this.height = object.getInt("height");
        this.width = object.getInt("width");
        this.ID = object.getInt("id");
        this.name = object.getString("name");
        //JsonObject root = reader.readObject();
        try{
            //this.ID = root.getJsonObject("layers").getInt("ID");
            //this.name = root.getJsonObject("layers").getString("name");
            JsonArray nums = object.getJsonArray("data");
            //this.width = root.getJsonObject("layers").getInt("width");
            //this.height = root.getJsonObject("layers").getInt("height");
            if (nums != null ) {
                for (int i=0;i<nums.size();i++){
                        this.data.add(nums.getInt(i));
                    }
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

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getData() {
        return data;
    }
}
