package com.example;

import com.example.controller.Alarm;
import com.example.controller.Menu;

public class Application {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Menu menu = new Menu();
        menu.mainMenu();
    }
}

