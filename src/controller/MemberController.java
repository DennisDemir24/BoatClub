package controller;

import model.persistance.Storage;
import view.MemberView;

/**
 * A class that handles the member controller
 * @author dd222gc (Dennis Demir)
 */
public class MemberController extends BoatController {
    private final Storage storage;
    private final MemberView memView;

    public MemberController() {
        this.storage = Storage.getInstance();
        this.memView = new MemberView();
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

    /**
     * Method for viewing member with specific id.
     * @param id - Id of the targeted member to view.
     *
     * @author dd222gc (Dennis Demir)
     */
    public void viewVerbose(int id) {
        this.memView.displayVerboseList(storage.getSpecificMember(id));
    }

}
