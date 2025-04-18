package org.example;
import org.example.tasks.PriorityTask;
import org.example.tasks.RegularTask;
import org.example.tasks.Task;

import java.io.*;
import java.util.ArrayList;

public class Taskmanager {
    private ArrayList<Task> tasks;
    private final String fileName;

    public Taskmanager(String fileName) {
        tasks = new ArrayList<>();
        this.fileName = fileName;

        loadTasksFromFile();
    }

    public void AddTask(String name){
       Task task = new RegularTask(name);
       tasks.add(task);
        System.out.println("Regular task added: " + task);
        saveTasksToFile();
    }

    public void addTask(String name, int priority) {
        Task task = new PriorityTask(name, priority);
        tasks.add(task);
        System.out.println("Prioritized task added: " + task);
        saveTasksToFile();
    }

    public void showTasks() {
        if(tasks.isEmpty()) {
            System.out.println("no tasks listed");
            return;
        }
//            System.out.println("task");
        for(Task task : tasks) {
            System.out.println(task);
        }
        }
        public void taskCompleted(String name){
            for(Task task : tasks) {
                if(task.getName().equalsIgnoreCase(name)){
                    task.markAsCompleted();
                    System.out.println("Task: '" + task.getName() + "' is completed");
                    saveTasksToFile();
                    return;
                }
            }
            System.out.println("Task not found: " + name);
        }

        private void saveTasksToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
        for(Task task : tasks) {
            String taskTypeString = (task instanceof RegularTask ? "REG - " : "PRIO - ");
            bw.write(taskTypeString);
            bw.write(task.getName() + " - ");
            if(task instanceof PriorityTask) {
                int priority = ((PriorityTask) task).getPriority();
                bw.write(priority + " - ");
            }

            String isCompletedString = (task.getIsCompleted() ? "Completed" : "Incompleted");
            bw.write(isCompletedString);
            bw.newLine();
        }
            System.out.println("Tasks save to file.");

        } catch (IOException e) {
            System.out.println("error writing file: " + e.getMessage());
        }
        }
        private void loadTasksFromFile(){

        File file = new File(fileName);
            if (!file.exists()) {

                System.out.println("No file was found.");
                return;
            }
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
                String line;
                while((line = br.readLine()) !=null) {
                    String[] parts = line.split(" - ");
                    String taskType = parts[0];
                    String taskName = parts[1];

                    Task task;
                    if(taskType.equals("REG")){
                        task = new RegularTask(taskName);
                    }
                    else {
                        int priority = Integer.parseInt(parts[2]);
                        task = new PriorityTask(taskName, priority);
                    }

                    String completedString = parts[parts.length-1];
                    if(completedString.equals("Completed")){
                        task.markAsCompleted();
                    }
                    tasks.add(task);
                }

            }catch(IOException e)
            {
                System.out.println("Error reading file: " + e.getMessage());
            }

            }


        }

