import java.util.ArrayList;

public class Class {
    private ArrayList<Student> students;
    private int classID;

    public Class(ArrayList<Student> students, int classID) {
        this.students = students;
        this.classID = classID;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }
}
