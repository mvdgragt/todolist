package org.example.tasks;

public class RegularTask extends Task{

    public RegularTask(String name) {
        super(name);
    }

    @Override
    public String taskInfo() {
        return name;
    }


}
