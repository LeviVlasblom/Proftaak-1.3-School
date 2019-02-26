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

    public TiledLayer(String fileName) {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new FileInputStream("resources//" +fileName));

        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        JsonObject root = reader.readObject();
        try{
            this.ID = root.getJsonObject("layers").getInt("ID");
            this.name = root.getJsonObject("layers").getString("name");
            JsonArray nums = root.getJsonObject("layers").getJsonArray("data");
            ArrayList<Integer> data = new ArrayList<>();
            if (nums != null ) {
                for (int i=0;i<nums.size();i++){
                    data.add(nums.getInt(i));
                }
            }
            this.data = data;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
