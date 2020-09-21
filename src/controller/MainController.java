package controller;

import persistance.Storage;
import view.MainView;
import view.MemberView;

import java.io.IOException;
import java.util.Scanner;

/**
 * A class that handles the main controller
 * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
 */
public class MainController {
    private MainView mainView;
    private MemberController memberController;
    private BoatController boatController;
    private Storage storage;
    private MemberView memView;
    private Scanner sc;

    public MainController() throws IOException {
        this.mainView = new MainView();
        this.memView = new MemberView();
        this.memberController = new MemberController();
        this.storage = new Storage();
        // this.boatController = new BoatController();
    }


    /**
     * Start Application method
     * @author dd222gc (Dennis Demir)
     */
    public void startMenu() {
        sc = new Scanner(System.in);

        int input;
        do {
            mainView.displayWelcomeMessage();
            input = sc.nextInt();

            if (input == 0) {
                sc.close();
                break;
            }

            switch (input) {
                case 1:
                    compactList();
                    break;
                case 2:
                    verboseList();
                    break;
                case 3:
                    createNewMember();
                    break;
                case 4:
                    sc.close();
                    break;
                case 5:
                    sc.close();
                    break;
                case 6:
                    sc.close();
                    break;
                case 7:
                    sc.close();
                    break;
                case 8:
                    sc.close();
                    break;
                case 9:
                    sc.close();
                    break;
                case 10:
                    mainView.displayBoatInfo();
                    break;
                default:
                    System.out.println("Please use a number to make a choice");
            }
        } while (true);
    }

    /**
     * Method for getting member and using viewCompact to print info
     * @author dd222gc (Dennis Demir)
     */
    private void compactList() {
        int members = this.storage.registrySize();

        for (int i = 0; i < members; i++) {
            this.memberController.viewCompact(i);
        }
    }

    /**
     * Method for getting member and using viewVerbose to print info
     * @author dd222gc (Dennis Demir)
     */
    private void verboseList() {
        memView.displayVerboseList();
    }

    /**
     * Method for creating a member
     * @author dd222gc (Dennis Demir) & nh222mr (Nicklas Hansson)
     */
    public void createNewMember() {

//        Member member = new Member();

        sc = new Scanner(System.in);


        memView.displayMemberFirstName();
        String memFirstName = sc.nextLine();

        memView.displayMemberLastName();
        String memLastName = sc.nextLine();

        memView.displayMemberPersonalNumber();
        int personalNum = sc.nextInt();


//        member.setFirstName(memName);
//        member.setSocialSec(personalNum);

        memberController.create(memFirstName, memLastName, personalNum);

        storage.saveData();


    }
}