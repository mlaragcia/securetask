package com.garlamdev.apps.securetask.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



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

    @Test
    public void shouldRejectNullTitle(){
       
        assertThrows(
            IllegalArgumentException.class,
            () -> new Task(null)
        );
    }

    @Test
    public void shouldRejectEmptyTitle(){
        assertThrows(
            IllegalArgumentException.class,
            () -> new Task("")
        );
    }

    @Test
    public void shouldRejectBlankTitle(){
        assertThrows(
            IllegalArgumentException.class,
            () -> new Task(" ")
        );
    }

}