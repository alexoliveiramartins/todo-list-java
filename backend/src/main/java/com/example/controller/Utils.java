package com.example.controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Utils {

    public static Scanner sc = new Scanner(System.in);

    private Utils() { }

    public static String readInput() {
        return sc.nextLine();
    }

    public static String readInput(String question) {
        System.out.print(question);
        return readInput();
    }

    public static int readIntegerInput() {
            return Integer.parseInt(sc.nextLine());
    }
    public static int readIntegerInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    public static LocalDateTime stringToDate(String date) {
        String[] dataElements = date.split(" ");
        String[] dayMonthYear = dataElements[0].split("/");
        String[] hourMinutes = dataElements[1].split(":");

        int day = Integer.parseInt(dayMonthYear[0]);
        int month = Integer.parseInt(dayMonthYear[1]);
        int year = Integer.parseInt(dayMonthYear[2]);
        int hour = Integer.parseInt(hourMinutes[0]);
        int minutes = Integer.parseInt(hourMinutes[1]);

        return LocalDateTime.of(year, month, day, hour, minutes);
    }

    public static void sleepInSeconds(int seconds) {
        try {
            sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean datesAreEqual(LocalDateTime date1, LocalDateTime date2) {
        return (date1.getHour() == date2.getHour())
                && (date1.getMinute() == date2.getMinute())
                && (date1.getSecond() == date2.getSecond())
                && (date1.getDayOfMonth() == date2.getDayOfMonth())
                && (date1.getYear() == date2.getYear());
    }
}
