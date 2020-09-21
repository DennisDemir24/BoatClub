package model;


import org.codehaus.jackson.annotate.JsonProperty;

public class Boat {
    private final Type type;
    private final double length;
    private final int ownerId;

    /**
     * A JSON friendly constructor used by Storage and BoatController.
     * @param boatType - Boat type.
     * @param length - Length of boat.
     * @param ownerId - Id of owner.
     * @author ph222ue (Patrik Hasselblad)
     */
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
