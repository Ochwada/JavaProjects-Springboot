package com.example.smartscheduler.repository;


import com.example.smartscheduler.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * *******************************************************
 * Package: com.example.smartscheduler.repository
 * File: PersonRepository.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 12:13 PM
 * Description: Repository interface for managing {@link Person} entities.
 * - - Extends {@link CrudRepository} to provide basic CRUD operations.
 * * Spring will automatically generate the implementation at runtime.
 * Objective:
 * *******************************************************
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    // No need to write any code - CRUD methods are inherited:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - count()
}
