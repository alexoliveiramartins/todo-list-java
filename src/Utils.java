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

}
