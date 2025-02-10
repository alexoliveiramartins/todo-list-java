import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TasksData {
    private List<Task> tasks = new ArrayList<Task>();
    private final String filePath = "tasks.csv";

    public TasksData() {
        populateTasks();
    }

    public List<Task> getTasks() {
        return tasks;
    }

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
        }

//        for(String line : lines) { // debug
//            System.out.println(line);
//        }
    }
}
