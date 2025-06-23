package com.example.taskmanager.domain;


import com.example.taskmanager.database.TaskJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * *******************************************************
 * Package: com.example.taskmanager.domain
 * File: TaskRepository.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 10:43 AM
 * Description: Repository interface for Task entities.
 * Objective:
 * *******************************************************
 */

/**
 * Extends {@link JpaRepository} to provide CRUD operations and query method support for Task objects.
 * <p>
 * No method definitions are required as JpaRepository already provides:
 * <ul>
 *     <li>{@code save(Task entity)}</li>
 *     <li>{@code findById(Long id)}</li>
 *     <li>{@code findAll()}</li>
 *     <li>{@code deleteById(Long id)}</li>
 *     <li>...and more</li>
 * </ul>
 */


import org.springframework.data.jpa.repository.JpaRepository;
/**
public interface TaskRepository extends JpaRepository<TaskJpaEntity, Long> {
    // No need to define save, findById, or findAll—they're already available from JpaRepository
}
**/

public interface TaskRepository {
    Task save(Task task);
    Task findById(Long id);
    List<Task> findAll();
}



