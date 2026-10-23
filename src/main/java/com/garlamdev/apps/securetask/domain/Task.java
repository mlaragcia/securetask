package com.garlamdev.apps.securetask.domain;

public class Task {

    private String title;
    private TaskStatus status;

    public Task (String title){
        this.title = title;
        this.status = TaskStatus.TODO;
    }

    public String getTitle(){
        return this.title;
    }

    public TaskStatus getStatus(){
        return this.status;
    }


}