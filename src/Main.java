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

        Member patrik = new Member("Patrik", "Hasselblad", 83040700);
        Storage saveMember = new Storage();

        saveMember.saveData(patrik);

        Member rutger = new Member("Rutger", "Hauer", 453423);
        saveMember.saveData(rutger);

        saveMember.loadData();
    }
}
