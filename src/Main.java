import controller.BoatController;
import controller.MainController;
import model.Boat;
import model.Member;
import model.Type;
import persistance.Storage;

import java.io.IOException;
import java.util.ArrayList;

import view.*;


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

        Member patrik = new Member("Patrik", "Hasselblad", 83040700, 0);
        saveMember.addMember(patrik);
        Boat patsBoat = new Boat(Type.KAYAK, 3.0, patrik.getMemberId());
        boatController.createBoat(patrik, patsBoat);

        ArrayList<Boat> boatList = patrik.getBoatList();
        System.out.println("My boats: " );
        for (int i = 0 ; i < boatList.size(); i++) {
            System.out.println(boatList.get(i).getType() + " " + boatList.get(i).getLength());
        }


        Member rutger = new Member("Rutger", "Hauer", 453423, 0);
        saveMember.addMember(rutger);

        System.out.println(saveMember.registrySize());
//        saveMember.deleteMember(patrik.getMemberId());
//        saveMember.deleteMember(rutger.getMemberId());
//        System.out.println(saveMember.registrySize());

        Member temp = saveMember.getMember(patrik.getMemberId());
        System.out.println(temp.getFirstName() + " " + temp.getLastName() + "\n" + temp.getSocialSec() + "\n" + temp.getMemberId());

        saveMember.editMember(patrik.getMemberId());

        Member temp1 = saveMember.getMember(patrik.getMemberId());
        System.out.println(temp1.getFirstName() + " " + temp1.getLastName() + "\n" + temp1.getSocialSec() + "\n" + temp1.getMemberId());
        main.startMenu();

        // Förmodligen bäst att spara strax innan avslut.
        saveMember.saveData();
    }
}
