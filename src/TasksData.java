import java.io.*;
import java.util.*;

public class TasksData {
    private List<Task> tasks = new ArrayList<Task>();
    private final String filePath = "tasks.csv";
    private Set<String> categoriesMap = new HashSet<>();

    public TasksData() {
        populateTasks();
    }

    public void updateTaskList() {
        categoriesMap = new HashSet<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name,Description,Due Date,Priority,Category,Status\n");
            for (Task task : tasks) {
                categoriesMap.add(task.getCategory());
                writer.write(task.toCsvString());
                writer.newLine();
            }
            System.out.println("Task list updated.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

//        System.out.println("Debug: ");
//        for (Task task : tasks) {
//            System.out.println(task.toCsvString());
//        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public List<Task> getTasksByName(){
        List<Task> tasksByName = tasks;
        tasksByName.sort(Comparator.comparing(Task::getName));
        return tasksByName;
    }
    public Set<String> getCategoriesMap() { return categoriesMap; }

    public void populateTasks() {
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while(br.ready()) {
                lines.add(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // remover os headers
        lines.remove(0);

        for(String line : lines) {
            String[] categories = line.split(",");
            String name = categories[0];
            String description = categories[1];
            String dueDate = categories[2];
            int priority = Integer.parseInt(categories[3]);
            String category = categories[4];
            String status = categories[5];

            Task task = new Task(name, description, dueDate, priority, category, status);
            tasks.add(task);
            categoriesMap.add(task.getCategory());
        }
//        for(String line : lines) { // debug
//            System.out.println(line);
//        }
    }

    public void removeTask(String name) {
        Task taskToRemove = new Task();
        for(Task task : tasks) {
            if(task.getName().equals(name)) {
                taskToRemove = task;
                break;
            }
        }
        tasks.remove(taskToRemove);
        updateTaskList();
    }

    public void addTask(Task task) {
        tasks.add(task);
        updateTaskList();
    }
}
