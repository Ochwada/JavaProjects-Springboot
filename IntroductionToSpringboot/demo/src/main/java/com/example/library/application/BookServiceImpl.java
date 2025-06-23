package com.example.library.application;


import com.example.library.domain.model.Book;
import com.example.library.domain.port.BookService;
import com.example.library.infrastructure.entity.BookEntity;
import com.example.library.infrastructure.mapper.BookMapper;
import com.example.library.infrastructure.repository.BookJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * *******************************************************
 * Package: com.example.library.application
 * File: BookServiceImpl.java
 * Author: Ochwada
 * Date: Monday, 23.Jun.2025, 7:59 AM
 * Description:  Implementation of the {@link BookService} interface that provides core business logic
 * * for managing books. This service interacts with the persistence layer via
 * * {@link BookJpaRepository} and uses {@link BookMapper} for entity-model conversion.
 * <p>
 * * This class is annotated with {@code @Service}, making it a candidate for
 * * component scanning and dependency injection in Spring applications.
 * Objective:
 * *******************************************************
 */

@Service //
public class BookServiceImpl implements BookService {
    /**
     * private final BookJpaRepository repository;
     * <p>
     * public BookServiceImpl(BookJpaRepository repository){
     * this.repository = repository;
     * }
     * <p>
     * The above is called Constructor Injection (Best Practice)
     * Spring will inject BookJpaRepository automatically
     */
    private final BookJpaRepository repository;

    /**
     * Constructs a new {@code BookServiceImpl} with the specified repository.
     * <p>
     * This is an example of <strong>constructor injection</strong>, which is considered
     * a best practice in Spring for ensuring immutability and easier testing.
     * </p>
     *
     * @param repository the JPA repository to be injected by Spring
     */
    public BookServiceImpl(BookJpaRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves a new book in the repository.
     *
     * @param book the {@link Book} object to be added
     * @return the saved {@link Book} model, mapped from the persisted entity
     */
    @Override
    public Book addBook(Book book) {
        BookEntity entity = repository.save(BookMapper.toEntity(book));
        return BookMapper.toModel(entity);
    }

    /**
     * Retrieves all books from the repository.
     *
     * @return a list of {@link Book} objects mapped from the entity list
     */
    @Override
    public List<Book> getAllBooks() {
        return repository.findAll().stream()
                .map(BookMapper::toModel)
                .collect(Collectors.toList());
    }
}
