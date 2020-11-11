package view;

import controller.MenuActions;
import model.Boat;
import model.Member;

import java.util.Scanner;

/**
 * A Class for the Main View
 * @author "dd222gc Dennis Demir"
 */
public class MainView {
    private Scanner s = new Scanner(System.in);

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

    public MenuActions getMenuActions() {
        int input;

        while (!s.hasNextInt()) {
            s.next();
            System.out.println("Invalid input. Please provide a number between 1-10, and 0 to quit the app");
        }

        input = s.nextInt();
        s.nextLine();

        switch (input) {
            case 1:
                return MenuActions.VIEW_COMPACT;
            case 2:
                return MenuActions.VIEW_VERBOSE;
            case 3:
                return MenuActions.CREATE_MEMBER;
            case 4:
                return MenuActions.UPDATE_MEMBER_INFO;
            case 5:
                return MenuActions.DELETE_MEMBER;
            case 6:
                return MenuActions.VIEW_SPECIFIC_MEMBER;
            case 7:
                return MenuActions.CREATE_BOAT;
            case 8:
                return MenuActions.EDIT_BOAT;
            case 9:
                return MenuActions.DELETE_BOAT;
            case 10:
                return MenuActions.VIEW_BOAT;
            case 0:
                return MenuActions.QUIT;
            default:
                return MenuActions.DEFAULT;
        }
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
     * Method that display message for wrong input
     * @author "dd222gc Dennis Demir"
     */
    public void displayWrongInputMessage() {
        System.out.println("Please select a number between 1 and 10 to make a choice, or 0 to quit");
    }

    /**
     * Method that display message for wrong member ID input
     * @author "dd222gc Dennis Demir"
     */
    public void displayErrorMessageIfWrongUserID() {
        System.out.println("There is no member with that ID");
    }

    /**
     * Method that display message no such boat ID
     * @author "dd222gc Dennis Demir"
     */
    public void displayErrorMessageForBoatID() {
        System.out.println("No boat exists with that ID");
    }

    public void displayErrorMessageForBoatType() {
        System.out.println("Error: There is no such boat type.");
    }


    /**
     * Method that views a certain boat.
     * @author dd222gc (Dennis Demir) & ph222ue (Patrik Hasselblad)
     */
    public void displayBoatInfo(Member member, Boat boat) {
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

    /**
     * Method that ask for boat ID.
     * @author ph222ue (Patrik Hasselbald)
     */
    public void displayBoatId() {
        System.out.println("Boat Id: ");
    }

}