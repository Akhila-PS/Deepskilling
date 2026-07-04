package com.example.SLF4JLogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");

        String user = "Akhila";
        int code = 404;
        logger.error("User {} encountered error code {}", user, code);
        logger.warn("User {} has low disk space", user);
    }
}