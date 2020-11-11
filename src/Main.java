import controller.MainController;
import view.MainView;

import java.io.IOException;


/**
 * Main class
 * @author "insert name"
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MainView mainView = new MainView();
        MainController main = new MainController();

        main.startMenu();
    }
}