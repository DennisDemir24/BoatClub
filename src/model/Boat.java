package model;


import org.codehaus.jackson.annotate.JsonProperty;

public class Boat {
    private Type type;
    private final double length;
    private final int ownerId;

    public Boat(@JsonProperty("type") Type boatType, @JsonProperty("length") double length, @JsonProperty("ownerId") int ownerId) {
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
