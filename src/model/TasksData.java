package model;

import controller.JsonUtils;

import java.util.*;

public class TasksData {
    private final Set<String> categoriesSet = new HashSet<>();
    private List<Task> tasks = new ArrayList<>();

    public TasksData() {
        populateTasks();
    }

    public void updateTaskList() {
        JsonUtils.writeTasks(tasks);
    }

    private void populateTasks() {
        tasks = JsonUtils.getTasks();
        for (Task t : tasks) {
            categoriesSet.add(t.getCategory());
        }
    }

    public Set<String> getCategoriesSet() {
        return categoriesSet;
    }

    public void addTask(Task task) {
        JsonUtils.addTask(task);
    }

    public void removeTask(String name) {
        JsonUtils.removeTask(name);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getTasksByName() {
        List<Task> tasksByName = tasks;
        tasksByName.sort(Comparator.comparing(Task::getName));
        return tasksByName;
    }
}
