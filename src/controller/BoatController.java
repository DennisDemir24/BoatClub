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
     * @param owner - The boat owner.
     * @param id - The old boat value.
     * @param type - The new boat type.
     * @param length - The new boat length.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editBoat(Member owner, int id, Type type, double length) {
        Member member = owner;
        Boat boat = member.getBoatList().get(id);
        boat.setType(type);
        boat.setLength(length);

        if (id == -1) {
                throw new IllegalArgumentException("There is no boat with that description");
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
//        for (int i = 0; )storage.getMemberList().get()

//        int index = member.getBoat(boat.getBoatId());
//            if (index == -1) {
//                throw new IllegalArgumentException("There is no boat with that description");
//            }
//        member.getBoatList().remove(index);
    }

    /**
     * Method that views a certain boat.
     * @param member - The boat owner.
     * @param boat - The specific boat.
     * @return Boat
     * @author ph222ue (Patrik Hasselblad)
     */
    public Boat viewBoat(Member member, Boat boat) {
//        int index = member.getBoat(boat);
//
//        if (index == -1) {
//            throw new IllegalArgumentException("There is no boat with that description");
//        }
//
//        return member.getBoatList().get(index);
        return null;
    }

}
