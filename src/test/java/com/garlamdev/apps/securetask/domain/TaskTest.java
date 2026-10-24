package com.garlamdev.apps.securetask.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class TaskTest{


    @Test
    public void shouldTaskReceive(){
        Task task = new Task("Learn Maven");

        assertEquals("Learn Maven",task.getTitle());
    }

    @Test
    public void shouldStartWithTodoStatus(){
        Task task = new Task("Learn Maven");
        assertEquals(TaskStatus.TODO, task.getStatus());
    }


    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    public void shouldRejectInvalidTitle(String title){
        assertThrows(
            IllegalArgumentException.class,
            () -> new Task(title)
        );
    }

    @Test
    public void shouldStartTask(){
        Task task = new Task("Learn Maven");

        task.start();

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }
}