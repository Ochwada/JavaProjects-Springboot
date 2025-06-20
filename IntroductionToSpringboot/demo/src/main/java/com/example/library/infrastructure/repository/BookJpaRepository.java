package com.example.library.infrastructure.repository;


import com.example.library.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * *******************************************************
 * Package: com.example.library.infrastructure.repository
 * File: BookJpaRepository.java
 * Author: Ochwada
 * Date: Friday, 20.Jun.2025, 12:29 PM
 * Description: Repository interface for managing {@link BookEntity} persistence operations.
 * - This interface extends {@link JpaRepository}, which provides built-in methods for
 * common CRUD operations such as save, findAll, findById, and delete.
 *
 * @param <BookEntity> the type of the entity managed by this repository
 * @param <Long> the type of the primary key (ID) of the entity
 * Objective:
 * *******************************************************
 */

/**
 * {@code @Repository} marks this interface as a Spring Data repository, enabling Spring
 * to detect and inject it where needed.
 * Marks this interface as Spring managed bean.
 */
@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
}
