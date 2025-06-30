package com.example.companyhr.web;


import com.example.companyhr.model.Employee;
import com.example.companyhr.repo.EmployeeRepository;
import com.example.companyhr.repo.EmployeeRepositoryCustom;
import com.example.companyhr.sql.EmployeeQuery;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * *******************************************************
 * Package: com.example.companyhr.web
 * File: EmployeeController.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 9:59 AM
 * Description: REST controller for managing Employee data.
 * Objective:
 * *******************************************************
 */

/**
 * This controller provides endpoints to retrieve, create, and filter employees
 * using both standard repository methods and custom SQL queries via {@link EmployeeRepositoryCustom}.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repository;
    private final EmployeeRepositoryCustom repositoryCustom;


    /**
     * Constructs the {@code EmployeeController} with standard and custom repositories.
     *
     * @param repository       the JPA repository for basic CRUD operations
     * @param repositoryCustom the custom repository for executing dynamic SQL queries
     */
    public EmployeeController(EmployeeRepository repository,
                              EmployeeRepositoryCustom repositoryCustom) {
        this.repository = repository;
        this.repositoryCustom = repositoryCustom;
    }

    /**
     * Retrieves all employees from the database.
     *
     * @return an iterable list of all {@link Employee} entities
     */
    @GetMapping
    public Iterable<Employee> getAll() {
        return repository.findAll();
    }

    /**
     * Adds a new employee to the database.
     *
     * @param e the {@link Employee} object to be persisted (from request body)
     * @return the saved {@link Employee} entity with generated ID
     */
    @PostMapping
    public Employee add(@RequestBody Employee e) {
        return repository.save(e);
    }

    /**
     * Retrieves all employees whose salary is above a specified threshold.
     * <p>
     * This uses a native SQL query defined in {@link EmployeeQuery#HIGH_SALARY} and executed
     * via the custom repository.
     * </p>
     * <p>
     * Example:
     * <pre>
     * GET /employees/high-salary?threshold=50000
     * </pre>
     *
     * @param threshold the minimum salary value used as a filter
     * @return a list of employees with salaries greater than the specified threshold
     */
    @GetMapping("/high-salary")
    public List<Employee> highSalary(@RequestParam double threshold) {
        return repositoryCustom.executeEmployeeQuery(EmployeeQuery.HIGH_SALARY, threshold);
    }

    /**
     * Retrieves the average salary for each department.
     * <p>
     * This query returns a list of raw results where each row contains:
     * - the department name
     * - the average salary for that department
     *
     * @return a list of {@code Object[]} arrays representing department and average salary
     */
    @GetMapping("/avg-salary")
    public List<Object[]> averageSalaryByDepartment() {
        return repositoryCustom.executeObjectArrayQuery(EmployeeQuery.AVG_SALARY_BY_DEPARTMENT);
    }

    /**
     * Retrieves employees who earn more than the average salary of their own department.
     * <p>
     * This uses a correlated subquery and returns full {@link Employee} entities.
     * </p>
     *
     * @return a list of {@link Employee} instances earning above their department average
     */
    @GetMapping("/above-avg")
    public List<Employee> aboveAvg() {
        return repositoryCustom.executeEmployeeQuery(
                EmployeeQuery.EMPLOYEE_ABOVE_DEPARTMENT_AVG
        );
    }

    /**
     * Retrieves employee salary rankings within each department.
     * <p>
     * This query returns a list of raw results where each row contains:
     * - employee ID
     * - name
     * - department
     * - salary
     * - rank within the department (1 = highest salary)
     * </p>
     * <p>
     * Example result:
     * <pre>
     * [
     *   [1, "Alice", "Sales", 6000.0, 1],
     *   [2, "Bob", "Sales", 5500.0, 2],
     *   [3, "Carol", "HR", 5200.0, 1]
     * ]
     * </pre>
     *
     * @return a list of {@code Object[]} arrays representing ranked employee data
     */
    @GetMapping("/ranking")
    public List<Object[]> ranking() {
        return repositoryCustom
                .executeObjectArrayQuery(
                        EmployeeQuery.EMPLOYEE_RANKING
                );
    }


}
