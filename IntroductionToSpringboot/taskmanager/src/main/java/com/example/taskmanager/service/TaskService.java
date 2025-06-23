package com.example.taskmanager.service;


import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * *******************************************************
 * Package: com.example.taskmanager.service
 * File: TaskService.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 10:44 AM
 * Description: Service class for managing tasks.
 *  * Provides methods to create tasks, retrieve all tasks, and mark tasks as complete.
 * Objective:
 * *******************************************************
 */

@Service
@RequiredArgsConstructor
public class TaskService {

    /**
     * Repository interface for accessing task data from the database.
     */
    private final TaskRepository taskRepo;

    /**
     * Marks a task as completed based on its ID.
     *
     * @param id the ID of the task to be marked as complete
     * @return the updated Task object if found; null otherwise
     */
    public Task markTaskAsComplete(Long id) {

        Task task = taskRepo.findById(id);

        if (task != null) {
            task.setCompleted(true);
            //result  = task;
            return taskRepo.save(task);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with ID " + id + " not found");
    }

    /**
     * Creates a new task with the given description.
     * The task is initialized as incomplete.
     *
     * @param description a short text describing the task
     * @return the newly created Task object
     */
    public Task createTask(String description) {
        Task task = new Task(null, description, false);
        return taskRepo.save(task);
    }

    /**
     * Retrieves all tasks stored in the database.
     *
     * @return a list of all Task objects
     */
    public List<Task> allTasks() {

        return taskRepo.findAll();
    }
}
