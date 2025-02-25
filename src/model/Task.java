package model;

import java.time.LocalDateTime;

public class Task {

    private String name;
    private String description;
    private LocalDateTime dueDate;
    private int priority;
    private String category;
    private String status;

    public Task() {

    }

    @Override
    public String toString() {
        return "name: '" + name + '\'' +
                ", description: '" + description + '\'' +
                ", dueDate: '" + dueDate + '\'' +
                ", priority: " + priority +
                ", category: '" + category + '\'' +
                ", status: '" + status + '\'';
    }

    public String toCsvString() {
        return name + ","
                + description + ","
                + dueDate + ","
                + priority + ","
                + category + ","
                + status;
    }

    public Task(String name, String description, LocalDateTime dueDate, int priority, String category, String status) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
