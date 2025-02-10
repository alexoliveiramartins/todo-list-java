import java.util.Date;

public class Task {

    private String name;
    private String description;
    private String dueDate;
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

    public Task(String name, String description, String dueDate, int priority, String category, String status) {
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
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
