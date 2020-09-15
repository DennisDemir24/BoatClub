import model.Member;
import persistance.Storage;
import view.MainMenu;

import java.io.IOException;

/**
 * Main class
 * @author "insert name"
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MainMenu menu = new MainMenu();
        menu.welcomeMessage();

        Storage saveMember = new Storage();

        Member patrik = new Member("Patrik", "Hasselblad", 83040700);
        saveMember.addMember(patrik);

        Member rutger = new Member("Rutger", "Hauer", 453423);
        saveMember.addMember(rutger);

//        saveMember.editMember(patrik.getMemberId(), patrik);



        // Förmodligen bäst att spara strax innan avslut.
        saveMember.loadData();
    }
}
