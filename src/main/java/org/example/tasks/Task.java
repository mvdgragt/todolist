package org.example.tasks;

public abstract class Task {

    protected String name;
    protected boolean completed;

    public Task(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    };

    public boolean getIsCompleted() {
        return completed;
    }

    public void markAsCompleted(){
        completed = true;
    }

    // Virtual method to override in subclasses
    public abstract String taskInfo();

    @Override
    public String toString() {
        String completedString = (completed? "complete" : "incomplete");
        return taskInfo() + "-" + completedString;

    }
}
