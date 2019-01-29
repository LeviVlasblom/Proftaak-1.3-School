import java.sql.Date;
import java.sql.Time;

public class Roster {
    private Time time;
    private Date day;
    private Classroom classroom;
    private Student student;
    private Teacher teacher;
    private boolean Lunchbreak;
    private Subject subjects;

    public Roster(Time time, Date day, Classroom classroom, Student student, Teacher teacher, boolean lunchbreak, Subject subjects) {
        this.time = time;
        this.day = day;
        this.classroom = classroom;
        this.student = student;
        this.teacher = teacher;
        Lunchbreak = lunchbreak;
        this.subjects = subjects;
    }



}
