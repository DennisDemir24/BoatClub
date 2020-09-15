package controller;

import persistance.Storage;
import view.MainView;

public class MainController {
    private MainView mainView;
    //private MemberController memberController;
    //private BoatController boatController;
    private Storage storage;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        //this.memberController = new MemberController();
        //this.boatController = new BoatController();
    }

    public void startMenu() {
        System.out.println("Start App");
    }
}
