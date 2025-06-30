package com.example.companyhr.sql;


/**
 * *******************************************************
 * Package: com.example.companyhr.sql
 * File: EmployeeQuery.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 9:59 AM
 * Description: he {@code EmployeeQuery} enum defines reusable SQL queries related to employee operations.
 * - Each enum constant holds a predefined SQL query string that can be used for database access
 * via JDBC or other data-access layers.
 * -Serves as "catalog" of SQL concepts
 * Objective:
 * *******************************************************
 */


public enum EmployeeQuery {

    // =====================  START QUERY =====================
    /**
     * Retrieves all employees from the 'employees' table.
     */
    SELECT_ALL("SELECT * FROM employees"),

    /**
     * Retrieves employees whose salary is above a specified threshold.
     * Use parameterized queries to safely inject the threshold value.
     * * <p>
     * * The {@code ?1} is a positional parameter placeholder used in JPQL or native SQL,
     * * representing the **first parameter** passed to the query method at runtime.
     * * This ensures safe and dynamic query execution without SQL injection risks.
     * * </p>
     */
    HIGH_SALARY("SELECT * FROM employees WHERE salary > ?1"),
    //  HIGH_SALARY("SELECT * FROM employees WHERE salary > ?1 AND salary < ?2")


    /**
     * Retrieves the average salary for each department.
     * <p>
     * This query uses the SQL {@code GROUP BY} clause to group employees by their
     * {@code department}, and calculates the average salary within each group using {@code AVG(salary)}.
     * The result includes two columns: {@code department} and {@code avg_salary}.
     * </p>
     * Example result:
     * <pre>
     * +-------------+-------------+
     * | department  | avg_salary  |
     * +-------------+-------------+
     * | Sales       | 5500.00     |
     * | Engineering | 7200.00     |
     * | HR          | 4800.00     |
     * +-------------+-------------+
     * </pre>
     */
    AVG_SALARY_BY_DEPARTMENT(
            "SELECT department, AVG(salary) as avg_salary FROM employees GROUP BY department"),

    /**
     * Retrieves employees who earn more than the average salary of their respective department.
     * <p>
     * This query uses a correlated subquery to calculate the average salary per department
     * and compares each employee's salary against that average.
     * </p>
     * <p>
     * Logic:
     * <ul>
     *     <li>The outer query selects all employee records.</li>
     *     <li>The inner subquery computes the average salary for the employee’s department.</li>
     *     <li>The condition {@code salary > (SELECT AVG(salary) ...)} ensures only above-average earners are included.</li>
     * </ul>
     * <p>
     * Example result:
     * <pre>
     * +----+---------+-------------+--------+
     * | id | name    | department  | salary |
     * +----+---------+-------------+--------+
     * | 3  | Alice   | Sales       | 6000   |
     * | 5  | Victor  | HR          | 5200   |
     * +----+---------+-------------+--------+
     * </pre>
     */
    EMPLOYEE_ABOVE_DEPARTMENT_AVG(
            "SELECT * FROM employees e" +
                    "WHERE salary > " +
                    "(SELECT AVG(salary) FROM employees WHERE department = e.department)"),


    /**
     * Ranks employees within each department based on their salary.
     * <p>
     * This query uses the SQL {@code RANK()} window function with the {@code OVER()} clause to assign
     * a ranking to each employee in the same department, ordered by their salary.
     * The result includes a new column {@code dept_rank} indicating an employee’s rank within their department.
     * </p>
     * <p>
     * Example result:
     * <pre>
     * +----+--------+-------------+--------+-----------+
     * | id | name   | department  | salary | dept_rank |
     * +----+--------+-------------+--------+-----------+
     * | 1  | Alice  | Sales       | 6000   |     1     |
     * | 2  | Bob    | Sales       | 5500   |     2     |
     * | 3  | Carol  | HR          | 5200   |     1     |
     * +----+--------+-------------+--------+-----------+
     * </pre>
     */
    EMPLOYEE_RANKING(
            "SELECT id, name, department, salary," +
                    "RANK() OVER(PARTITION BY department ORDER BY salary DESC) AS dept_rank" +
                    "FROM employees"
    )
    // ==========END QUERY =====================
    ;
    // ===================== =====================
    /**
     * The SQL query string associated with the enum constant.
     */
    private final String sql;

    /**
     * Constructs a new {@code EmployeeQuery} with the specified SQL query.
     *
     * @param sql the SQL query string
     */
    EmployeeQuery(String sql) {
        this.sql = sql;
    }

    /**
     * Returns the SQL query string associated with this query type.
     *
     * @return the SQL query string
     */
    public String getSql() {
        return sql;
    }
}

