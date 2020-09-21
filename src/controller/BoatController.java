package controller;

import model.Boat;
import model.Member;
import model.Type;

/**
 * A class that handles the member boats; adding, editing, removing and viewing.
 * @author ph222ue (Patrik Hasselblad)
 */
public class BoatController {

    public BoatController () {


    }

    /**
     * Adds a boat to a certain member.
     * @param boatType - The boat type
     * @param length - The length of the boat in meters
     * @param ownerId - The id of the owner of the boat
     * @author ph222ue (Patrik Hasselblad) & nh222mr (Nicklas Hansson)
     */

    //public void createBoat(Member member, Boat boat) {
      //  member.addBoat(member.getBoatList().size(), boat);

    public Boat createBoat(Type boatType, double length, int ownerId) {
        Boat newBoat = new Boat(boatType, length, ownerId);
        return newBoat;

    }

    /**
     * Method that handles boat editing.
     * @param member - The boat owner.
     * @param oldBoat - The old boat value.
     * @param newBoat - The new boat value.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editBoat(Member member, Boat oldBoat, Boat newBoat) {
        int index = member.getBoat(oldBoat);
        if (index == -1) {
                throw new IllegalArgumentException("There is no boat with that description");
            }
        member.addBoat(index, newBoat);
    }

    /**
     * Removes a certain boat from the member boat list.
     * @param member - The boat owner.
     * @param boat - The specific boat.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void removeBoat(Member member, Boat boat) {
        int index = member.getBoat(boat);
            if (index == -1) {
                throw new IllegalArgumentException("There is no boat with that description");
            }
        member.getBoatList().remove(index);
    }

    /**
     * Method that views a certain boat.
     * @param member - The boat owner.
     * @param boat - The specific boat.
     * @return Boat
     * @author ph222ue (Patrik Hasselblad)
     */
    public Boat viewBoat(Member member, Boat boat) {
        int index = member.getBoat(boat);

        if (index == -1) {
            throw new IllegalArgumentException("There is no boat with that description");
        }

        return member.getBoatList().get(index);
    }

}
