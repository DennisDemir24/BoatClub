package controller;

import model.Boat;
import model.Member;

import java.util.ArrayList;

/**
 *
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
        member.addBoat(boat);
    }

    /**
     * Method that handles boat editing.
     * @param member - The boat owner.
     * @param oldBoat - The old boat value.
     * @param newBoat - The new boat value.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void editBoat(Member member, Boat oldBoat, Boat newBoat) {
        ArrayList<Boat> boatList = member.getBoatList();
        for (int i = 0; i < boatList.size(); i++) {
            if (boatList.get(i).equals(oldBoat)) {
                boatList.add(i, newBoat);
            } else {
                throw new IllegalArgumentException("There is no boat with that description");
            }
        }
    }

    /**
     * Removes a certain boat from the member boat list.
     * @param member - The boat owner.
     * @param boat - The specific boat.
     * @author ph222ue (Patrik Hasselblad)
     */
    public void removeBoat(Member member, Boat boat) {
        ArrayList<Boat> boatList = member.getBoatList();
        for (int i = 0; i < boatList.size(); i++) {
            if (boatList.get(i).equals(boat)) {
                boatList.remove(i);
            } else {
                throw new IllegalArgumentException("There is no boat with that description");
            }
        }
    }

    /**
     * Method that views a certain boat.
     * @param member - The boat owner.
     * @param boat - The specific boat.
     * @return Boat
     * @author ph222ue (Patrik Hasselblad)
     */
    public Boat viewBoat(Member member, Boat boat) {
        ArrayList<Boat> boatList = member.getBoatList();
        for (int i = 0; i < boatList.size(); i++) {
            if (boatList.get(i).equals(boat)) {
                return boatList.get(i);
            }
        }
        return null;
    }

}
