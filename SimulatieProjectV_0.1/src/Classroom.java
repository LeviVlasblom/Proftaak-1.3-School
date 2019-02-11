public class Classroom {
    private int classNumber;
    private int seats;
    private int floorNumber;

    public Classroom(int classNumber, int seats, int floorNumber) {
        this.classNumber = classNumber;
        this.seats = seats;
        this.floorNumber = floorNumber;
    }

    public Classroom(int classNumber){
        this.classNumber = classNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
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
