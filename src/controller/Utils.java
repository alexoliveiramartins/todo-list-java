package controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Utils {
    private Utils() {

    }

    public static String readInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String readInput(String question){
        System.out.print(question);
        return readInput();
    }

    public static int readIntegerInput(){
        Scanner sc = new Scanner(System.in);
        int number;

        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Enter a valid number");
                System.out.print("> ");
                sc.nextLine();
            }
        }
        return number;
    }

    public static int readIntegerInput(String question){
        System.out.print(question);
        return readIntegerInput();
    }

    public static LocalDateTime stringToDate(String date){
        String [] dataElements = date.split(" ");
        String [] dayMonthYear = dataElements[0].split("/");
        String [] hourMinutes = dataElements[1].split(":");

        int day = Integer.parseInt(dayMonthYear[0]);
        int month = Integer.parseInt(dayMonthYear[1]);
        int year = Integer.parseInt(dayMonthYear[2]);
        int hour = Integer.parseInt(hourMinutes[0]);
        int minutes = Integer.parseInt(hourMinutes[1]);

        return LocalDateTime.of(year, month, day, hour, minutes);
    }

}
