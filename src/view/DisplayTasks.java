package view;

import java.util.*;
import model.*;


public class DisplayTasks {

    TasksData tasksData;

    public DisplayTasks(TasksData tasksData) {
        this.tasksData = tasksData;
    }

    private int getStatusOrder(String status) {
        if(status.equals("todo")) return 1;
        else if(status.equals("doing")) return 2;
        else if(status.equals("done")) return 3;
        else return -1;
    }

    public void showTasksByName(){
        List<Task> tasks = tasksData.getTasks();
        tasks.sort(Comparator.comparing(Task::getName));
        int k = 1;
        for(Task task : tasks){
            System.out.println("[" + k + "] " + task.toString());
            k++;
        }
    }


    public void showTasksByPriority(){
        List<Task> tasks = tasksData.getTasks();
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

    public void showTasksByStatus(){
        List<Task> tasks = tasksData.getTasks();
        tasks.sort(Comparator.comparing(task -> getStatusOrder(task.getStatus())));
        for(Task task : tasks){
            System.out.println(task.toString());
        }
    }

    public void showTasksByCategory(){
        Set<String> categories = tasksData.getCategoriesMap();
        List<Task> allTasks = tasksData.getTasks();

        for(String category : categories){
            System.out.println("==== " + category + " ====");
            for(Task task : allTasks){
                if(task.getCategory().equals(category)){
                    System.out.println(task.toString());
                }
            }
        }

    }
}
