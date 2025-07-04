-- ===========================================
-- RESET ALL TABLES / DELETE
-- ===========================================
DROP TABLE IF EXISTS salaries, employees, departments CASCADE;

-- ===========================================
-- Departments Table
-- ===========================================
CREATE TABLE departments (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL UNIQUE
);

-- Insert Dummy Departments
INSERT INTO departments (name) VALUES
  ('Human Resources'),
  ('Engineering'),
  ('Sales'),
  ('Marketing'),
  ('Finance'),
  ('Customer Support'),
  ('Legal'),
  ('IT'),
  ('Operations'),
  ('Research and Development');

-- View departments
SELECT * FROM departments;

-- ===========================================
-- Employees Table
-- ===========================================
CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  department_id INT REFERENCES departments(id),
  job_title VARCHAR(50) NOT NULL,
  hire_date DATE NOT NULL,
  salary NUMERIC NOT NULL
);

-- Insert Dummy Employees
INSERT INTO employees (name, department_id, job_title, hire_date, salary) VALUES
  ('Alice Johnson', 1, 'HR Manager', '2022-01-15', 60000.00),
  ('Bob Smith', 2, 'Software Engineer', '2021-03-22', 85000.00),
  ('Carol Davis', 4, 'Marketing Specialist', '2023-07-01', 50000.00),
  ('Dan Miller', 5, 'Accountant', '2020-10-10', 70000.00),
  ('Eva Brown', 3, 'Sales Executive', '2019-05-30', 55000.00),
  ('Frank Wilson', 2, 'DevOps Engineer', '2021-11-20', 88000.00),
  ('Grace Lee', 7, 'Legal Advisor', '2023-04-12', 75000.00),
  ('Henry Adams', 9, 'Operations Manager', '2020-06-18', 72000.00),
  ('Irene Patel', 6, 'Support Agent', '2022-08-14', 42000.00),
  ('Jack White', 8, 'IT Specialist', '2023-01-10', 67000.00),
  ('Kelly Nguyen', 10, 'Research Scientist', '2021-12-01', 92000.00),
  ('Leo Carter', 2, 'Backend Developer', '2020-03-15', 81000.00),
  ('Maria Lopez', 1, 'Recruiter', '2023-03-22', 58000.00),
  ('Nathan Kim', 3, 'Sales Analyst', '2021-09-17', 56000.00),
  ('Olivia Zhang', 4, 'Content Strategist', '2022-05-19', 53000.00),
  ('Paul Green', 5, 'Financial Analyst', '2020-07-25', 74000.00),
  ('Quinn Harper', 6, 'Customer Success Rep', '2019-11-30', 45000.00),
  ('Rachel Stone', 7, 'Paralegal', '2022-06-11', 69000.00),
  ('Steve Baker', 8, 'Network Admin', '2021-04-04', 71000.00),
  ('Tina Morris', 9, 'Logistics Coordinator', '2023-02-28', 62000.00),
  ('Uma Thomas', 10, 'AI Researcher', '2022-09-10', 98000.00),
  ('Victor Reed', 1, 'HR Assistant', '2020-05-14', 52000.00),
  ('Wendy Brooks', 2, 'Frontend Developer', '2019-12-23', 80000.00),
  ('Xander Hayes', 3, 'Sales Rep', '2021-08-05', 54000.00),
  ('Yara Singh', 4, 'Digital Marketer', '2023-01-17', 56000.00),
  ('Zane Walker', 5, 'Auditor', '2022-10-09', 73000.00),
  ('Amy Flores', 6, 'Help Desk Technician', '2021-06-29', 44000.00),
  ('Brian Scott', 7, 'Legal Secretary', '2020-02-03', 66000.00),
  ('Chloe Nguyen', 8, 'Security Analyst', '2023-05-21', 79000.00),
  ('David Young', 9, 'Facilities Manager', '2019-08-18', 75000.00);

-- View employees
SELECT * FROM employees;

-- TO TEST RANK()
INSERT INTO employees (name, department_id, job_title, hire_date, salary) VALUES
('Steve Ochwada', 2, 'Backend Developer', '2020-05-15', 75000.00),
('Ashely Ochwada', 2, 'Backend Developer', '2020-05-15', 75000.00),
('Linda Ochwada', 2, 'Backend Developer', '2020-05-15', 88000.00);

-- ===========================================
-- Salaries Table
-- ===========================================
CREATE TABLE salaries (
  id SERIAL PRIMARY KEY,
  employee_id INT REFERENCES employees(id),
  amount NUMERIC NOT NULL,
  effective_date DATE NOT NULL
);

-- Insert Dummy Salaries
INSERT INTO salaries (employee_id, amount, effective_date) VALUES
  (2, 85000.00, '2021-03-22'),
  (3, 50000.00, '2023-07-01'),
  (4, 70000.00, '2020-10-10'),
  (5, 55000.00, '2019-05-30'),
  (6, 88000.00, '2021-11-20'),
  (7, 75000.00, '2023-04-12'),
  (8, 72000.00, '2020-06-18'),
  (9, 42000.00, '2022-08-14'),
  (10, 67000.00, '2023-01-10'),
  (11, 92000.00, '2021-12-01'),
  (12, 81000.00, '2020-03-15'),
  (13, 58000.00, '2023-03-22'),
  (14, 56000.00, '2021-09-17'),
  (15, 53000.00, '2022-05-19'),
  (16, 74000.00, '2020-07-25'),
  (17, 45000.00, '2019-11-30'),
  (18, 69000.00, '2022-06-11'),
  (19, 71000.00, '2021-04-04'),
  (20, 62000.00, '2023-02-28'),
  (21, 98000.00, '2022-09-10'),
  (22, 52000.00, '2020-05-14'),
  (23, 80000.00, '2019-12-23'),
  (24, 54000.00, '2021-08-05'),
  (25, 56000.00, '2023-01-17'),
  (26, 73000.00, '2022-10-09'),
  (27, 44000.00, '2021-06-29'),
  (28, 66000.00, '2020-02-03'),
  (29, 79000.00, '2023-05-21'),
  (30, 75000.00, '2019-08-18'),
  (1, 60000.00, '2022-01-15'); 
  
  -- now added for Alice Johnson if ID = 1 is reused

-- View salaries
SELECT * FROM salaries;
-- TO TEST RANK()
INSERT INTO salaries (employee_id, amount, effective_date) VALUES
(31, 75000.00, '2020-05-15')
(32, 75000.00, '2020-05-15')
(33, 88000.00, '2020-05-15');


-- ===========================================
-- Indexes for Performance
-- ===========================================
-- B-Tree index on salary amount
CREATE INDEX idx_employees_salary ON salaries(amount);

-- Hash index on department name
CREATE INDEX idx_departments_name_hash ON departments USING HASH (name);


-- ===========================================
--1. Show all employee details with their department name. Tips: Use JOIN.
-- ======================================
SELECT e.*, d.name 
FROM employees e JOIN departments d 
ON  e.department_id = d.id;

-- ===========================================
--2.  List only the names and salaries of all employees. Tips: Use SELECT, choose specific columns.
-- ======================================
SELECT name, salary FROM employees;

-- ===========================================
--3.  List all unique department names. Tips: Use DISTINCT.
-- ======================================
SELECT DISTINCT name FROM departments;

-- ===========================================
--4.  Count the total number of employees. Tips: Use COUNT().
-- ======================================
SELECT COUNT(id) FROM employees;

-- ===========================================
--5.  Count how many employees work in each department. Tips: Use GROUP BY, COUNT().
-- ======================================
SELECT d.name, COUNT(e.id)
FROM departments d JOIN employees e 
ON  e.department_id = d.id
GROUP BY d.name;

-- ===========================================
--️ 6. Find employees with a salary greater than 60,000. Tips: Use WHERE.
-- ======================================
SELECT * FROM employees
WHERE salary > 60000;

-- ===========================================
--️ 7. List all employees in the Sales department. Tips: Use JOIN and WHERE.
-- ======================================
SELECT e.*, d.name 
FROM employees e JOIN departments d 
ON e.department_id = d.id
WHERE d.name = 'Sales';

-- ===========================================
--️ 8. Show employees who work in HR or Sales. Tips: Use WHERE ... IN (...).
-- ======================================
SELECT e.*, d.name 
FROM Employees e JOIN departments d 
ON e.department_id = d.id
WHERE d.name IN ('Sales' , 'Human Resources');

-- ===========================================
--️ 9. Find employees not working in HR. Tips: Use WHERE ... !=.
-- ======================================
SELECT e.* , d.name 
FROM  Employees e JOIN departments d
ON e.department_id = d.id
WHERE d.name != 'Human Resources';

-- ===========================================
--️ 10. List employees with salaries between 50,000 and 70,000. Tips: Use BETWEEN.
-- ======================================
SELECT * FROM employees
WHERE salary BETWEEN 50000 AND 70000;

-- ===========================================
--️ 11. Show employees sorted by salary from lowest to highest. Tips: Use ORDER BY salary ASC.
-- ======================================
SELECT e.*, s.amount
FROM employees e JOIN salaries s 
ON s.employee_id  =  e.id 
ORDER BY s.amount ASC;

-- ===========================================
--️ 12. List employees sorted by department and then by salary descending. Tips: Use ORDER BY.
-- ======================================
SELECT e.id, e.name, e.job_title,
    s.amount, 
    d.name
FROM employees e
INNER JOIN salaries s ON s.employee_id  =  e.id 
INNER JOIN departments d ON e.department_id = d.id
ORDER BY d.name, s.amount;

-- ===========================================
--️ 13. Find the top 3 highest-paid employees. Tips: Use ORDER BY, LIMIT.
-- ======================================
SELECT  id, name, salary
FROM employees
ORDER BY salary DESC
LIMIT 3;

-- ===========================================
--️ 14. Calculate the average salary of all employees. Tips: Use AVG().
-- ======================================
SELECT ROUND(AVG(salary), 2)
FROM Employees;
-- ===========================================
--️ 15. Compute the total salary cost for all employees. Tips: Use SUM().
-- ======================================
SELECT SUM(salary)
FROM Employees;

-- ===========================================
--️ 16. Count the number of employees in each department. Tips: Use GROUP BY, COUNT().
-- ======================================
SELECT d.name, COUNT(e.id) AS no_of_employees
FROM employees e JOIN departments d
ON d.id = e.department_id
GROUP BY d.name;

-- ===========================================
--️ 17. Calculate the average salary in each department. Tips: Use GROUP BY, AVG().
-- ======================================
SELECT d.name, ROUND(AVG(s.amount), 2) AS avg_salary
FROM departments d
JOIN Employees e ON d.id = e.department_id
JOIN salaries s ON e.id = s.employee_id
GROUP BY d.name; 

-- ===========================================
--️ 18. Find the highest salary in each department. Tips: Use GROUP BY, MAX().
-- ======================================
SELECT d.name, MAX(s.amount) AS highest_salary_per_dept
FROM departments d
JOIN Employees e ON d.id = e.department_id
JOIN salaries s ON e.id = s.employee_id
GROUP BY d.name
ORDER BY d.name;

-- ===========================================
-- 19. List departments that have more than 2 employees. Tips: Use GROUP BY, HAVING COUNT().
-- ======================================
SELECT d.name, COUNT(e.id) as employees_count
FROM employees e 
JOIN departments d ON d.id = e.department_id
GROUP BY d.name
HAVING COUNT(e.id) > 2;

-- ===========================================
-- 20. Show departments with an average salary above 60,000. Tips: Use GROUP BY, HAVING AVG().
-- ======================================
SELECT d.name, ROUND(AVG(s.amount), 2) as avg_salary_abv_60000
FROM employees e
JOIN departments d ON e.department_id = d.id
JOIN salaries s ON s.employee_id = e.id 
GROUP BY d.name
HAVING AVG(s.amount) > 60000;

-- ===========================================
-- 21. Find departments with a total salary cost greater than 150,000. Tips: Use GROUP BY, HAVING SUM().
-- ======================================
SELECT d.name, SUM(s.amount) AS total_salary_per_dep_abv_150000
FROM departments d
JOIN employees e ON d.id = e.department_id
JOIN salaries s ON s.employee_id = e.id
GROUP BY d.name
HAVING SUM(s.amount) > 150000;

-- ===========================================
-- 22. Find employees earning above the overall average salary. Tips: Use subquery in WHERE.
-- ======================================
SELECT 
    e.id,
    e.name, 
    s.amount AS salary, 
    s.amount - 
      (
        SELECT ROUND(AVG(amount)) FROM salaries
      )  AS amount_above_avg
FROM employees e
JOIN salaries s ON s.employee_id = e.id
WHERE  s.amount > (
  SELECT AVG(amount) FROM salaries
)
ORDER BY s.amount;

-- ===========================================
-- 23. List employees earning above their department’s average salary. Tips: Use correlated subquery.
-- ======================================
SELECT 
  e.id,
  e.name,
  s.amount AS salary,
  s.amount - 
  (
    SELECT ROUND(AVG(amount)) FROM salaries
  ) AS  amount_above_avg
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id
WHERE s.amount > (
  SELECT AVG(amount) FROM salaries
  GROUP BY d.name
)
ORDER BY s.amount;

-- ===========================================
-- 24. Find departments with at least one employee earning over 80,000. Tips: Use EXISTS or IN.
-- ======================================
SELECT 
  d.name,
  e.name,
  s.amount,
  s.amount - (
    SELECT ROUND(AVG(amount)) FROM salaries
  ) AS abv_80000_by
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id
WHERE EXISTS (
  SELECT 1
  FROM Salaries s2 
  WHERE s2.employee_id = e.id AND s2.amount > 80000
)
ORDER BY s.amount;

-- ===========================================
-- 25. Get the top earner in each department. Tips: Use subquery with MAX() or window functions.
-- ======================================
SELECT 
  e.name AS name_of_highest_earner,
  d.name AS department_name,
  s.amount AS salary
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id
WHERE s.amount = (
  SELECT MAX(s2.amount)
  FROM employees e2
  JOIN salaries s2 ON s2.employee_id = e2.id
  WHERE e2.department_id = e.department_id
)
ORDER BY d.name;


-- ===========================================
-- 26. Show each employee with their rank in their department by salary. Tips: Use RANK() OVER (PARTITION BY ...).
-- ======================================
SELECT 
  e.id,
  e.name,
  s.amount AS salary,
  d.name AS department_name,
  RANK() OVER ( -- handles ties (two people with the same salary get the same rank, then it skips to the next).
      PARTITION BY d.id  -- starts a new ranking per department.
      ORDER BY s.amount DESC -- higher salaries get lower (better) ranks (1 = highest).
  ) AS salary_rank
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id 
ORDER BY d.name, salary_rank;


-- ===========================================
-- 27. Assign dense rank of salary within each department. Tips: Use DENSE_RANK().
-- ======================================
SELECT 
  e.id,
  e.name,
  s.amount AS salary,
  d.name AS department_name,
  DENSE_RANK() OVER ( PARTITION BY d.id  ORDER BY s.amount DESC ) AS salary_rank
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id 
ORDER BY d.name, salary_rank;


-- ===========================================
-- 28. Calculate the running total of salaries ordered by salary. Tips: Use SUM() OVER (ORDER BY salary).
-- ======================================
SELECT 
  e.name,
  s.amount AS salary,
  -- calculates a running (cumulative) total of salaries from the lowest to highest.
  SUM(s.amount) OVER (ORDER BY s.amount) AS running_total
FROM Employees e
JOIN salaries s ON s.employee_id = e.id
ORDER BY s.amount;


-- ===========================================
-- 29. For each employee, show the average salary in their department. Tips: Use AVG() OVER (PARTITION BY ...).
-- Calculates the average salary per department. This is done using a window function instead of GROUP BY. 
------ So you get the average value repeated on each row, without collapsing rows like GROUP BY would.
-- ======================================
SELECT 
  e.id,
  e.name,
  s.amount AS salary,
  d.name AS department_name,
AVG(s.amount) OVER ( PARTITION BY d.name) AS avg_salary
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id 
ORDER BY d.name, avg_salary;

-- ===========================================
-- 30. List Engineering employees earning above the Engineering department average. Tips: Use subquery or window function.
-- ======================================
WITH engineering_salary AS (
  SELECT 
    e.name,
    s.amount AS salary,
    d.name AS department_name,
    ROUND(AVG(s.amount) OVER (PARTITION BY d.name), 2) AS avg_dept_salary -- calculates the average salary per department.
  FROM employees e
  JOIN salaries s ON s.employee_id = e.id
  JOIN departments d ON d.id = e.department_id 
  WHERE d.name = 'Engineering' 
)
SELECT *
FROM engineering_salary
WHERE salary > avg_dept_salary;


-- ===========================================
-- 31. Show each employee with the difference between their salary and their department’s average. Tips: Use window function with AVG().
-- ======================================
SELECT 
  e.id,
  e.name,
  s.amount AS salary,
  d.name AS department_name,
  ROUND(AVG(s.amount) OVER ( PARTITION BY d.name),2) AS avg_salary_per_dept,
  (s.amount - ROUND(AVG(s.amount) OVER (PARTITION BY d.name), 2)) AS salary_diff_to_dept_avg
FROM employees e
JOIN salaries s ON s.employee_id = e.id
JOIN departments d ON d.id = e.department_id
ORDER BY d.name, salary_diff_to_dept_avg DESC;