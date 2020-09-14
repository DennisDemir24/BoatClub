package model;

public class Boat {
    //private BoatType type;
    private final double length;
    private final int ownerId;

    public Boat(double length, int ownerId) { //(BoatType type, double length, int ownerId) {
        //this.type = type;
        this.length = length;
        this.ownerId = ownerId;
    }

    public double getLength() {
        return length;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
