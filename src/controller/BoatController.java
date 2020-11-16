package controller;

import model.Boat;
import model.Member;
import model.Register;
import model.Type;
import view.MemberView;

import java.util.ArrayList;

/**
 * A class that handles the member boats; adding, editing, removing and viewing.
 * @author ph222ue (Patrik Hasselblad)
 */
public class BoatController {
    private final ArrayList<Member> storage;
    private final Register register;
    private final MemberView memView;

    public BoatController () {
        this.register = new Register();
        this.memView = new MemberView();
        this.storage = new ArrayList<Member>(register.getStorageList());
    }

    /**
     * Adds a boat to a certain member.
     * @author ph222ue (Patrik Hasselblad) & nh222mr (Nicklas Hansson)
     */
    public void createBoat(Type boatType, double length, int ownerId) {
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
    public void editBoat(int ownerId, int id, Type type, double length) {
        Member owner = storage.get(ownerId - 1);

        for (int i = 0; i < owner.getBoatList().size(); i++) {
            if (owner.getBoatList().get(i).getBoatId() == id) {
                owner.getBoatList().get(i).setType(type);
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
