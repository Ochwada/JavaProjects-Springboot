package com.example.smartscheduler.model;

import jakarta.persistence.*;

/**
 * *******************************************************
 * Package: com.example.smartscheduler.model
 * File: Person.java
 * Author: Ochwada
 * Date: Tuesday, 24.Jun.2025, 12:02 PM
 * Description: Represents a Person entity with an auto-generated ID and a name.
 * * Used for persistence in the database via JPA.
 * - persistence refers to the storage and retrieval of data (typically in a database)
 * Objective:
 * *******************************************************
 */

@Entity
public class Person {

    /**
     * The unique identifier for each Person.
     * <p>
     * Annotated with {@code @Id} to mark it as the primary key.
     * {@code @GeneratedValue} with strategy {@code AUTO} lets the persistence
     * provider generate the ID automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of the person.
     */
    private String name;

    /**
     * Default no-argument constructor required by JPA.
     */
    public Person() {
    }

    /**
     * Constructor to create a new Person with a specified name.
     * Typically used when creating a new entity before the ID is assigned.
     *
     * @param name the name of the person
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier of the person.
     *
     * @return the person's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the person.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the person.
     *
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
