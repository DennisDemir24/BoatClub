import controller.MainController;
import view.MainView;

import java.io.IOException;


/**
 * Main class
 * @author "insert name"
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MainController main = new MainController();

        main.startMenu();
    }
}