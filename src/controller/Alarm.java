package controller;

import model.Task;
import model.TasksData;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Alarm {
    TasksData data = Menu.tasksData;
    LocalDateTime currentDate;

    public Alarm() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (data != null) {
                    currentDate = LocalDateTime.now();
                    taskDueNow(currentDate);
                    Utils.sleepInSeconds(1);
                }
            }
        });
        t1.start();
    }

    public void taskDueNow(LocalDateTime currentDate) {
        for (Task task : data.getTasks()) {
            if (Utils.datesAreEqual(currentDate, task.getDueDate())) {
                JOptionPane.showMessageDialog(null, "Due now: " + task.getName(), "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            if (task.getAlarms().contains(currentDate.truncatedTo(ChronoUnit.SECONDS)))
                JOptionPane.showMessageDialog(null, "Alarm for: " + task.getName(), "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
