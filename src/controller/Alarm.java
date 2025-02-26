package controller;

import model.Task;
import model.TasksData;

import javax.swing.*;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

public class Alarm {
    TasksData data;
    LocalDateTime currentDate;

    public Alarm(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    data = new TasksData();
                    currentDate = LocalDateTime.now();
                    taskDueNow(currentDate);
                    Utils.sleepInSeconds(1);
                }
            }
        });
        t1.start();
    }

    public void taskDueNow(LocalDateTime currentDate){
        for(Task task : data.getTasks()){
            if(Utils.datesAreEqual(currentDate, task.getDueDate())){
                JOptionPane.showMessageDialog(null, "Due now: " + task.getName(), "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
