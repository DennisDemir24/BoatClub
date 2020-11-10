package model;

import org.codehaus.jackson.annotate.JsonProperty;
import model.persistance.Storage;

import java.util.ArrayList;

/**
 * Creates members.
 * @author ph222ue (Patrik Hasselblad) & dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
 */
public class Member {
    private String firstName;
    private String lastName;
    private int socialSec;
    private final int memberId;
    private ArrayList<Boat> boatList = new ArrayList<>();

    /**
     * A JSON friendly constructor used by Storage when loading from file.
     * @param fN - first name
     * @param lN - Last name
     * @param socialNr - social security number.
     * @param loadedBoatList - The Member boat list.
     * @author ph222ue (Patrik Hasselblad)
     */
    public Member(@JsonProperty("firstName") String fN, @JsonProperty("lastName") String lN, @JsonProperty("socialSec") int socialNr, @JsonProperty("memberId") int id, @JsonProperty("boatList") ArrayList<Boat> loadedBoatList) {
        this.firstName = fN;
        this.lastName = lN;
        this.boatList = loadedBoatList;
        this.socialSec = socialNr;
        this.memberId = id;
    }

    /**
     * Terminal constructor.
     * @author dd222gc (Dennis Demir), ph222ue (Patrik Hasselblad)
     */
    public Member(String fN, String lN, int socialNr) {
        this.firstName = fN;
        this.lastName = lN;
        this.socialSec = socialNr;
        this.memberId = setMemberId();
    }

    /**
     * Method that recieves a unique ID based on list size.
     * @author ph222ue (Patrik Hasselblad)
     * @return int
     */
    private int setMemberId() {
        Storage storage = new Storage();
        return storage.createMemberId();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String name) {
        this.lastName = name;
    }

    public int getSocialSec() {
        return socialSec;
    }

    public void setSocialSec(int number) {
        this.socialSec = number;
    }

    public int getMemberId() {
        return memberId;
    }

    public void addBoat(int index, Boat boat) {
        boatList.add(index, boat);
    }

    public Boat getBoat(int boatId) {
        for (Boat boat : boatList) {
            if (boat.getBoatId() == boatId) {
                return boat;
            }
        }
        return null;
    }

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }
}