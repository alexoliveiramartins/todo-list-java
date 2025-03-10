package view;

import model.Task;
import model.TasksData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class DisplayTasks {

    TasksData tasksData;

    public DisplayTasks(TasksData tasksData) {
        this.tasksData = tasksData;
    }

    public void displayTaskAlarms(Task task) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy HH:mm a");
        int it = 1;
        for (LocalDateTime alarm : task.getAlarms()) {
            System.out.println("[" + it + "] " + alarm.format(formatter));
            it++;
        }
    }

    private int getStatusOrder(String status) {
        switch (status) {
            case "todo":
                return 1;
            case "doing":
                return 2;
            case "done":
                return 3;
            default:
                return -1;
        }
    }

    public void showTasksByName() {
        List<Task> tasks = tasksData.getTasks();
        tasks.sort(Comparator.comparing(Task::getName));
        int k = 1;
        for (Task task : tasks) {
            System.out.println("[" + k + "] " + task.toString());
            k++;
        }
    }

    public void showTasksByPriority() {
        List<Task> tasks = tasksData.getTasks();
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    public void showTasksByStatus() {
        List<Task> tasks = tasksData.getTasks();
        tasks.sort(Comparator.comparing(task -> getStatusOrder(task.getStatus())));
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }

    public void showTasksByCategory() {
        Set<String> categories = tasksData.getCategoriesSet();
        List<Task> allTasks = tasksData.getTasks();

        for (String category : categories) {
            System.out.println("==== " + category + " ====");
            for (Task task : allTasks) {
                if (task.getCategory().equals(category)) {
                    System.out.println(task);
                }
            }
        }

    }
}
