package com.garlamdev.apps.securetask.domain;

import java.util.UUID;

public class TaskId {
    
    private final UUID uuid;

    public TaskId(){
        this.uuid = UUID.randomUUID();
    }

    public UUID getValue(){
        return this.uuid;
    }





}
