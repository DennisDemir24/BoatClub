package view;

import java.util.Scanner;

/**
 * A Class for the Main View
 * @author "dd222gc Dennis Demir"
 */
public class MainView {
    private Scanner sc = new Scanner(System.in);

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
        do {
            System.out.println("******");
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

            int input = sc.nextInt();

            if (input == 0) {
                break;
            }

            switch (input) {
                case 1:
                    displayCompactList();
                    break;
                case 2:
                    displayVerboseList();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    displayBoatInfo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please use a number to make a choice");
            }
        } while (1 != 0);
    }

    /**
     * Method that display the compact list
     * @author "dd222gc Dennis Demir"
     */
    public void displayCompactList() {
        System.out.println(
                "Name: " +  " " +  "\n" +
                        "Member ID: " +  "\n" +
                        "Number of Boats: "
        );
    }

    /**
     * Method that display the verbose list
     * @author "dd222gc Dennis Demir"
     */
    public void displayVerboseList() {
        System.out.println(
                "Name: " +  " " +  "\n" +
                        "Personal Number: " +  "\n" +
                        "Member ID: " +  "\n" +
                        "Boats: " + "\n"
        );
    }

    /**
     * Method that display boat info
     * @author "dd222gc Dennis Demir"
     */
    public void displayBoatInfo() {
        String boatInfo = "Boat: " + "BOAT TYPE" + " - " + "Length: " + "BOAT LENGTH";
        System.out.println(boatInfo);
    }
}
