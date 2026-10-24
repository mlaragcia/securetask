package com.garlamdev.apps.securetask.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TaskIdTest {
    
    @Test 
    void shouldGenerateId(){

        TaskId taskId = new TaskId();
        assertNotNull(taskId.getValue());

    }

    @Test 
    void shouldGenerateUniqueIds(){
        TaskId first = new TaskId();
        TaskId second = new TaskId();


        assertNotEquals(first.getValue(), second.getValue());
    }

    @Test 
    void shouldRejectNullUuid(){
        assertThrows(IllegalArgumentException.class,
            () -> new TaskId(null));
    }
}
