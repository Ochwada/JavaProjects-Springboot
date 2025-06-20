package com.example.library.infrastructure.Mapper;


import com.example.library.domain.model.Book;
import com.example.library.infrastructure.entity.BookEntity;

/**
 * *******************************************************
 * Package: com.example.library.infrastructure.Mapper
 * File: BookMapper.java
 * Author: Ochwada
 * Date: Friday, 20.Jun.2025, 12:37 PM
 * Description: Utility class for mapping between {@link Book} domain objects and {@link BookEntity} persistence entities
 *  - This class helps to decouple the domain layer from the persistence layer by providing explicit
 *  conversions between models used in the business logic and models used in the database.
 * Objective: Connect Book and BookEntity
 * *******************************************************
 */


public class BookMapper {

    /**
     * Converts a {@link Book} domain object to a {@link BookEntity} JPA entity.
     *
     * @param book the domain model to be converted
     * @return a new {@link BookEntity} with the data copied from the given {@link Book}
     */
    public static BookEntity toEntity(Book book){
        BookEntity entity = new BookEntity();

        entity.setAuthor(book.getAuthor());
        entity.setTitle(book.getTitle());

        return entity;
    }
}
