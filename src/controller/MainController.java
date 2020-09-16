package controller;

import persistance.Storage;
import view.MainView;
import view.MemberView;

import java.util.Scanner;

/**
 * A class that handles the main controller
 * @author dd222gc (Dennis Demir)
 */
public class MainController {
    private MainView mainView;
    //private MemberController memberController;
    private BoatController boatController;
    private Storage storage;
    private MemberView memView;
    private Scanner sc = new Scanner(System.in);;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        //this.memberController = new MemberController();
        //this.boatController = new BoatController();
    }

    public MainController() {}

    /**
     * Start Application method
     * @author dd222gc (Dennis Demir)
     */
    public void startMenu() {
        mainView.displayWelcomeMessage();
        int input;
       do {
           input = sc.nextInt();

           if (input == 0) {
               break;
           }

           switch (input) {
               case 1:
                   break;
               case 2:
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
                   mainView.displayBoatInfo();
                   break;
               case 0:
                   break;
               default:
                   System.out.println("Please use a number to make a choice");
           }
       } while (input != 0);
    }

    public void createNewMember() {
//        Member member = new Member();

        memView.displayMemberName();
        String memName = sc.nextLine();

        memView.displayMemberPersonalNumber();
        int personalNum = sc.nextInt();

//        member.setFirstName(memName);
//        member.setSocialSec(personalNum);

    }
}
