import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Roster {
    private Date day;
    private boolean Lunchbreak;
    private ArrayList<RosterHours> period;

    public Roster(Date day, boolean lunchbreak) {
        this.day = day;
        Lunchbreak = lunchbreak;
    }

    public Roster () {
        this.period = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Rooster{" +
                "lessen=" + period +
                '}';
    }

    public void readRosterHours ( String filename ) {

        File file = new File("Files" + "\\" + filename);
        ArrayList<RosterHours> period = new ArrayList<>();
        Scanner s = null;

        try {
            s = new Scanner(file);

            while ( s.hasNext() ) {
                String line = s.nextLine();

                String data[] = line.split("/");

                if ( data.length == 6 ) {


                } else {
                    System.out.println("Line could not be parsed: " + line);
                }

                Scanner ls = new Scanner(line);
                ls.useDelimiter("/");

                String klas = ls.next();
                Class clas = new Class(klas);

                String vak = ls.next();
                Subject subject = new Subject(vak);

                String docent = ls.next();
                Teacher teacher = new Teacher(docent);

                String lokaal = ls.next();
                Classroom classroom = new Classroom(lokaal);

                String beginTijdS = ls.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime beginTijdL = LocalTime.parse(beginTijdS, formatter);

                String eindTijdS = ls.next();
                LocalTime eindTijdL = LocalTime.parse(eindTijdS, formatter);

                RosterHours les = new RosterHours(subject, clas, beginTijdL, eindTijdL, teacher, classroom );
                period.add(les);
                this.period = period;
                System.out.println(period.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<RosterHours> getList(){

        ObservableList<RosterHours> list = FXCollections.observableList(this.period);
        return list;
    }

    public void openFile() {
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
    public ArrayList<RosterHours> getPeriod(){
        return this.period;
    }
}
