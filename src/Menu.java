import java.util.List;
import java.util.Scanner;

public class Menu {
    TasksData tasksData = new TasksData();

    public void MainMenu() {
        while(true){
            System.out.println("====Menu====");
            System.out.println("\n1. Show Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Edit Task");
            System.out.println("5. Exit\n");

            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            switch(input){
                case "1": {
                    showTasks();
                }
                case "2":
                case "3":
                case "4":
                case "5":
                default: break;
            }
        }
    }

    public void tasksMenu(){
        System.out.println("====Menu====");
        System.out.println("\n1. Show all tasks");
        System.out.println("2. Show tasks by category");
        System.out.println("3. Show tasks by priority");
        System.out.println("4. Show tasks by status");
        System.out.println("5. Exit\n");

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        switch(input){
            case "1": showTasks();
            case "2":
            case "3":
            case "4":
            case "5":
            default: break;
        }
    }

    public void showTasks() {
        List<Task> tasks = tasksData.getTasks();
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

}
