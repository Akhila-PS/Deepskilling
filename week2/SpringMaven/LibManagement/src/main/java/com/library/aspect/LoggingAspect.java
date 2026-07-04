package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

// Exercise 3 & 8: AOP Logging Aspect
@Aspect
@Component
public class LoggingAspect {

    // Exercise 8: Before advice — runs before any method in com.library
    @Before("execution(* com.library.*.*(..))")
    public void logBefore() {
        System.out.println("[LoggingAspect] --- Method execution starting ---");
    }

    // Exercise 8: After advice — runs after any method in com.library
    @After("execution(* com.library.*.*(..))")
    public void logAfter() {
        System.out.println("[LoggingAspect] --- Method execution finished ---");
    }

    // Exercise 3: Around advice — logs execution time
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("[LoggingAspect] Starting: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed(); // execute the actual method

        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println("[LoggingAspect] Finished: " + joinPoint.getSignature().getName()
                + " | Time taken: " + timeTaken + "ms");

        return result;
    }
}