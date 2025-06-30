package com.example.companyhr.repo;


import com.example.companyhr.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * *******************************************************
 * Package: com.example.companyhr.repo
 * File: EmployeeRepository.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 9:58 AM
 * Description: Repository interface for Employee entity.
 *  - Demo of using advanced SQL queries using nativeQuery
 * Objective:
 * *******************************************************
 */

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    /**
     * Retrieves all employees from the database using a native SQL query.
     *
     * @return a list of all Employee entities
     */


}
