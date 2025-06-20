package com.example.library.domain.port;


import com.example.library.domain.model.Book;

import java.util.List;

/**
 * *******************************************************
 * Package: com.example.library.domain.port
 * File: BookService.java
 * Author: Ochwada
 * Date: Friday, 20.Jun.2025, 12:17 PM
 * Description: Port for book-related operations (Primary Port)
 * - Service interface for managing {@link Book} entities.
 * - Provides abstract methods for adding a new book and retrieving all books from the data source.
 * Objective:
 * *******************************************************
 */


public interface BookService {


    /**
     * Adds a new book to the system.
     *
     * @param book the {@link Book} object to be added
     * @return the saved {@link Book} instance, typically with a generated ID
     */
    Book addBook(Book book);


    /**
     * Retrieves all books currently stored in the system.
     *
     * @return a list of all {@link Book} records
     */
    List<Book> getAllBooks();
}
