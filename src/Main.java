import controller.MainController;
import view.*;

/**
 * Main class
 * @author "insert name"
 */
public class Main {
    public static void main(String[] args) {
        MainView menu = new MainView();
        MainController mainController = new MainController(menu);
        mainController.startMenu();
    }
}
