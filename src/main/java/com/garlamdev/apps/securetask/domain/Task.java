package com.garlamdev.apps.securetask.domain;

public class Task {

    private String title;
    private TaskStatus status;

    public Task (String title){

        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
        this.status = TaskStatus.TODO;

         
    }

    public String getTitle(){
        return this.title;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public void start(){
        this.status = TaskStatus.IN_PROGRESS;
    }


}