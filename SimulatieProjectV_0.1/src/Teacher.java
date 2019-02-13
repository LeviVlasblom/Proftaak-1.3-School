import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Teacher {
    private String name;
    private Subject subject;
    private int teacherID;

    public Teacher(String name, Subject subject, int teacherID) {
        this.name = name;
        this.subject = subject;
        this.teacherID = teacherID;
    }

    public String toString() {
        return "" + name;
    }

    public Teacher(String name){
        this.name = name;
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
