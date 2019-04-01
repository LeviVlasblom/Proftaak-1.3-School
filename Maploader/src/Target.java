public class Target {
    private String name;
    private Pathfind pathfind;

    public Target(String name, int x, int y, boolean[][] collision) {
        this.name = name;
        this.pathfind = new Pathfind(x, y, collision);
    }


    public String getName() {
        return name;
    }

    public Pathfind getPathfind() {
        return pathfind;
    }
}
