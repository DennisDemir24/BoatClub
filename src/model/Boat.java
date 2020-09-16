package model;



public class Boat {
    private Type type;
    private final double length;
    private final int ownerId;

    public Boat(Type boatType, double length, int ownerId) { //(BoatType type, double length, int ownerId) {
        this.type = boatType;
        this.length = length;
        this.ownerId = ownerId;
    }

    public double getLength() {
        return length;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public Type getType() {
        return type;
    }
}
