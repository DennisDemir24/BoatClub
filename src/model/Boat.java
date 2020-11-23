package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Boat constructor with getters & setters.
 * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
 */
public class Boat {
    private BoatType boatType;
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
    public Boat(@JsonProperty("boatType") BoatType boatType, @JsonProperty("length") double length, @JsonProperty("ownerId") int ownerId, @JsonProperty("boatId") int boatId) {
        this.boatType = boatType;
        this.length = length;
        this.ownerId = ownerId;
        this.boatId = boatId;
    }

    /**
     * Terminal constructor.
     * @author ph222ue (Patrik Hasselblad)
     */
    public Boat(BoatType boatType, double length, int ownerId) {
        this.boatType = boatType;
        this.length = length;
        this.ownerId = ownerId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
    }

    public double getLength() {
        return length;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public int getBoatId() {
        return boatId;
    }

    public void setType(BoatType boatType) {
        this.boatType = boatType;
    }

    public void setLength(double length) {
        this.length = length;
    }
}