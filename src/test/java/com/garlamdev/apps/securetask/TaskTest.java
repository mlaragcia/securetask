package com.garlamdev.apps.securetask.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TaskTest{


    @Test
    public void shouldTaskReceive(){
        Task task = new Task("Learn Maven");

        assertEquals("Learn Maven",task.getTitle());
    }

    @Test
    public void shouldStarWithTodoStatus(){
        Task task = new Task("Learn Maven");
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

}