package view;

import java.util.Scanner;

public class MainMenu {
    private Scanner sc;

    public void welcomeMessage() {
        System.out.println("**** Welcome To Boat Club ****");
    }

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
