package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Task;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static void writeTasks(List<Task> tasks) {
        TaskListWrapper wrapper = new TaskListWrapper();
        wrapper.setTasks(tasks);
        try {
            objectMapper.writeValue(new File("backend/src/tasks.json"), wrapper);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Task> getTasks() {
        try {
            TaskListWrapper wrapper = objectMapper.readValue(
                    new File("backend/src/tasks.json"), TaskListWrapper.class
            );
            return wrapper.getTasks();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeTask(String name) {
        try {
            TaskListWrapper wrapper = objectMapper.readValue(
                    new File("backend/src/tasks.json"), TaskListWrapper.class
            );
            wrapper.getTasks().removeIf(task -> task.getName().equals(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addTask(Task task) {
        try {
            List<Task> tasks = getTasks();
            tasks.add(task);
            TaskListWrapper wrapper = new TaskListWrapper();
            wrapper.setTasks(tasks);
            objectMapper.writeValue(new File("backend/src/tasks.json"), wrapper);
        } catch (IOException e) {
            throw new RuntimeException("Failed to add task", e);
        }
    }

    private static class TaskListWrapper {
        private List<Task> tasks;

        public List<Task> getTasks() {
            return tasks;
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }
    }

}
