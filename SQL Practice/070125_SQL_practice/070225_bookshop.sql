-- Active: 1751354953874@@127.0.0.1@5432@bookshop
#
-- ============================================================
-- Database: bookshop
-- Task: Create a new database called bookshop.
-- ============================================================
-- CREATE DATABASE bookshop;

DROP TABLE IF EXISTS 
    order_items, 
    orders, 
    books, 
    authors, 
    customers 
CASCADE;
-- ============================================================
-- Table: authors
-- Purpose: Stores information about book authors
-- Task: Create an authors table with these columns:
-- ============================================================
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    -- Unique identifier for each author, auto-incremented
    name VARCHAR(255) NOT NULL UNIQUE,
    -- Author's name, must be unique and not null
    country VARCHAR(255) NOT NULL -- Author's country of origin, must not be null
);
-- ============================================================
-- Table: books
-- Purpose: Stores information about books available in the shop
-- Task: Create a books table with these columns:
-- ============================================================
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    -- Unique book identifier, auto-incremented
    title VARCHAR(255) NOT NULL,
    -- Title of the book, required
    price NUMERIC(10, 2) CHECK (price >= 0),
    -- Price of the book, must be non-negative
    stock INT CHECK (stock >= 0),
    -- Number of copies in stock, must be non-negative
    author_id INT,
    -- Foreign key referencing the author of the book
    FOREIGN KEY (author_id) REFERENCES authors (author_id) -- Link to the authors table
);
-- ============================================================
-- Dummy Data: authors
-- Purpose: Populate authors table with sample entries
-- Task:  Insert at least 5 authors into your authors table.
-- ============================================================
INSERT INTO
    authors (name, country)
VALUES ('Chinua Achebe', 'Nigeria'),
    ('Haruki Murakami', 'Japan'),
    ('Isabel Allende', 'Chile'),
    ('Ngũgĩ wa Thiong''o', 'Kenya'),
    ('Margaret Atwood', 'Canada');
-- ============================================================
-- Dummy Data: books
-- Purpose: Populate books table with sample entries
-- Task:  How would you insert 5 books, including valid author_id, price, and stock values?
-- ============================================================
INSERT INTO
    books (
        title,
        price,
        stock,
,
        author_id
    )
VALUES (
        'Things Fall Apart',
        12.99,
        100,
        1
    ),
    -- Chinua Achebe
    (
        'No Longer at Ease',
        13.50,
        80,
        1
    ),
    -- Chinua Achebe (repeated)
    (
        'Kafka on the Shore',
        15.50,
        75,
        2
    ),
    -- Haruki Murakami
    (
        'The House of the Spirits',
        14.00,
        50,
        3
    ),
    -- Isabel Allende
    (
        'Petals of Blood',
        13.25,
        40,
        4
    ),
    -- Ngũgĩ wa Thiong''o
    (
        'The Handmaid''s Tale',
        16.80,
        60,
        5
    ) ('Extra Book', 10.99, 30, 1);
-- Margaret Atwood
-- ============================================================
-- Table: customers
-- Purpose:Stores information about customers
-- Task: Create a customers table
-- ============================================================
CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    -- Auto-incrementing order ID
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO
    customers (customer_id, name, email)
VALUES (
        1,
        'Alice Johnson',
        'alice@example.com'
    ),
    (
        2,
        'Bob Smith',
        'bob@example.com'
    ),
    (
        3,
        'Charlie Brown',
        'charlie@example.com'
    ),
    (
        4,
        'Dana White',
        'dana@example.com'
    ),
    (
        5,
        'Eve Black',
        'eve@example.com'
    );
-- Correcting code:
ALTER TABLE customers ALTER COLUMN customer_id TYPE INT;
-- ============================================================
-- Table: orders
-- Purpose:Stores information about orders
-- ============================================================
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    -- Auto-incrementing order ID
    customer_id INT,
    -- Foreign key to customers table
    date DATE DEFAULT CURRENT_DATE,
    -- Defaults to current date
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

INSERT INTO
    orders (order_id, customer_id, date)
VALUES (1, 1, '2024-06-01'),
    (2, 2, '2024-06-02'),
    (3, 3, '2024-06-03'),
    (4, 1, '2024-06-04'),
    (5, 4, '2024-06-05');
-- ============================================================
-- Table: order_items
-- Purpose:Stores information about order_items
-- ============================================================
CREATE TABLE order_items (
    order_items_id SERIAL PRIMARY KEY,
    quantity INT CHECK (quantity > 0),
    order_id INT,
    book_id INT,
    FOREIGN KEY (order_id) REFERENCES orders (order_id),
    FOREIGN KEY (book_id) REFERENCES books (book_id)
);

INSERT INTO
    order_items (
        order_items_id,
        order_id,
        book_id,
        quantity
    )
VALUES (1, 1, 1, 2),
    (2, 1, 3, 1),
    (3, 2, 2, 1),
    (4, 2, 4, 2),
    (5, 3, 5, 1),
    (6, 3, 6, 2),
    (7, 4, 3, 1),
    (8, 4, 7, 1),
    --(9, 5, 8, 1),
    (10, 5, 5, 1);
-- ============================================================
-- Index: idx_book_price
-- Purpose: Speeds up queries filtering or sorting by price
-- Applied on: books(price)
-- ============================================================
CREATE INDEX idx_book_price ON books (price);
-- ============================================================
-- Index: idx_customers_email
-- Purpose: Optimizes equality searches on customer emails
-- Note: Uses a HASH index, ideal for `WHERE email = ...` lookups
-- Applied on: customers(email)
-- ============================================================
CREATE INDEX idx_customers_email ON customers USING HASH (email);

-- ============================================================
-- Query: Customer Book Purchase Summary
-- Purpose: Retrieves the name of each customer, the book titles 
--          they purchased, and the quantity for each transaction
-- Tables Involved:
--   - customers: Holds customer personal info
--   - orders: Links each order to a customer
--   - order_items: Associates orders with books and quantity
--   - books: Holds book titles and metadata
-- Output Columns:
--   - customer_name: Name of the customer
--   - book_title: Title of the book purchased
--   - quantity: Number of copies purchased
-- Note: Uses INNER JOINs based on foreign key relationships
-- ============================================================
SELECT 
    c.name AS customer_name, 
    b.title AS book_title, 
    oi.quantity 
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
JOIN order_items oi ON o.order_id = oi.order_id
JOIN books b ON oi.book_id = b.book_id;

-- ============================================================
-- Query: Top Customer by Total Quantity Ordered
-- Purpose: Retrieves the customer who has ordered the most total items
-- Tables involved:
--    - customers: to get customer names
--    - orders: to find orders made by customers
--    - order_items: to count the quantity of books per order
-- Logic:
--    - Join customers to orders and order_items
--    - Sum total quantity for each customer
--    - Sort descending to get the top customer
--    - Limit to 1 result for top performer
-- ============================================================
SELECT
    c.name AS customer_name,
    SUM(oi.quantity) AS total_quantity
FROM customers c 
JOIN orders o ON c.customer_id = o.customer_id 
JOIN order_items oi ON o.order_id = oi.order_id 
GROUP BY c.customer_id, c.name
ORDER BY total_quantity DESC
LIMIT 1;

-- ============================================================
-- Query: Average Book Price
-- Purpose: Calculates the average price of all books in the shop
-- Note: Uses ROUND to limit to 2 decimal places for readability
-- ============================================================
SELECT ROUND(AVG(price), 2) AS average_price 
FROM books; 

-- ============================================================
-- Query: Most Prolific Authors
-- Purpose: Lists authors and the number of books they've written
-- Sorts: From most to least books
-- Note: Joins 'authors' and 'books' using author_id
-- ============================================================
SELECT 
    a.name AS author_name,
    COUNT(b.book_id) AS total_books
FROM authors a 
JOIN books b ON a.author_id = b.author_id
GROUP BY a.name
ORDER BY total_books DESC; 

-- ============================================================
-- Query: Low Inventory Alert
-- Purpose: Lists books with dangerously low stock levels
-- Condition: stock < 3
-- Output: Book title and current stock
-- ============================================================
SELECT  title, stock
     FROM books
WHERE stock < 3;


-- ============================================================
-- Query: Order Total Price Summary
-- Purpose: Calculates the total price for each order
-- Logic:
--   - Joins `orders`, `order_items`, and `books`
--   - Multiplies quantity by book price
--   - Aggregates by order_id to compute the total per order
-- Output:
--   - order_id: Unique identifier of the order
--   - total_price: Sum of (quantity × price) for each book in the order
-- ============================================================
SELECT 
    o.order_id AS order_id,
    SUM(oi.quantity * b.price) AS total_price
FROM orders o
JOIN order_items oi ON o.order_id = oi.order_id
JOIN books b ON oi.book_id = b.book_id
GROUP BY o.order_id
ORDER BY o.order_id;
