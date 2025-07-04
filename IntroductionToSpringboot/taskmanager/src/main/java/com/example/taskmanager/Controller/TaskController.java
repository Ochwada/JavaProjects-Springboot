package com.example.taskmanager.Controller;


import com.example.taskmanager.domain.Task;
import com.example.taskmanager.data.TaskData;
import com.example.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;


/**
 * *******************************************************
 * Package: com.example.taskmanager.Controller
 * File: TaskController.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 12:02 PM
 * Description:
 * Objective:
 * *******************************************************
 */

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    /**
     * Retrieves a list of all tasks.
     *
     * @return a list of {@link Task} objects
     */
    @GetMapping
    public List<Task> listTasks(){
        return taskService.allTasks();

    }

    /**
     * Creates a new task based on the provided description.
     *
     * @param dto the task data containing the description
     * @return the newly created {@link Task}
     */
    @PostMapping("/createTasks")
    public  Task addTask(@RequestBody TaskData dto){
        return taskService.createTask(dto.getDescription());
    }


    /**
     * Marks an existing task as completed.
     *
     * @param id the ID of the task to mark as complete
     * @return the updated {@link Task} object
     */
    @PostMapping("/{id}/done")
    public Task markTaskAsComplete(@PathVariable Long id){
        return  taskService.markTaskAsComplete(id);
    }


}
