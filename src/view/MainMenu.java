package view;

import java.util.Scanner;

/**
 * A Class that...
 * @author "insert name"
 */
public class MainMenu {
    private Scanner sc;

    /**
     * Method that prints a welcome message.
     * @author "insert name"
     */
    public void welcomeMessage() {
        System.out.println("**** Welcome To Boat Club ****");
    }

    /**
     * Method that display the menu
     * @author "insert name"
     */
    public void menuOptions() {
        System.out.println("******");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("1. Show Verbose List Of Members");
                break;
            default:
                System.out.println("Please use a number to make a choice");
        }
    }
}
