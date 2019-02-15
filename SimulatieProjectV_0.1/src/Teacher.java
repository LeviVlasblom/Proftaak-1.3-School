import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
    private String name;
    private Subject subject;
    private int teacherID;
    private ArrayList<Teacher> nameTeacher;

    public Teacher(String name, Subject subject, int teacherID) {
        this.name = name;
        this.subject = subject;
        this.teacherID = teacherID;
    }

    public Teacher(String name){
        this.name = name;
    }

    public Teacher() {
        this.nameTeacher = new ArrayList<>();
    }


    public String toString() {
        return "" + name;
    }

    public void writeTeachers (int teacherID, String name, Subject subject){
        File file = new File("src//teachers.txt");
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            String studentDataFormat = teacherID + "/" + name + "/" + subject.getName();
            output.println(studentDataFormat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert output != null;
            output.close();
        }
    }

    public void readTeachers(String fileName){
        File file = new File("Files" + "\\" + fileName);
        ArrayList<Teacher> nameTeacher = new ArrayList<>();
        Scanner s = null;

        try {
            s = new Scanner(file);

            while ( s.hasNext() ) {
                String line = s.nextLine();

                String data[] = line.split("/");

                if ( data.length == 3 ) {


                } else {
                    System.out.println("Line could not be parsed: " + line);
                }

                Scanner ls = new Scanner(line);
                ls.useDelimiter("/");

                int id = Integer.parseInt(ls.next());
                String naam = ls.next();
                String vak = ls.next();

                Teacher leraar = new Teacher(naam);

                nameTeacher.add(leraar);

                this.nameTeacher = nameTeacher;
                System.out.println(nameTeacher.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Teacher> getTeacher(){
        return this.nameTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
