package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Boat constructor with getters & setters.
 * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
 */
public class Boat {
    private Type type;
    private double length;
    private final int ownerId;
    private int boatId;

    /**
     * A JSON friendly constructor used by Storage and BoatController.
     * @param boatType - Boat type.
     * @param length - Length of boat.
     * @param ownerId - Id of owner.
     * @param boatId - Unique boat ID.
     * @author ph222ue (Patrik Hasselblad)
     */
    public Boat(@JsonProperty("type") Type boatType, @JsonProperty("length") double length, @JsonProperty("ownerId") int ownerId, @JsonProperty("boatId") int boatId) {
        this.type = boatType;
        this.length = length;
        this.ownerId = ownerId;
        this.boatId = boatId;
    }

    /**
     * Terminal constructor.
     * @author ph222ue (Patrik Hasselblad)
     */
    public Boat(Type boatType, double length, int ownerId) {
        this.type = boatType;
        this.length = length;
        this.ownerId = ownerId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
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

    public int getBoatId() {
        return boatId;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
