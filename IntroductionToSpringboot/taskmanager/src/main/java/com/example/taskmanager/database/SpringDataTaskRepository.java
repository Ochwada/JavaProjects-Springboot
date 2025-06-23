package com.example.taskmanager.database;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * *******************************************************
 * Package: com.example.taskmanager.database
 * File: SpringDataTaskRepository.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 11:36 AM
 * Description: Repository interface for accessing TaskJpaEntity data.
 * * Spring will auto-generate the implementation at runtime.
 * Objective:
 * *******************************************************
 */

@Repository
public interface SpringDataTaskRepository extends JpaRepository<TaskJpaEntity, Long> {
    // Add custom query methods here if needed
}