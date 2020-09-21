package controller;

import model.Member;
import persistance.Storage;
import view.MemberView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A class that handles the member controller
 * @author dd222gc (Dennis Demir)
 */
public class MemberController {
    private final Storage storage;
    private final BoatController boatController;
    private final MemberView memView;

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
     * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson) & ph222ue (Patrik Hasselblad)
     */
    public void create(String first, String last, int personalNumber) {
        Member member = new Member(first, last, personalNumber);
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
     * @author nh222mr (Nicklas Hansson) & ph222ue (Patrik Hasselblad)
     */
    public void update(int id, String newFName, String newLName, int newSocNr) {
        storage.editMember(id, newFName, newLName, newSocNr);
        storage.saveData();
    }

    /**
     * Method for creating a new member in the storage
     * @param id - Id of the member to be deleted from storage
     *
     * @return - Returns deleted member
     * @author dd222gc (Dennis Demir) & ph222ue (Patrik Hasselblad)
     */
    public void delete(int id) {
        storage.deleteMember(id);
        storage.saveData();
    }

    /**
     * Method for viewing member with specific id in compact.
     * @param id - Id of the targeted member to view
     *
     * @author dd222gc (Dennis Demir)
     */
    public void viewCompact(int id) {
        this.memView.displayCompactList(storage.getSpecificMember(id));
    }

    /**
     * Method for viewing member with specific id in verbose.
     * @param id - Id of the targeted member to view
     *
     * @author dd222gc (Dennis Demir)
     */
    public void viewVerbose(int id) {
        this.memView.displayVerboseList(storage.getSpecificMember(id));
    }



}
