package controller;

import model.Task;
import model.TasksData;
import view.DisplayTasks;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Menu {
    static TasksData tasksData = new TasksData();
    DisplayTasks displayTasks = new DisplayTasks(tasksData);

    public void mainMenu() {
        while (true) {
            System.out.println("\n====Menu====");
            System.out.println("\n1. Show Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Edit Task");
            System.out.println("5. Exit\n");
            System.out.print("> ");

            int input = Utils.readIntegerInput();
            switch (input) {
                case 1: {
                    tasksMenu();
                    break;
                }
                case 2: {
                    tasksData.addTask(newTaskMenu());
                    break;
                }
                case 3: {
                    String taskToRemove = tasksData.getTasksByName().get(taskSelection() - 1).getName();
                    System.out.println(taskToRemove + " removed.");
                    tasksData.removeTask(taskToRemove);
                    break;
                }
                case 4: {
                    editTaskMenu();
                    break;
                }
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void editTaskMenu() {
        int selection = taskSelection();
        Task selectedTask = tasksData.getTasksByName().get(selection - 1);

        System.out.println("\nSelect property to change: ");
        System.out.println("[1] Name");
        System.out.println("[2] Description");
        System.out.println("[3] Due Date");
        System.out.println("[4] Priority");
        System.out.println("[5] Category");
        System.out.println("[6] Status");
        System.out.println("[7] Alarms ");
        System.out.println("[8] Cancel");
        System.out.print("> ");
        int input = Utils.readIntegerInput();

        switch (input) {
            case 1: {
                String change = Utils.readInput("Enter new name: ");
                selectedTask.setName(change);
                break;
            }
            case 2: {
                String change = Utils.readInput("Enter new description: ");
                selectedTask.setDescription(change);
                break;
            }
            case 3: {
                LocalDateTime change = Utils.stringToDate(Utils.readInput("Enter new due date (DD/MM/YYYY 00:00): "));
                selectedTask.setDueDate(change);
                break;
            }
            case 4: {
                int change = Utils.readIntegerInput("Enter new priority: ");
                selectedTask.setPriority(change);
                break;
            }
            case 5: {
                String change = Utils.readInput("Enter new category: ");
                selectedTask.setCategory(change);
                break;
            }
            case 6: {
                String change = Utils.readInput("Enter new status: ");
                selectedTask.setStatus(change);
                break;
            }
            case 7: {
                alarmMenu(selectedTask);
                break;
            }
            case 8: {
                return;
            }
        }
        tasksData.updateTaskList();
    }

    public void alarmMenu(Task selectedTask) {
        System.out.println("Select an option: \n");
        System.out.println("[1] Novo Alarme");
        System.out.println("[2] Remover Alarme\n");
        System.out.print("> ");

        int input = Utils.readIntegerInput();

        switch (input) {
            case 1:
                LocalDateTime newAlarm = Utils.stringToDate(Utils.readInput("Enter new alarm time (DD/MM/YYYY 00:00): "));
                selectedTask.getAlarms().add(newAlarm);
                break;
            case 2:
                LocalDateTime remove = alarmSelection(selectedTask);
                selectedTask.getAlarms().remove(remove);
                break;
            default:
        }
    }

    public Task newTaskMenu() {
        String name = Utils.readInput("Enter task name: ");
        String description = Utils.readInput("Enter task description: ");
        LocalDateTime dueDate = Utils.stringToDate(Utils.readInput("Enter task due date (DD/MM/YYYY 00:00): "));
        int priority = Utils.readIntegerInput("Enter task priority: ");
        String category = Utils.readInput("Enter task category: ");
        String status = "todo";
        Set<LocalDateTime> alarms = new HashSet<>();

        System.out.println(name + " added.");
        return new Task(name, description, dueDate, priority, category, status, alarms);
    }

    public LocalDateTime alarmSelection(Task task) {
        int input;
        displayTasks.displayTaskAlarms(task);
        System.out.println("\nSelect an alarm: ");
        System.out.print("> ");
        input = Utils.readIntegerInput() - 1;
        int it = 0;
        for (LocalDateTime data : task.getAlarms()) {
            if (it == input) return data;
            it++;
        }
        return null;
    }

    public int taskSelection() {
        int input;
        displayTasks.showTasksByName();
        System.out.println("\nSelect a task: ");
        System.out.print("> ");
        input = Utils.readIntegerInput();
        return input;
    }

    public void tasksMenu() {
        while (true) {
            System.out.println("\n====Menu====");
            System.out.println("\n1. Show tasks by name");
            System.out.println("2. Show tasks by priority");
            System.out.println("3. Show tasks by status");
            System.out.println("4. Show tasks by category");
            System.out.println("5. Back\n");
            System.out.print("> ");

            String input = Utils.readInput();

            switch (input) {
                case "1":
                    displayTasks.showTasksByName();
                    break;
                case "2":
                    displayTasks.showTasksByPriority();
                    break;
                case "3":
                    displayTasks.showTasksByStatus();
                    break;
                case "4":
                    displayTasks.showTasksByCategory();
                    break;
                case "5":
                    return;
                default:
                    break;
            }
        }
    }

}
