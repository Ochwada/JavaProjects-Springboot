CREATE DATABASE w3school_db;

CREATE TABLE cars (
    brand VARCHAR(255),
    model VARCHAR(255),
    year INT
);

SELECT * FROM cars;

INSERT INTO
    cars (brand, model, year)
VALUES ('Ford', 'Mustang', 1964);

INSERT INTO
    cars (brand, model, year)
VALUES ('Volvo', 'p1800', 1968),
    ('BMW', 'M1', 1978),
    ('Toyota', 'Celica', 1975);

SELECT * FROM cars;

SELECT brand, year FROM cars;

SELECT * FROM cars;

ALTER TABLE cars ADD color VARCHAR(255);

UPDATE cars SET color = 'red' WHERE model = 'p1800';

UPDATE cars
SEt
    color = 'white',
    year = 1970
WHERE
    model = 'Celica';

ALTER TABLE cars ALTER COLUMN year TYPE VARCHAR(4);

ALTER TABLE cars ALTER COLUMN color TYPE VARCHAR(30);

# Remove the color column
ALTER TABLE cars
DROP COLUMN color;

# Return all records where the brand is NOT 'Volvo':
SELECT * FROM cars
WHERE brand <> 'Volvo';

# Return all records where the model is NULL
SELECT * FROM cars
WHERE model IS NULL;

#Return all records where the brand is NOT present in this list: ('Volvo', 'Mercedes', 'Ford')
SELECT * FROM cars
WHERE brand NOT IN ('Volvo', 'Mercedes', 'Ford');

#Return all records where the model STARTS with a capital 'M
SELECT * FROM cars
WHERE model LIKE 'M%';


#Select all customers where the customer_name field contains at least one 'a' character.
SELECT * 
FROM customers 
WHERE customer_name LIKE '%a%'; # WHERE LOWER(customer_name) LIKE '%a%'

# Return values with no duplicates
SELECT DISTINCT country FROM customers;

#sort results by the year column from newest to oldest, use the ORDER BY clause with DESC (descending order).
SELECT * 
FROM your_table_name 
ORDER BY year DESC;


#the OFFSET keyword is used together with LIMIT to skip a specific number of rows before starting to return the result set.
SELECT * 
FROM table_name
ORDER BY column_name
LIMIT number_of_rows
OFFSET number_of_rows_to_skip;


#SQL statements returns all customers from London?
SELECT * FROM customers 
WHERE city LIKE 'L_nd__';

# operator used to concatenate two fields. : Concatenate means to link or join together,
SELECT product_name || unit AS product
FROM products;


 #Join two tables orders and customers, using the customer_id field in both tables as the relationship between the two tables.

SELECT * FROM orders
LEFT JOIN customers
ON orders.customer_id = customers.id;