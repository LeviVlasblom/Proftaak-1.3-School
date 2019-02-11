import javafx.stage.FileChooser;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Roster {
    private Date day;
    private boolean Lunchbreak;
    private ArrayList<RosterHours> rosterhours;

    public Roster(Date day, boolean lunchbreak) {
        this.day = day;
        Lunchbreak = lunchbreak;
    }

    public void readRosterHours ( String filename ) {


        try {
            ObjectInputStream i = new ObjectInputStream( new FileInputStream( "Files" + "\\" + filename) );

            try {
                ArrayList<RosterHours> RosterHours = (ArrayList<RosterHours>) i.readObject();

                this.rosterhours = RosterHours;

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFile() {
        String fileName = "";
        FileChooser fileChooser = new FileChooser();
        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);
        fileChooser.setInitialDirectory(userDirectory);
        File selectedFile = fileChooser.showOpenDialog(null);


        if (selectedFile != null) {
            System.out.println("Found u my lord!");
            fileName = selectedFile.getName();
            System.out.println(fileName);

            String line = null;

            try {

                FileReader fileReader = new FileReader("Files" + "\\" + fileName);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                readRosterHours(fileName);

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                fileName + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + fileName + "'");
            }
        }

    }
}
