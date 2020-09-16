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

    public MemberController(Storage storage, MemberView memView) throws IOException {
        this.storage = Storage.getInstance();
        this.memView = new MemberView();
    }

    /**
     * Method for creating a new member in the storage
     * @param member - Member Object
     * @author dd222gc (Dennis Demir)
     */
    public void createMember(Member member) {
        storage.addMember(member);
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
