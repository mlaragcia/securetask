package com.garlamdev.apps.securetask.domain;

import java.util.UUID;

public class TaskId {
    
    private final UUID uuid;

    public TaskId(){

        this.uuid = UUID.randomUUID();
    }
    public TaskId(UUID uuid){

        if(uuid == null){
            throw new IllegalArgumentException("UUID cannot be null");
        }
        this.uuid = uuid;
    }

    public UUID getValue(){
        return this.uuid;
    }





}
