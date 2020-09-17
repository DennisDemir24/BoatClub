package controller;

import model.Boat;
import model.Member;

/**
 * A class that handles the member boats; adding, editing, removing and viewing.
 * @author ph222ue (Patrik Hasselblad)
 */
public class BoatController {

    public static void boatView () {

    }

    /**
     * Adds a boat to a certain member.
     * @param member - The member to store a boat to.
     * @param boat - The boat to store to the member information.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void createBoat(Member member, Boat boat) {
        member.addBoat(member.getBoatList().size(), boat);
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
