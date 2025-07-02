# SQL Practice

Hey clever team !

By now you’ll build your **own PostgreSQL schema** for a *Book Selling* Shop using **pure SQL**.

You can do this in:
 - CrunchyData Playground / or locally in `psql`  terminal 

Your job: Write SQL queries to answer **all 15 tasks below to be done by 1 pm**

#### Task 1: Create a new database called `bookshop`.
 >Q: How would you create a new database called `bookshop`?

#### Task 2: Create an authors table with these columns:
- `author_id` (primary key, auto-increment)
- `name` (unique, not null)
- `country` (not null)
 >Q: Write SQL to create this table with the constraints described.


#### Task 3: Create a books table with these columns:
- `book_id` (primary key)
- `title` (not null)
- `price` (cannot be negative)
- `stock` (cannot be negative)
- `author_id` (foreign key to authors)
> Q: Write SQL to create this table with all constraints.