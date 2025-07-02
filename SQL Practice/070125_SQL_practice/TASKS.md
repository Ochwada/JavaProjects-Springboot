# SQL Practice

Hey clever team !

By now you’ll build your **own PostgreSQL schema** for a *Book Selling* Shop using **pure SQL**.

You can do this in:
 - CrunchyData Playground / or locally in `psql`  terminal 

Your job: Write SQL queries to answer **all 15 tasks below to be done by 1 pm**

### Task 1: Create a new database called `bookshop`.
 >Q: How would you create a new database called `bookshop`?

### Task 2: Create an authors table with these columns:
- `author_id` (primary key, auto-increment)
- `name` (unique, not null)
- `country` (not null)
 >Q: Write SQL to create this table with the constraints described.


### Task 3: Create a books table with these columns:
- `book_id` (primary key)
- `title` (not null)
- `price` (cannot be negative)
- `stock` (cannot be negative)
- `author_id` (foreign key to authors)
> Q: Write SQL to create this table with all constraints.

### Task 4: Insert at least 5 authors into your `authors` table.
 >Q: How would you insert 5 real-looking authors with country names?

### Task 5: Insert at least 5 books linked to those `authors`.
>  Q: How would you insert 5 books, including valid `author_id`, `price`, and `stock` values?

### Task 6:  Create a `customers` table:
- `customer_id` (primary key)
- `name` (not null)
- `email` (unique, not null)
 >Q: Write SQL to create this table with constraints.

### Task 7: Insert at least 5 customers.
 > Q: How would you insert 5 customers with unique email addresses?


 ### Task 8: Create an `orders` table and an `order_items` table with these features:
- `orders`: 
    - primary key, 
    - foreign key to customers, 
    - date with default current date
- `order_items`: 
    - primary key, 
    - foreign keys to orders and books, 
    - quantity with check (>0)
> Q: Write the SQL for both tables with constraints.

### Task 9: Create indexes on columns to improve lookups
- Create a BTREE index on `books.price` to speed up price-range searches.
- Create a HASH index on `customers.email` to speed up exact email lookups.
> Q: How would you create these two indexes in SQL?

### Task 10: Write a SELECT query to show:
- The customer name
- The book title they bought
- The quantity they bought
 > Q: How would you join the right tables to get this result?

### Task 11:
 > Q: Which customer ordered the most total books?
- Write a query that returns the customer name and total quantity ordered, sorted to show the top customer.


### Task 12:
 > Q: What is the average price of all books in the shop?
 - Write a query that calculates and returns the average price.

 ### Task 13:
 > Q: Which author has written the most books in your shop?
- Write a query showing author name and number of books they have in the database, sorted descending.

 ###  Task 14:
 > Q: List all books with stock less than 3 (low inventory alert).
- Write a query returning book titles and stock values for low inventory.

### Task 15:
 > Q: Show all orders with the total price per order.
-  Write a query joining orders, order_items, and books to show order ID and total price (sum of quantity * book price).