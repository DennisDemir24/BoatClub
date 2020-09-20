package controller;

import model.Boat;
import model.Member;
import model.Type;
import persistance.Storage;
import view.MemberView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class that handles the member controller
 * @author dd222gc (Dennis Demir)
 */
public class MemberController {
    private Storage storage;
    private BoatController boatController;
    private MemberView memView;

    public MemberController() throws IOException {
        this.storage = Storage.getInstance();
        this.memView = new MemberView();
        this.boatController = new BoatController();
    }

    /**
     * Method for creating a new member
     * @param first - String - first name of new member
     * @param last - String - last name of new member
     * @param personalNumber - int - social security number of new member
     * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
     */
    public void create(String first, String last, int personalNumber) {
        Type canoe = Type.CANOE;
        Random rand = new Random();
        int id = rand.nextInt(1000000);

        ArrayList<Boat> boatList = new ArrayList<>();
        boatList.add(boatController.createBoat(canoe, 18, id));

        Member member = new Member(first, last, personalNumber, id, boatList);
        storage.addMember(member);
        ArrayList<Member> memList = storage.getMemberList();

        memList.forEach((m) -> System.out.println(m.getFirstName()));

        storage.saveData();
        // Add function call for displaying correct view message
    }

    /**
     * Method for returning a new member from the storage
     * @param id - int memberId
     * @author nh222mr (Nicklas Hansson)
     */
    public Member read(int id) { return storage.getMember(id); }

    /**
     * Method for returning a new member from the storage
     * @param id - int memberId
     * @author nh222mr (Nicklas Hansson)
     */
    public void update(int id) {
        storage.getMember(id);
    }

    /**
     * Method for creating a new member in the storage
     * @param id - Id of the member to be deleted from storage
     *
     * @return - Returns deleted member
     * @author dd222gc (Dennis Demir)
     */
    public Member delete(int id) {
        Member member = storage.getMember(id);
        storage.deleteMember(id);

        return member;
    }

    /**
     * Method for viewing member with specific id.
     * @param id - Id of the targeted member to view
     *
     * @author dd222gc (Dennis Demir)
     */
    public void viewCompact(int id) {
        this.memView.displayCompactList(storage.getSpecificMember(id));
    }



}
