package com.garlamdev.apps.securetask.domain;

public class Task {

    private String title;
    private TaskStatus status;
    private TaskPriority priority;

    public Task (String title){

        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
        this.status = TaskStatus.TODO;
        this.priority = TaskPriority.MEDIUM;

         
    }

    public String getTitle(){
        return this.title;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public TaskPriority getPriority(){
        return this.priority;
    }



    public void start(){
        if(this.status != TaskStatus.TODO){
            throw new IllegalStateException("Task can only be started from TODO");
        }

        this.status = TaskStatus.IN_PROGRESS;
    }

    public void complete(){
        if(this.status != TaskStatus.IN_PROGRESS){
            throw new IllegalStateException("Task can only be completed from IN_PROGRESS");

        }
        this.status = TaskStatus.DONE;
    }


    public void changePriority(TaskPriority priority){
        if(priority == null){
            throw new IllegalArgumentException("Priority cannot be null");
        }
        this.priority = priority;
    }


}