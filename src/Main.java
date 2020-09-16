import controller.BoatController;
import controller.MainController;
import model.Boat;
import model.Member;
import model.Type;
import persistance.Storage;
import view.MainView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class
 * @author "insert name"
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Storage saveMember = new Storage();
        BoatController boatController = new BoatController();
        MainView mainView = new MainView();
        MainController main = new MainController(mainView);
        System.out.println(saveMember.registrySize());

        // Testing to add members and boats
        Member patrik = new Member("Rakel", "Spektakel", 123456);


        saveMember.addMember(patrik);
        Boat patsBoat = new Boat(Type.KAYAK, 3.0, patrik.getMemberId());
        Boat patsSecondBoat = new Boat(Type.MOTORSAILER, 4.3, patrik.getMemberId());
        boatController.createBoat(patrik, patsBoat);
        boatController.createBoat(patrik, patsSecondBoat);

        Member test = new Member("Patrik", "Hasselblad", 83040700);


        // Fetching a members boat list
        ArrayList<Boat> boatList = patrik.getBoatList();
        System.out.println("My boats: " );
        for (int i = 0 ; i < boatList.size(); i++) {
            System.out.println(boatList.get(i).getType() + " " + boatList.get(i).getLength());
        }
        System.out.println();

        // Adding another member
        Member rutger = new Member("Rutger", "Hauer", 453423);
        saveMember.addMember(rutger);

        System.out.println("Registry size: " + saveMember.registrySize());
        System.out.println();

        // Printing out member list
        Member temp = saveMember.getMember(patrik.getMemberId());
        System.out.println(temp.getFirstName() + " " + temp.getLastName() + "\n" + temp.getSocialSec() + "\n" + temp.getMemberId());
        System.out.println();

        // Edits a member (Early stage since everything is hardcoded atm)
        saveMember.editMember(patrik.getMemberId());

        Member temp1 = saveMember.getMember(patrik.getMemberId());
        System.out.println(temp1.getFirstName() + " " + temp1.getLastName() + "\n" + temp1.getSocialSec() + "\n" + temp1.getMemberId());
        main.startMenu();

        // Förmodligen bäst att spara strax innan avslut.
        saveMember.saveData();
    }
}
