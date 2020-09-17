package controller;

import model.Member;
import persistance.Storage;
import view.MemberView;

import java.io.IOException;

/**
 * A class that handles the member controller
 * @author dd222gc (Dennis Demir)
 */
public class MemberController {
    private Storage storage;
    private MemberView memView;

    public MemberController() throws IOException {
        this.storage = Storage.getInstance();
        this.memView = new MemberView();
    }

    /**
     * Method for creating a new member in the storage
     * @param member - Member Object
     * @author dd222gc (Dennis Demir)
     */
    public void create(Member member) {
        storage.addMember(member);
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



}
