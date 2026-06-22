package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Exercise 6: @Service annotation
@Service
public class BookService {

    private BookRepository bookRepository;

    // Exercise 7: Constructor Injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Initialized via Constructor Injection");
    }

    // Exercise 2 & 7: Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] BookRepository injected via Setter");
    }

    public String getBook(String title) {
        System.out.println("[BookService] getBook() called for: " + title);
        return bookRepository.findBook(title);
    }

    public void addBook(String title) {
        System.out.println("[BookService] addBook() called for: " + title);
        bookRepository.saveBook(title);
    }
}