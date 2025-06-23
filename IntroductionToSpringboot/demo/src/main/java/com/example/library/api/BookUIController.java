package com.example.library.api;


import com.example.library.domain.model.Book;
import com.example.library.domain.port.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *******************************************************
 * Package: com.example.library.api
 * File: BookUIController.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 7:53 AM
 * Description: Controller for handling UI interactions related to books using Thymeleaf views.
 *  * This controller manages GET and POST requests for the book form and delegates
 *  * the business logic to {@link BookService}.
 * Objective:
 * *******************************************************
 */

@Controller
@RequestMapping("/ui/books")
public class BookUIController {
    private final BookService service;

    /**
     * Constructs a new {@code BookUIController} with the given {@code BookService}.
     *
     * @param service the service layer to manage book operations
     */
    public BookUIController(BookService service) {
        this.service = service;
    }

    /**
     * Displays the book form along with a list of all existing books.
     *
     * @param model the model to hold attributes for the Thymeleaf view
     * @return the name of the Thymeleaf template to render ("index")
     */
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "index";
    }

    /**
     * Handles submission of the book form and adds a new book.
     *
     * @param book the {@link Book} submitted from the form (must be valid)
     * @return a redirect to the book form page to display the updated list
     */
    @PostMapping
    public String submitForm(@ModelAttribute @Valid Book book) {
        service.addBook(book);
        return "redirect:/ui/books";
    }
}
