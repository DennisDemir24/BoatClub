package model;

import model.persistance.Storage;

import java.util.ArrayList;

public class Register {
    private final Storage storage;


    public Register() {
        this.storage = Storage.getInstance();
    }


    public void createNewMember(String firstName, String lastName, int personalNumber) {
        Member member = new Member(firstName, lastName, personalNumber);
        storage.addMember(member);
    }

    public void deleteMember(int id) {
        storage.deleteMember(id);
    }

    public void updateMember(int id, String newFirstName, String newLastName, int newSocNr) {
        storage.editMember(id, newFirstName, newLastName, newSocNr);
    }

    public void createNewBoat() {
        storage.boatAction();
    }

    public void deleteBoat() {
        storage.boatAction();
    }

    public void updateBoat() {
        storage.boatAction();
    }

    public ArrayList<Member> getStorageList() {
        return new ArrayList<>(this.storage.getMemberList());
    }
}
