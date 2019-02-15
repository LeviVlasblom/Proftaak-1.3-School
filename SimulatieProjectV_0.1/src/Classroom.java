public class Classroom {
    private String classNumber;
    private int seats;
    private int floorNumber;

    public Classroom(String classNumber, int seats, int floorNumber) {
        this.classNumber = classNumber;
        this.seats = seats;
        this.floorNumber = floorNumber;
    }

    public Classroom(String classNumber){
        this.classNumber = classNumber;
    }

    public String toString() {
        return "" + classNumber;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
