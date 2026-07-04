package com.example.junit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AAAPatternTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdd() {
        int a = 10, b = 5;
        int result = calculator.add(a, b);
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        int a = 10, b = 5;
        int result = calculator.subtract(a, b);
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        int a = 4, b = 3;
        int result = calculator.multiply(a, b);
        assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        int a = 10, b = 2;
        int result = calculator.divide(a, b);
        assertEquals(5, result);
    }
}