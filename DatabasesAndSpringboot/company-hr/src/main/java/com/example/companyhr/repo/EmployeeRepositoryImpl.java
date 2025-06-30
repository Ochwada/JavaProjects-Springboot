package com.example.companyhr.repo;


import com.example.companyhr.model.Employee;
import com.example.companyhr.sql.EmployeeQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * *******************************************************
 * Package: com.example.companyhr.repo
 * File: EmployeeRepositoryImpl.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 12:25 PM
 * Description: Implementation of the {@link EmployeeRepositoryCustom} interface.
 * Objective:
 * *******************************************************
 */

/**
 * This class is responsible for executing custom employee queries defined in the {@link EmployeeQuery}
 * enum, with optional parameter binding. The implementation typically uses {@code EntityManager} for
 * executing native SQL queries that are not directly handled by Spring Data JPA.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    /**
     * The JPA {@link EntityManager} used to execute native SQL queries.
     * <p>
     * It provides an interface to manage persistence and allows the execution of dynamic queries
     * that are not handled by Spring Data JPA's method naming conventions or annotations.
     * </p>
     */
    private final EntityManager entityManager; // speaks to the database

    /**
     * Constructs the custom repository implementation with a provided {@link EntityManager}.
     *
     * @param entityManager the JPA entity manager used for query execution and parameter binding
     */
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * Executes a native SQL query defined in the {@link EmployeeQuery} enum and maps the result
     * directly to a list of {@link Employee} entities.
     * <p>
     * This method uses the {@link EntityManager} to create a native SQL query and binds any provided
     * parameters to positional placeholders such as {@code ?1}, {@code ?2}, etc. Each resulting row
     * is automatically mapped to the {@code Employee} entity class using JPA.
     * </p>
     * <p>If the query does not require parameters (e.g., {@code SELECT_ALL}), you may omit them.</p>
     *
     * @param query  the {@link EmployeeQuery} constant containing the SQL query string
     * @param params optional query parameters to bind to the SQL placeholders
     * @return a list of {@link Employee} entities mapped from the query result
     */
    @Override
    public List<Employee> executeEmployeeQuery(EmployeeQuery query, Object... params) {
        // Create a native query mapped to the Employee entity
        Query nativeQuery = entityManager.createNativeQuery(
                query.getSql(),
                Employee.class
        );

        // Bind parameters to the query using positional indexes
        setParameters(nativeQuery, params);

        // Execute the query and return the mapped result list
        return nativeQuery.getResultList();
    }


    /**
     * Executes a native SQL query defined in the {@link EmployeeQuery} enum and returns raw results
     * as a list of {@code Object[]} arrays.
     * <p>
     * This method is useful for queries that return projections, aggregations, or partial results
     * (e.g., grouped columns, averages, or custom selects) that do not directly map to a JPA entity.
     * </p>
     *
     * <p>Parameters are bound using positional placeholders like {@code ?1}, {@code ?2}, etc., with
     * values supplied through the {@code params} varargs.</p>
     *
     * @param query  the {@link EmployeeQuery} constant containing the SQL query string
     * @param params optional parameters to bind into the query
     * @return a list of raw result rows, each represented as an {@code Object[]} array
     */
    @Override
    public List<Object[]> executeObjectArrayQuery(EmployeeQuery query, Object... params) {

        // Create a native query (no result mapping to an entity)
        Query nativeQuery = entityManager.createNativeQuery(
                query.getSql()
        );

        // Bind parameters to the query using positional indexes
        setParameters(nativeQuery, params);

        // Execute the query and return the raw result set
        return nativeQuery.getResultList();
    }

    private void setParameters(Query nativeQuery, Object... params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                nativeQuery.setParameter(i + 1, params[i + 1]);
            }
        }
    }
}
