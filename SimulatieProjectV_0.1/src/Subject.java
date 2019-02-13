import java.sql.Time;

public class Subject {
    private String name;
    private Teacher teacher;

    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
    public Subject(String name){
        this.name = name;
    }

    public String toString() {
        return "" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
