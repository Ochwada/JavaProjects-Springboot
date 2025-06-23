package com.example.library.api;


import com.example.library.domain.model.Book;
import com.example.library.domain.port.BookService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * *******************************************************
 * Package: com.example.library.api
 * File: BookController.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 7:35 AM
 * Description:  REST controller for managing books in the library.
 *   * This controller exposes endpoints to create and retrieve books via HTTP.
 * Objective:
 * *******************************************************
 */
@RestController
@RequestMapping("/api/books")

public class BookController {

    private final BookService service;

    /**
     * Constructs a new {@code BookController} with the given {@code BookService}.
     *
     * @param service the service layer for book operations
     */
    public BookController(BookService service) {
        this.service = service;
    }

    /**
     * Adds a new book to the library.
     *
     * @param book the {@link Book} object to be added (must be valid)
     * @return a {@link ResponseEntity} containing the created {@code Book} and HTTP status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book){
        return new ResponseEntity<>(service.addBook(book), HttpStatus.CREATED);
    }

    /**
     * Retrieves all books currently in the library.
     *
     * @return a list of all {@link Book} objects
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
}
