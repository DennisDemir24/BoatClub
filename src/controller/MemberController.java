package controller;

import model.Member;
import model.Register;
import view.MemberView;

import java.util.ArrayList;

/**
 * A class that handles the member controller
 * @author dd222gc (Dennis Demir)
 */
public class MemberController extends BoatController {
    private ArrayList<Member> storage;
    private final MemberView memView;
    private final Register register;

    public MemberController() {
        this.register = new Register();
        this.memView = new MemberView();
        this.storage = register.getStorageList();
    }

    /**
     * Method for viewing member with specific id.
     * @param id - Id of the targeted member to view
     *
     * @author dd222gc (Dennis Demir)
     */
    public void viewCompact(int id) {
        this.storage = register.getStorageList();
        this.memView.displayCompactList(storage.get(id - 1));
    }

    /**
     * Method for viewing member with specific id.
     * @param id - Id of the targeted member to view.
     *
     * @author dd222gc (Dennis Demir)
     */
    public void viewVerbose(int id) {
        this.storage = register.getStorageList();
        this.memView.displayVerboseList(storage.get(id - 1));
    }

}
