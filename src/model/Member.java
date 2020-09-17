package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

public class Member {
    private String firstName;
    private String lastName;
    private int socialSec;
    private int memberId;
    private ArrayList<Boat> boatList = new ArrayList<>();

//    public Member(String firstName, String lastName, int socialSec) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.socialSec = socialSec;
//        this.memberId = setMemberId();
//    }

    /**
     * A JSON friendly constructor.
     * @param fN - first name
     * @param lN - Last name
     * @param socialNr - social security number.
     * @author ph222ue (Patrik Hasselblad)
     */
    public Member(@JsonProperty("firstName") String fN, @JsonProperty("lastName") String lN, @JsonProperty("socialSec") int socialNr, @JsonProperty("memberId") int id, @JsonProperty("boatList") ArrayList<Boat> loadedBoatList) {
        this.firstName = fN;
        this.lastName = lN;
        this.boatList = loadedBoatList;
        this.socialSec = socialNr;
        if (id == 0) { //--------------------- Vi kanske bör flytta ID hanteringen till ett bättre ställe.
            memberId = setMemberId();
        } else {
            this.memberId = id;
        }
    }

    public Member() {}

    public int setMemberId() {

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
