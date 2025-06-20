package com.example.library.domain.model;

// In SpringBoot:
// -jakarta.validation.* : This is a package from Oracle

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * *******************************************************
 * Package: com.example.demo.model
 * File: Book.java
 * Author: Ochwada
 * Date: Friday, 20.Jun.2025, 11:14 AM
 * Description: Represents a Book entity with basic properties such as ID, title, author, and publication year
 * - Model Class - POJO
 * Objective:
 * *******************************************************
 */


/**
 * {@code @Data} is a Lombok annotation that automatically generates:
 * - Getters and setters for all fields
 * - {@code toString()}, {@code equals()}, and {@code hashCode()} methods
 * - A required {@code constructor}
 * <p>
 * This helps reduce boilerplate code in Java classes.
 */
@Data

public class Book {
    private Long id;

    /**
     * Imports the {@code @NotBlank} annotation from the Jakarta Validation API.
     * It’s used for validating user input in a Spring Boot application (and other Java apps).
     * {@code @NotBlank} is a validation constraint that ensures a String is not null, not empty, and not just
     * whitespace.
     * <p>
     * {@code @NotBlank} ensures the field is not null, empty, or whitespace only.
     * {@code @Size(min = 2)} ensures the field has at least 2 characters.
     */
    @NotBlank(message = "Title is required")
    @Size(min = 2, message = "Title must have at least 2 characters")
    private String title;

    /**
     * The author's name.
     * <p>
     * {@code @NotBlank} is used to ensure that the field is not {@code null}, empty,
     * or only whitespace.
     * <p>
     * Validation will fail if this field is missing or contains only spaces.
     */
    @NotBlank(message = "Author is required")
    private String author;


}
