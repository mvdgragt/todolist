package org.example.tasks;

public class PriorityTask extends Task {
    private int priority;

    public PriorityTask(String name, int priority) {
        super(name);
        this.priority = priority;
    }

    public int getPriority (){
        return priority;
    }

    @Override
    public String taskInfo() {
        String priorityText = " (Priority: " + priority + ")";
        return "PriorityTask: " + name + priorityText;
    }
}
