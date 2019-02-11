import java.io.*;
import java.sql.Time;
import java.util.ArrayList;

public class RosterHours {
    Subject subject;
    Class schoolClass;
    Time startTime;
    Time endTime;
    Teacher teacher;
    Classroom classroom;

    public RosterHours(Subject subject, Class schoolClass, Time startTime, Time endTime, Teacher teacher, Classroom classroom) {
        this.subject = subject;
        this.schoolClass = schoolClass;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.classroom = classroom;
    }




    public void writeRosterHours(Subject subject, Class schoolClass, Time startTime, Time endTime, Teacher teacher, Classroom classroom) {
        File file = new File("src//rosterhours.txt");
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            String rosterHourDataFormat = schoolClass.getClassID() + "/" + subject.getName() + "/" + teacher.getName() + "/" + classroom.getClassNumber() + "/" + startTime + "/" + endTime;
            output.println(rosterHourDataFormat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert output != null;
            output.close();
        }
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Class getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(Class schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}