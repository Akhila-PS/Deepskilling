package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.spring_learn.Country;  // Important Import

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        logger.info("Starting SpringLearnApplication...");
        SpringApplication.run(SpringLearnApplication.class, args);
        
        displayCountry();   // Call the method
        
        logger.info("SpringLearnApplication started successfully!");
    }

    public static void displayCountry() {
        logger.info("Inside displayCountry() method");

        // Load Spring XML Configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Get the bean from XML
        Country country = (Country) context.getBean("country", Country.class);

        logger.debug("Country : {}", country.toString());
    }
}