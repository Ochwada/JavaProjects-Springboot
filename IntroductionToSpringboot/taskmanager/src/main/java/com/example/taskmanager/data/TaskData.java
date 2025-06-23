package com.example.taskmanager.data;

/**
 * *******************************************************
 * Package: com.example.taskmanager.domain
 * File: TaskData.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 12:13 PM
 * Description:  A simple Data Transfer Object (DTO) used to receive task data in a request.
 * Objective:
 * *******************************************************
 */


public class TaskData {

    /**
     * The description of the task to be added.
     */
    private String description;

    /**
     * Constructs a new TaskData object with the given description.
     *
     * @param description the description of the task
     */
    public TaskData(String description ){
        this.description = description;
    }


    // Getter (and setter if needed)
    public String getDescription() {
        return description;
    }

    // Optional: setter if using @RequestBody without Lombok or records
    public void setDescription(String description) {
        this.description = description;
    }
}
