import controller.Alarm;
import controller.Menu;

public class Application {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Menu menu = new Menu();
        menu.mainMenu();
    }
}

