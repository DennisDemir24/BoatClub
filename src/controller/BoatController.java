package controller;

import model.Boat;
import model.Member;
import model.Register;
import model.Type;
import model.persistance.Storage;
import view.MemberView;

/**
 * A class that handles the member boats; adding, editing, removing and viewing.
 * @author ph222ue (Patrik Hasselblad)
 */
public class BoatController {
    private final Storage storage;
    private final Register register;
    private final MemberView memView;

    public BoatController () {
        this.storage = Storage.getInstance();
        this.register = new Register();
        this.memView = new MemberView();
    }

    /**
     * Adds a boat to a certain member.
     * @author ph222ue (Patrik Hasselblad) & nh222mr (Nicklas Hansson)
     */
    public void createBoat(Type boatType, double length, int ownerId) {
        Boat newBoat = new Boat(boatType, length, ownerId);
        Member member = storage.getMember(ownerId);
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
        Member owner = storage.getMember(ownerId);

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
        Member member = storage.getMember(ownerId);

        for (int i = 0; i < member.getBoatList().size(); i++) {

            if (member.getBoat(boatId).getBoatId() == boatId) {
                member.getBoatList().remove(i);

                for (int j = 0; j < storage.getMember(ownerId).getBoatList().size(); j++) {
                    if (storage.getMember(ownerId).getBoatList().size() > 0) {
                        storage.getMember(ownerId).getBoatList().get(j).setBoatId(j + 1);
                    }
                }

            } else {
                memView.displayBoatIdError();
            }
            register.deleteBoat();
        }
    }

}
