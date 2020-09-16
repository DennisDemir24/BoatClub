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
        System.out.println(saveMember.registrySize());

        Member patrik = new Member("Patrik", "Hasselblad", 83040700, 0);
        saveMember.addMember(patrik);

        Member rutger = new Member("Rutger", "Hauer", 453423, 0);
        saveMember.addMember(rutger);

        System.out.println(saveMember.registrySize());
        saveMember.deleteMember(patrik.getMemberId());
        saveMember.deleteMember(rutger.getMemberId());
        System.out.println(saveMember.registrySize());

        // Förmodligen bäst att spara strax innan avslut.
        saveMember.saveData();
    }
}
