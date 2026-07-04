package com.library.repository;

import org.springframework.stereotype.Repository;

// Exercise 6: @Repository annotation
@Repository
public class BookRepository {

    public String findBook(String title) {
        // Simulated database lookup
        System.out.println("[BookRepository] Looking up book: " + title);
        return "Book found: " + title;
    }

    public void saveBook(String title) {
        System.out.println("[BookRepository] Saving book: " + title);
    }
}