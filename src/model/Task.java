package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Set;

public class Task {

    private String name;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;
    private int priority;
    private String category;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private Set<LocalDateTime> alarms;

    public Task() {
    }

    public Task(String name, String description, LocalDateTime dueDate, int priority, String category, String status, Set<LocalDateTime> alarms) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.status = status;
        this.alarms = alarms;
    }

    @Override
    public String toString() {
        return "name:'" + name + '\'' +
                ", description:'" + description + '\'' +
                ", dueDate:" + dueDate +
                ", priority:" + priority +
                ", category:'" + category + '\'' +
                ", status:'" + status + '\'' +
                ", alarms:" + alarms +
                '}';
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

    public Set<LocalDateTime> getAlarms() {
        return alarms;
    }

    public void setAlarms(Set<LocalDateTime> alarms) {
        this.alarms = alarms;
    }

}
