import java.util.ArrayList;

public class Targets {

    public ArrayList<Target> targetsStudents(boolean[][] collision) {
        ArrayList<Target> targets = new ArrayList<>();
        targets.add(new Target("L01",16, 17, collision));
        targets.add(new Target("L02",34, 17, collision));
        targets.add(new Target("L03",56, 17, collision));
        targets.add(new Target("L04",73, 17, collision));
        targets.add(new Target("L05",16, 29, collision));
        targets.add(new Target("L06",34, 29, collision));
        targets.add(new Target("L07",16, 46, collision));
        targets.add(new Target("L08",34, 46, collision));
        targets.add(new Target("C1",69, 30, collision));
        targets.add(new Target("BB",67, 49, collision));
        targets.add(new Target("GB",76, 49, collision));
        targets.add(new Target("Exit",44, 62, collision));
        return targets;
    }

    public ArrayList<Target> targetsTeachers(boolean[][] collision) {
        ArrayList<Target> targets = new ArrayList<>();
        targets.add(new Target("L01", 9, 17, collision));
        targets.add(new Target("L02", 27, 17, collision));
        targets.add(new Target("L03", 50, 17, collision));
        targets.add(new Target("L04", 67, 17, collision));
        targets.add(new Target("L05", 9, 29, collision));
        targets.add(new Target("L06", 28, 28, collision));
        targets.add(new Target("L07", 10, 46, collision));
        targets.add(new Target("L08", 28, 46, collision));
        targets.add(new Target("TR", 55, 46, collision));
        targets.add(new Target("BB", 67, 47, collision));
        targets.add(new Target("GB", 76, 47, collision));
    //    targets.add(new Target("Exit", 44, 62, collision));
        return targets;
    }




}
