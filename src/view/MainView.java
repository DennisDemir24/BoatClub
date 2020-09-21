package view;

import controller.MainController;
import model.Boat;
import model.Member;

import java.util.Scanner;

/**
 * A Class for the Main View
 * @author "dd222gc Dennis Demir"
 */
public class MainView {
    private Scanner sc = new Scanner(System.in);
    private MainController mainController;

    public MainView() {
    }

    /**
     * Method that prints a welcome message.
     * @author "dd222gc Dennis Demir"
     */
    public void displayWelcomeMessage() {
        System.out.println("**** Welcome To Boat Club ****");
        displayMenuOptions();
    }

    /**
     * Method that display the menu
     * @author "dd222gc Dennis Demir"
     */
    public void displayMenuOptions() {
            System.out.println();
            System.out.println("1. Show Compact List Of Members");
            System.out.println("2. Show Verbose List Of Members");
            System.out.println("3. Register New Member");
            System.out.println("4. Change Member Information");
            System.out.println("5. Delete Member");
            System.out.println("6. View Member Information");
            System.out.println("7. Create Boat");
            System.out.println("8. Update Boat");
            System.out.println("9. Delete Boat");
            System.out.println("10. View Boat");
            System.out.println("0. Quit");
    }

    /**
     * Method that views a certain boat.
     * @param member - The boat owner.
     * @param boatId - The specific boats ID.
     * @author dd222gc (Dennis Demir) & ph222ue (Patrik Hasselblad)
     */
    public void displayBoatInfo(Member member, int boatId) {
        Boat boat = member.getBoat(boatId);

        System.out.println("Boat Owner: " + member.getFirstName() + " " + member.getLastName() + "\n" +
                "Boat ID: " + boat.getBoatId() + "\n" +
                "Boat Type: " + boat.getType() + "\n" +
                "Boat Length: " + boat.getLength() + "\n");
    }

    /**
     * Method that ask for boat number / Id
     * @author "dd222gc Dennis Demir"
     */
    public void displayBoatNumber() {
        System.out.println("Owner member ID: ");
    }

    /**
     * Method that ask for boat legnth
     * @author "dd222gc Dennis Demir"
     */
    public void displayBoatLength() {
        System.out.println("Boat Length: ");
    }

    /**
     * Method that ask for boat type
     * @author "dd222gc Dennis Demir"
     */
    public void displayBoatType() {
        System.out.println("Boat Type (C = Canoe, S = sailboat, M = motorsailer, K = kayak, O = other): ");
    }

    public void displayBoatId() {
        System.out.println("Boat Id: ");
    }

}
