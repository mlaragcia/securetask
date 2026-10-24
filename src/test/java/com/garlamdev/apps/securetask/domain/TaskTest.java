package com.garlamdev.apps.securetask.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class TaskTest{


    @Test
    void shouldTaskReceive(){
        Task task = new Task("Learn Maven");

        assertEquals("Learn Maven",task.getTitle());
    }

    @Test
    void shouldStartWithTodoStatus(){
        Task task = new Task("Learn Maven");
        assertEquals(TaskStatus.TODO, task.getStatus());
    }


    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void shouldRejectInvalidTitle(String title){
        assertThrows(
            IllegalArgumentException.class,
            () -> new Task(title)
        );
    }

    @Test
    void shouldStartTask(){
        Task task = new Task("Learn Maven");

        task.start();

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test 
    void shouldNoStartTaskAlreadyInProgress(){

        Task task = new Task("Learn Maven");

        task.start();
        assertThrows(IllegalStateException.class, 
            () -> task.start()
        );
    }

    @Test 
    void shouldCompleteTask(){

        Task task = new Task("Learn Maven");

        task.start();
        task.complete();

        assertEquals(TaskStatus.DONE, task.getStatus());
    }

    @Test 
    void shouldNotCompleteTaskFromTodo(){
        Task task = new Task("Learn Maven");

        assertThrows(IllegalStateException.class,
            () -> task.complete()
        );
    }

    @Test 
    void shouldNotCompleteTaskAlreadyDone(){
        Task task = new Task("Learn Maven");

        task.start();
        task.complete();

        assertThrows(IllegalStateException.class,
            () -> task.complete());
    }

    @Test 
    void shouldNotStartCompletedTask(){
        Task task = new Task("Learn Maven");

        task.start();
        task.complete();

        assertThrows(IllegalStateException.class,
            () -> task.start()
        );
    }

    @Test 
    void shouldStartWithMediumPriority(){
        Task task = new Task("Learn Maven");

        assertEquals(TaskPriority.MEDIUM, task.getPriority());
    }

    @Test 
    void shouldChangePriority(){
        Task task = new Task("Learn Maven");

        task.changePriority(TaskPriority.HIGH);

        assertEquals(TaskPriority.HIGH, task.getPriority());
    }

    @Test 
    void shouldRejectNullPriority(){
        Task task = new Task("Learn Maven");

        assertThrows(IllegalArgumentException.class,
            () -> task.changePriority(null));
    }

    @Test 
    void shouldGenerateIdWhenTaskIsCreated(){
        Task task = new Task("Learn Maven");

        assertNotNull(task.getTaskId());
    }

    @Test 
    void shouldGenerateDifferentIdsForDifferentTasks(){
        Task first = new Task("Learn Maven");
        Task second = new Task("Learn Java");

        assertNotEquals(first.getTaskId().getValue(), second.getTaskId().getValue());
    }
}