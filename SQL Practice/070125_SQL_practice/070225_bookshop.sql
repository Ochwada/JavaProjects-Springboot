-- Active: 1751354953874@@127.0.0.1@5432@bookshop

# 
-- ============================================================
-- Database: bookshop
-- Task: Create a new database called bookshop.
-- ============================================================
CREATE DATABASE bookshop;

-- ============================================================
-- Table: authors
-- Purpose: Stores information about book authors
-- Task: Create an authors table with these columns:
-- ============================================================
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,  -- Unique identifier for each author, auto-incremented
    name VARCHAR(255) NOT NULL UNIQUE,  -- Author's name, must be unique and not null
    country VARCHAR(255) NOT NULL -- Author's country of origin, must not be null
);

-- ============================================================
-- Table: books
-- Purpose: Stores information about books available in the shop
-- Task: Create a books table with these columns:
-- ============================================================
# Create a books table with these columns:
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,  -- Unique book identifier, auto-incremented
    title VARCHAR(255) NOT NULL,  -- Title of the book, required
    price NUMERIC(10, 2) CHECK (price >= 0), -- Price of the book, must be non-negative
    stock INT CHECK (stock >= 0), -- Number of copies in stock, must be non-negative
    author_id INT,  -- Foreign key referencing the author of the book
    FOREIGN KEY (author_id) REFERENCES authors(author_id)  -- Link to the authors table
);