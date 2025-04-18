package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Taskmanager taskmanager = new Taskmanager("tasks.txt");

    public static void main(String[] args) {


        while(true){
            int choice = mainMenu();

            boolean shouldExitProgram = handleChoice(choice);
            if (shouldExitProgram) break;

        }
    }

    private static boolean handleChoice(int choice) {
        if(choice == 0) {

System.out.println("Exiting...");
            return true;
}
else if(choice == 1){
taskmanager.showTasks();
}
else if(choice == 2) {
System.out.println("Enter task name");
String taskName = scanner.nextLine();
taskmanager.AddTask(taskName);
}
else if(choice == 3) {
System.out.println("Enter Prioritized task");
String prioritizedTask = scanner.nextLine();
System.out.println("Enter priority 1-5 (5 being urgent!");
int priorityNumber = scanner.nextInt();
taskmanager.addTask(prioritizedTask, priorityNumber);
}
else if(choice == 4) {
System.out.println("Enter name of task to complete");
String completedTask = scanner.nextLine();
taskmanager.taskCompleted(completedTask);
}
else {
System.out.println("invalid choice...");
}
        return false;
    }

    private static int mainMenu() {
        System.out.println("\nMain menu");
        System.out.println("0. Exit");
        System.out.println("1. Show Tasks");
        System.out.println("2. Add regular Task");
        System.out.println("3. Add prioritized Task");
        System.out.println("4. Mark specific Task as completed");
        System.out.println("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}