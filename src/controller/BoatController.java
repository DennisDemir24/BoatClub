package controller;

import model.Boat;
import model.Member;
import model.Type;
import persistance.Storage;

/**
 * A class that handles the member boats; adding, editing, removing and viewing.
 * @author ph222ue (Patrik Hasselblad)
 */
public class BoatController {
    private final Storage storage;

    public BoatController () {
        this.storage = Storage.getInstance();

    }

    /**
     * Adds a boat to a certain member.
     * @param boatType - The boat type
     * @param length - The length of the boat in meters
     * @param ownerId - The id of the owner of the boat
     * @author ph222ue (Patrik Hasselblad) & nh222mr (Nicklas Hansson)
     */
    public void createBoat(Type boatType, double length, int ownerId) {
        Boat newBoat = new Boat(boatType, length, ownerId);
        Member member = storage.getMember(ownerId);
        int boatId = member.getBoatList().size() + 1;
        newBoat.setBoatId(boatId);

        int index = member.getBoatList().size();

        member.addBoat(index, newBoat);
        storage.saveData();
    }

    /**
     * Method that handles boat editing.
     * @param ownerId - The boat owners ID.
     * @param id - The boat ID.
     * @param type - The new boat type.
     * @param length - The new boat length.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editBoat(int ownerId, int id, Type type, double length) {
        Member owner = storage.getMember(ownerId);

        for (int i = 0; i < owner.getBoatList().size(); i++) {
            if (owner.getBoatList().get(i).getBoatId() == id) {
                owner.getBoatList().get(i).setType(type);
                owner.getBoatList().get(i).setLength(length);
            } else {
                System.out.println("No boat exists with that ID");
            }
        }
        storage.saveData();
    }

    /**
     * Removes a certain boat from the member boat list.
     * @param ownerId - The boat owner ID.
     * @param boatId - The specific boat ID.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void removeBoat(int ownerId, int boatId) {
        Member member = storage.getMember(ownerId);

        for (int i = 0; i < member.getBoatList().size(); i++) {

            if (member.getBoat(boatId).getBoatId() == boatId) {
                member.getBoatList().remove(i);
            } else {
                System.out.println("No boat exists with that ID");
            }
            storage.saveData();
        }
        //ToDo: When removing a boat, the ID we will be forfeit. Same with members, perhaps think about this.
    }

}
