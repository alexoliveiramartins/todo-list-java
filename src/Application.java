import controller.Alarm;
import controller.Menu;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Application {

    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Menu menu = new Menu();
        menu.mainMenu();
    }
}

