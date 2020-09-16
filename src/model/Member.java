package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Creates members.
 * @author ph222ue (Patrik Hasselblad), dd222gc (Dennis Demir)
 */
public class Member {
    private String firstName;
    private String lastName;
    private int socialSec;
    private int memberId;
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
//        if (id == 0) { //--------------------- Vi kanske bör flytta ID hanteringen till ett bättre ställe.
//            memberId = setMemberId();
//        } else {
            this.memberId = id;
//        }
    }

    /**
     * Terminal constructor.
     */
    public Member(String fN, String lN, int socialNr) {
        this.firstName = fN;
        this.lastName = lN;
        this.socialSec = socialNr;


    } // Kanske ska vi lägga in variablerna här också så att vi kan ta bort alla setters? (Kör vi med JSON constructorn så måste vi ange båtar och memberId också, vilket bara blir konstigt och invecklat.

    private int setMemberId() {
        int temp = Integer.toString(socialSec).hashCode();
        if (temp < 0) {
            temp = temp * 2;
        }
        return temp;
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

    public void addBoat(Boat boat) {
        boatList.add(boat);
    }

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }
}
