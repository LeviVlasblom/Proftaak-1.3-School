import java.util.ArrayList;

public class Student {
    private String name;
    private int studentNumber;
    private ArrayList<Subject> subjects;
    private boolean hasToPee;

    public Student(String name, int studentNumber, ArrayList<Subject> subjects, boolean hasToPee) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.subjects = subjects;
        this.hasToPee = hasToPee;
    }
}
