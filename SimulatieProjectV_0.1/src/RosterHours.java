import javafx.collections.ObservableList;

import java.io.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class RosterHours {
//    Subject subject;
//    Class schoolClass;
//    Time startTime;
//    Time endTime;
//    Teacher teacher;
//    Classroom classroom;

    Subject subject;
    Class schoolClass;
    LocalTime startTime;
    LocalTime endTime;
    Teacher teacher;
    Classroom classroom;

    public RosterHours(Subject subject, Class schoolClass, LocalTime startTime, LocalTime endTime, Teacher teacher, Classroom classroom) {
        this.subject = subject;
        this.schoolClass = schoolClass;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.classroom = classroom;
    }

    public String toString() {
        return " Vak: " + subject + " Klas: " + schoolClass + " Begin Tijd " + startTime + " Eind Tijd "
                + endTime + " Docent " + teacher + " Lokaal " + classroom;
    }


//    public void writeRosterHours(Subject subject, Class schoolClass, Time startTime, Time endTime, Teacher teacher, Classroom classroom) {
//        File file = new File("src//rosterhours.txt");
//        PrintWriter output = null;
//        try {
//            output = new PrintWriter(file);
//            String rosterHourDataFormat = schoolClass.getClassID() + "/" + subject.getName() + "/" + teacher.getName() + "/" + classroom.getClassNumber() + "/" + startTime + "/" + endTime;
//            output.println(rosterHourDataFormat);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            assert output != null;
//            output.close();
//        }
//    }

    public String writeRosterHours() {

          return schoolClass.getName() + "/" + subject.getName() + "/" + teacher.getName() + "/" + classroom.getClassNumber() + "/" + startTime + "/" + endTime;

    }

    public static void saveRosterHours(ObservableList<RosterHours> list){
        File file = new File("Files//RosterHours.txt");
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            for(RosterHours rosterHours : list){
                output.println(rosterHours.writeRosterHours());
            }
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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