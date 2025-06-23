package com.example.taskmanager.database;


import com.example.taskmanager.domain.Task;
import com.example.taskmanager.domain.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * *******************************************************
 * Package: com.example.taskmanager.database
 * File: JpaTaskRepository.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 11:35 AM
 * Description: Implementation of the {@link TaskRepository} interface.
 * *This class serves as an adapter between the domain-level {@link Task} model
 * * and the JPA entity {@link TaskJpaEntity}, delegating persistence operations
 * * to {@link SpringDataTaskRepository}.
 * Objective:
 * *******************************************************
 */

@Repository
@RequiredArgsConstructor
public class JpaTaskRepository implements TaskRepository {

    /**
     * The Spring Data JPA repository that manages {@link TaskJpaEntity} persistence.
     */
    private final SpringDataTaskRepository springDataTaskRepository;

    /**
     * Saves a {@link Task} domain object by mapping it to a {@link TaskJpaEntity},
     * and returns the saved result mapped back to a domain object.
     *
     * @param task the domain task to be saved
     * @return the saved task with updated ID (if applicable)
     */
    @Override
    public Task save(Task task) {
        TaskJpaEntity entity = new TaskJpaEntity(task.getDescription(), task.isCompleted());

        if (task.getId() != null) {
            entity.setId(task.getId());
        }

        TaskJpaEntity saved = springDataTaskRepository.save(entity);
        return new Task(saved.getId(), saved.getDescription(), saved.isCompleted());
    }

    /**
     * Finds a {@link Task} by its ID by retrieving the corresponding
     * {@link TaskJpaEntity} from the database and converting it to a domain object.
     *
     * @param id the unique identifier of the task
     * @return the corresponding {@link Task} if found, or null if not
     */
    @Override
    public Task findById(Long id) {
        return springDataTaskRepository.findById(id)
                .map(entity ->
                        new Task(
                                entity.getId(),
                                entity.getDescription(),
                                entity.isCompleted()
                        ))
                .orElse(null);
    }


    /**
     * Retrieves all tasks from the database.
     * <p>
     * Converts the list of {@link TaskJpaEntity} objects retrieved via the
     * Spring Data repository into a list of domain {@link Task} objects.
     *
     * @return a list of all tasks as domain objects
     */
    @Override
    public List<Task> findAll() {
        return springDataTaskRepository.findAll().stream()
                .map(entity ->
                        new Task(
                                entity.getId(),
                                entity.getDescription(),
                                entity.isCompleted()
                        ))
                .toList();
    }
}
