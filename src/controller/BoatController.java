package controller;

import model.*;
import view.MemberView;

import java.util.ArrayList;

/**
 * A class that handles the member boats; adding, editing, removing and viewing.
 * @author ph222ue (Patrik Hasselblad)
 */
public class BoatController {
    private ArrayList<Member> storage;
    private final Register register;
    private final MemberView memView;

    public BoatController () {
        this.register = new Register();
        this.memView = new MemberView();
        this.storage = register.getStorageList();
    }

    /**
     * Adds a boat to a certain member.
     * @author ph222ue (Patrik Hasselblad) & nh222mr (Nicklas Hansson)
     */
    public void createBoat(BoatType boatType, double length, int ownerId) {
        this.storage = register.getStorageList();
        Boat newBoat = new Boat(boatType, length, ownerId);
        Member member = storage.get(ownerId - 1);
        int boatId = member.getBoatList().size() + 1;
        newBoat.setBoatId(boatId);

        int index = member.getBoatList().size();

        member.addBoat(index, newBoat);
        register.createNewBoat();
    }

    /**
     * Method that handles boat editing.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editBoat(int ownerId, int id, BoatType boatType, double length) {
        this.storage = register.getStorageList();

        Member owner = storage.get(ownerId - 1);

        for (int i = 0; i < owner.getBoatList().size(); i++) {
            if (owner.getBoatList().get(i).getBoatId() == id) {
                owner.getBoatList().get(i).setType(boatType);
                owner.getBoatList().get(i).setLength(length);
                break;
            } else {
                memView.displayBoatIdError();
            }
        }
        register.updateBoat();
    }

    /**
     * Removes a certain boat from the member boat list.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void removeBoat(int ownerId, int boatId) {
        this.storage = register.getStorageList();

        Member member = storage.get(ownerId - 1);

        for (int i = 0; i < member.getBoatList().size(); i++) {

            if (member.getBoat(boatId).getBoatId() == boatId) {
                member.getBoatList().remove(i);

                for (int j = 0; j < storage.get(ownerId - 1).getBoatList().size(); j++) {
                    if (storage.get(ownerId - 1).getBoatList().size() > 0) {
                        storage.get(ownerId - 1).getBoatList().get(j).setBoatId(j + 1);
                    }
                }

            } else {
                memView.displayBoatIdError();
            }
            register.deleteBoat();
        }
    }

}
