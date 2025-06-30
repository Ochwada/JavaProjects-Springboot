package com.example.companyhr.repo;


import com.example.companyhr.model.Employee;
import com.example.companyhr.sql.EmployeeQuery;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * *******************************************************
 * Package: com.example.companyhr.repo
 * File: EmployeeRepositoryCustom.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 12:06 PM
 * Description:  Custom repository interface for executing dynamic employee-related SQL queries.
 * * This interface is intended to complement the standard {@code EmployeeRepository} by providing
 * * a flexible method for running SQL queries defined in the {@link EmployeeQuery} enum.
 * Objective:
 * *******************************************************
 */

@Repository
public interface EmployeeRepositoryCustom {

    /**
     * Executes the specified SQL query from the {@link EmployeeQuery} enum,
     * optionally binding any provided query parameters.
     *
     * @param query  the predefined {@link EmployeeQuery} to execute
     * @param params the positional parameters to bind to the query (e.g., thresholds)
     * @return a list of {@link Employee} entities matching the query
     */
    List<Employee> executeEmployeeQuery(EmployeeQuery query, Object... params);

    // in our case : EmployeeQuery.HIGH_SALARY, 5000
    // params[0] = 5000

    /**
     * Executes the specified SQL query from the {@link EmployeeQuery} enum and returns the raw results
     * as a list of {@code Object[]} arrays.
     * <p>
     * This method is useful when the result set does not map directly to a JPA entity (e.g., aggregated results,
     * projections, or joins). Each {@code Object[]} represents a row in the result set, and individual
     * columns are accessed by index.
     * <p>For example, consider the query {@code AVG_SALARY_BY_DEPARTMENT}:</p>
     * <pre>
     *  -- department | avg_salary
     *  -- HR         | 45000
     *  -- IT         | 65000
     *
     *  Object[] row1 = result.get(0); // ["HR", 45000]
     *  Object[] row2 = result.get(1); // ["IT", 65000]
     *
     *  result.get(0) -> Object[] [{"HR", 45000}, {"IT", 65000}]
     *  </pre>
     *
     * @param query  the predefined {@link EmployeeQuery} to execute
     * @param params optional query parameters to bind by position (e.g., for {@code ?1}, {@code ?2}, etc.)
     * @return a list of rows, each represented as an {@code Object[]} array
     */
    List<Object[]> executeObjectArrayQuery(EmployeeQuery query, Object... params);
    // department | avg_salary
    // HR           45000
    // IT           65000

    // The java results will be :
    // result.get(0) -> Object[] [{"HR", 45000}, {"IT", 65000}]
}
