package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        // Load Spring Application Context from XML
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Spring Context Loaded Successfully ===\n");

        // Get the BookService bean (DI already handled by Spring)
        BookService bookService = context.getBean("bookService", BookService.class);

        // Test getBook (will trigger AOP logging)
        System.out.println("\n--- Calling getBook() ---");
        String result = bookService.getBook("Clean Code");
        System.out.println("Result: " + result);

        // Test addBook (will trigger AOP logging)
        System.out.println("\n--- Calling addBook() ---");
        bookService.addBook("Effective Java");

        System.out.println("\n=== Application Finished ===");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}