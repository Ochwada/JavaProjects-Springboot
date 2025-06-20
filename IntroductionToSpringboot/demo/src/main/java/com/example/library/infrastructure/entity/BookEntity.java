package com.example.library.infrastructure.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * *******************************************************
 * Package: com.example.library.infrastructure.entity
 * File: BookEntity.java
 * Author: Ochwada
 * Date: Friday, 20.Jun.2025, 12:22 PM
 * Description: Represents the persistent entity for a book record in the database.
 * - This class is mapped to the {@code books} table using JPA annotations.
 *  <ul>
 *     - {@code @Data} generates getters, setters, {@code toString()}, {@code equals()}, and {@code hashCode()} methods.
 *     - {@code @NoArgsConstructor} provides a no-argument constructor required by JPA.
 *     - {@code @AllArgsConstructor} generates a constructor with parameters for all fields.
 *     - {@code @Entity} marks this class as a JPA entity.
 *     - {@code @Table(name = "books")} maps this entity to the {@code books} table in the database.
 *  </ul>
 * <p>
 * Objective:
 * *******************************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books")
public class BookEntity {

    /**
     * The unique identifier for each book record.
     * <p>
     * {@code @Id} marks this field as the primary key.
     * {@code @GeneratedValue(strategy = GenerationType.IDENTITY)} lets the database auto-generate the value.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * The title of the book.
     * <p>
     * {@code @Column(nullable = false)} ensures this field cannot be {@code null} in the database.
     */
    @Column(nullable = false)
    private String title;

    /**
     * The author of the book.
     * <p>
     * {@code @Column(nullable = false)} ensures this field cannot be {@code null} in the database.
     */
    @Column(nullable = false)
    private String author;
}
