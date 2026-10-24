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

    @Override 
    public boolean equals(Object object){
        if (this == object) {

            return true;
            
        }

        if(!(object instanceof TaskId taskId)){
            return false;
        }

        return this.uuid.equals(taskId.uuid);
    }

    @Override 
    public int hashCode(){
        return this.uuid.hashCode();
    }






}
