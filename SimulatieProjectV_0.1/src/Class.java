import java.util.ArrayList;

public class Class {
    private String name;
    private ArrayList<Student> students;
    private int classID;



    public Class(String name, ArrayList<Student> students, int classID) {
        this.name = name;
        this.students = students;
        this.classID = classID;
    }

    public Class(String name){
        this.name = name;
    }

    public String toString() {
        return "" + name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
