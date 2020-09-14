package model;

import java.util.ArrayList;

public class Member {
    private final String firstName;
    private final String lastName;
    private final int socialSec;
    private final int memberId;
    private ArrayList<Boat> boatList;

    public Member(String firstName, String lastName, int socialSec) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSec = socialSec;
        this.memberId = setMemberId();
    }

    public int setMemberId() {
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSocialSec() {
        return socialSec;
    }

    public int getMemberId() {
        return memberId;
    }

    public ArrayList<Boat> getBoatList() {
        return boatList;
    }
}
