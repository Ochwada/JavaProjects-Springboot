## 🧭 5️⃣ Practice Questions (50 Tasks)

Each task below has:

✅ **Question**: A clear, plain-English data question.
✅ **Tips and hints**: Suggested SQL clauses or functions to use.

Work through them in order, or choose any that interest you!

---

### ✅ SELECT Basics

1️⃣ **Question**: Show all employee details with their department name.
*Tips*: Use `JOIN`.

2️⃣ **Question**: List only the names and salaries of all employees.
*Tips*: Use `SELECT`, choose specific columns.

3️⃣ **Question**: List all unique department names.
*Tips*: Use `DISTINCT`.

4️⃣ **Question**: Count the total number of employees.
*Tips*: Use `COUNT()`.

5️⃣ **Question**: Count how many employees work in each department.
*Tips*: Use `GROUP BY`, `COUNT()`.

---

### ✅ Filtering with WHERE

6️⃣ **Question**: Find employees with a salary greater than 60,000.
*Tips*: Use `WHERE`.

7️⃣ **Question**: List all employees in the Sales department.
*Tips*: Use `JOIN` and `WHERE`.

8️⃣ **Question**: Show employees who work in HR or Sales.
*Tips*: Use `WHERE ... IN (...)`.

9️⃣ **Question**: Find employees not working in HR.
*Tips*: Use `WHERE ... !=`.

🔟 **Question**: List employees with salaries between 50,000 and 70,000.
*Tips*: Use `BETWEEN`.

---

### ✅ Sorting

1️⃣1️⃣ **Question**: Show employees sorted by salary from lowest to highest.
*Tips*: Use `ORDER BY salary ASC`.

1️⃣2️⃣ **Question**: List employees sorted by department and then by salary descending.
*Tips*: Use `ORDER BY`.

1️⃣3️⃣ **Question**: Find the top 3 highest-paid employees.
*Tips*: Use `ORDER BY`, `LIMIT`.

---

### ✅ Aggregates

1️⃣4️⃣ **Question**: Calculate the average salary of all employees.
*Tips*: Use `AVG()`.

1️⃣5️⃣ **Question**: Compute the total salary cost for all employees.
*Tips*: Use `SUM()`.

1️⃣6️⃣ **Question**: Count the number of employees in each department.
*Tips*: Use `GROUP BY`, `COUNT()`.

1️⃣7️⃣ **Question**: Calculate the average salary in each department.
*Tips*: Use `GROUP BY`, `AVG()`.

1️⃣8️⃣ **Question**: Find the highest salary in each department.
*Tips*: Use `GROUP BY`, `MAX()`.

---

### ✅ GROUP BY + HAVING

1️⃣9️⃣ **Question**: List departments that have more than 2 employees.
*Tips*: Use `GROUP BY`, `HAVING COUNT()`.

2️⃣0️⃣ **Question**: Show departments with an average salary above 60,000.
*Tips*: Use `GROUP BY`, `HAVING AVG()`.

2️⃣1️⃣ **Question**: Find departments with a total salary cost greater than 150,000.
*Tips*: Use `GROUP BY`, `HAVING SUM()`.

---

### ✅ Subqueries

2️⃣2️⃣ **Question**: Find employees earning above the overall average salary.
*Tips*: Use subquery in `WHERE`.

2️⃣3️⃣ **Question**: List employees earning above their department’s average salary.
*Tips*: Use correlated subquery.

2️⃣4️⃣ **Question**: Find departments with at least one employee earning over 80,000.
*Tips*: Use `EXISTS` or `IN`.

2️⃣5️⃣ **Question**: Get the top earner in each department.
*Tips*: Use subquery with `MAX()` or window functions.

---

### ✅ Window Functions

2️⃣6️⃣ **Question**: Show each employee with their rank in their department by salary.
*Tips*: Use `RANK() OVER (PARTITION BY ...)`.

2️⃣7️⃣ **Question**: Assign dense rank of salary within each department.
*Tips*: Use `DENSE_RANK()`.

2️⃣8️⃣ **Question**: Calculate the running total of salaries ordered by salary.
*Tips*: Use `SUM() OVER (ORDER BY salary)`.

2️⃣9️⃣ **Question**: For each employee, show the average salary in their department.
*Tips*: Use `AVG() OVER (PARTITION BY ...)`.

---

### ✅ Challenge Queries

3️⃣0️⃣ **Question**: List Engineering employees earning above the Engineering department average.
*Tips*: Use subquery or window function.

3️⃣1️⃣ **Question**: Show each employee with the difference between their salary and their department’s average.
*Tips*: Use window function with `AVG()`.

3️⃣2️⃣ **Question**: Find the top 2 earners in each department.
*Tips*: Use `ROW_NUMBER()` or `RANK()`.

3️⃣3️⃣ **Question**: Identify the department with the highest average salary.
*Tips*: Use `ORDER BY` on `AVG()`.

3️⃣4️⃣ **Question**: List employees who have the same salary as someone in a different department.
*Tips*: Use self-join.

---

### ✅ Foreign Keys and Joins

3️⃣5️⃣ **Question**: List all employees with their department names using a JOIN.
*Tips*: Use `INNER JOIN`.

3️⃣6️⃣ **Question**: Show all salary records with the corresponding employee names.
*Tips*: Use `JOIN`.

3️⃣7️⃣ **Question**: Display each employee’s salary history.
*Tips*: Use `JOIN`, order by date.

3️⃣8️⃣ **Question**: List all employees along with department name and their salary history.
*Tips*: Multiple `JOIN`s.

---

### ✅ Index Usage

3️⃣9️⃣ **Question**: Check all indexes currently defined in the database.
*Tips*: Use `\di` in psql or query `pg_indexes`.

4️⃣0️⃣ **Question**: Explain how a query plan uses the index on employees.salary.
*Tips*: Use `EXPLAIN ANALYZE`.

4️⃣1️⃣ **Question**: Test the hash index on departments.name with an equality filter.
*Tips*: Use `WHERE name = '...'`.

---

### ✅ Advanced Filters and Subqueries

4️⃣2️⃣ **Question**: Show employees whose salary is in the top 10% of all salaries.
*Tips*: Use percentile or subquery with `ORDER BY`, `LIMIT`.

4️⃣3️⃣ **Question**: Find employees whose salary is below the department median salary.
*Tips*: Use window functions or approximate median.

4️⃣4️⃣ **Question**: List departments with no employees.
*Tips*: Use `LEFT JOIN` and `WHERE ... IS NULL`.

4️⃣5️⃣ **Question**: Show employees who have had multiple salary records (simulate history changes).
*Tips*: Use `GROUP BY employee_id`, `HAVING COUNT() > 1`.

---

### ✅ Data Modification and Design

4️⃣6️⃣ **Question**: Add a new department called 'Legal'.
*Tips*: Use `INSERT`.

4️⃣7️⃣ **Question**: Update Bob’s salary to 80,000.
*Tips*: Use `UPDATE`.

4️⃣8️⃣ **Question**: Delete an employee record by name.
*Tips*: Use `DELETE`.

4️⃣9️⃣ **Question**: Add an index on salaries.effective\_date.
*Tips*: Use `CREATE INDEX`.

5️⃣0️⃣ **Question**: Drop the salaries table.
*Tips*: Use `DROP TABLE`.

---

## 💡 6️⃣ SQL Tips and Hints

✅ Use `JOIN` to combine related tables.

✅ Use `WHERE` to filter rows.

✅ Use `ORDER BY salary DESC` to sort.

✅ Use `DISTINCT` for unique values.

✅ Use aggregate functions like `AVG()`, `SUM()`, `COUNT()`.

✅ Combine `GROUP BY` with aggregates.

✅ Use `HAVING` to filter after grouping.

✅ Use subqueries in `WHERE` or `FROM`.

✅ Use window functions like `RANK() OVER`.

✅ Check existing indexes with `\di` in psql.

✅ Use `EXPLAIN` to see query plans.


---

## ✅ 7️⃣ How to Use This

1. Copy the **CREATE TABLE** and **INSERT** commands into Crunchy Playground.
2. Paste and run them to set up your database.
3. Work through the questions one by one.
4. Use the tips and resources to help you solve them.
5. Save your queries to share with the group!

---

Happy SQL hacking! 🧑‍💻🎯
