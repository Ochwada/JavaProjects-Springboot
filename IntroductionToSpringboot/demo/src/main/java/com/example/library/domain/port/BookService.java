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
 * Objective:
 * *******************************************************
 */


public interface BookService {
 Book addBook(Book book);
 List<Book> getAllBooks();
}
