import controller.Alarm;
import controller.Menu;

import javax.swing.*;
import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Menu menu = new Menu();
        menu.mainMenu();
    }
}

