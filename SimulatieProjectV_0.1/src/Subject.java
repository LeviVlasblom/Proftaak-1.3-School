import java.sql.Time;

public class Subject {
    private String name;
    private Teacher teacher;
    private Time startTime;
    private Time endTime;

    public Subject(String name, Teacher teacher, Time startTime, Time endTime) {
        this.name = name;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
