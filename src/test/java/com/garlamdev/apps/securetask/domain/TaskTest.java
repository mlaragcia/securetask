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

    @Test 
    public void shouldNoStartTaskAlreadyInProgress(){

        Task task = new Task("Learn Maven");

        task.start();
        assertThrows(IllegalStateException.class, 
            () -> task.start()
        );
    }

    @Test 
    public void shouldCompleteTask(){

        Task task = new Task("Learn Maven");

        task.start();
        task.complete();

        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test 
    public void shouldNotCompleteTaskFromTodo(){
        Task task = new Task("Learn Maven");

        assertThrows(IllegalStateException.class,
            () -> task.complete()
        );
    }

    @Test 
    public void shouldNotCompleteTaskAlreadyDone(){
        Task task = new Task("Learn Maven");

        task.start();
        task.complete();

        assertThrows(IllegalStateException.class,
            () -> task.complete());
    }

    @Test 
    public void shouldNotStartCompletedTask(){
        Task task = new Task("Learn Maven");

        task.start();
        task.complete();

        assertThrows(IllegalStateException.class,
            () -> task.start()
        );
    }

    @Test 
    public void shouldStartWithMediumPriority(){
        Task task = new Task("Learn Maven");

        assertEquals(TaskPriority.MEDIUM, task.getPriority());
    }

    @Test 
    public void shouldChangePriority(){
        Task task = new Task("Learn Maven");

        task.changePriority(TaskPriority.HIGH);

        assertEquals(TaskPriority.HIGH, task.getPriority());
    }
}