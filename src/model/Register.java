package model;

import persistance.Storage;

public class Register {
    private final Storage storage;


    public Register() {
        this.storage = Storage.getInstance();
    }


    public void createNewMember(String firstName, String lastName, int personalNumber) {
        Member member = new Member(firstName, lastName, personalNumber);
        storage.addMember(member);

        storage.saveData();
    }

    public void deleteMember(int id) {
        storage.deleteMember(id);
        storage.saveData();
    }

    public void updateMember(int id, String newFirstName, String newLastName, int newSocNr) {
        storage.editMember(id, newFirstName, newLastName, newSocNr);
        storage.saveData();
    }
}