import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Student {
    private String name;
    private int studentID;
    private Class schoolClass;
    private String groep;
    private ArrayList<Subject> subjects;
    private boolean hasToPee;

    public Student(String name, int studentID, ArrayList<Subject> subjects, boolean hasToPee, Class schoolClass, String groep) {
        this.name = name;
        this.schoolClass = schoolClass;
        this.groep = groep;
        this.studentID = studentID;
        this.subjects = subjects;
        this.hasToPee = hasToPee;
    }

    public void writeStudent (int studentNumber, String name, Class schoolClass, String groep){
        File file = new File("src//students.txt");
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            String studentDataFormat = studentID + "/" + name + "/" + schoolClass.getClassID() + "/" + groep;
            output.println(studentDataFormat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert output != null;
            output.close();
        }
    }
}
