package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    Calculator calc = new Calculator();

    @Test
    public void testAssertEquals() {
        // assertEquals: checks if two values are equal
        assertEquals(5, calc.add(2, 3));
        assertEquals("Calculator", calc.getName());
    }

    @Test
    public void testAssertTrue() {
        // assertTrue: checks if condition is true
        assertTrue(calc.add(2, 3) > 4);
        assertTrue("Calculator".startsWith("Cal"));
    }

    @Test
    public void testAssertFalse() {
        // assertFalse: checks if condition is false
        assertFalse(calc.add(2, 3) < 3);
        assertFalse("Calculator".isEmpty());
    }

    @Test
    public void testAssertNull() {
        // assertNull: checks if object is null
        assertNull(calc.getNullValue());
    }

    @Test
    public void testAssertNotNull() {
        // assertNotNull: checks if object is NOT null
        assertNotNull(new Calculator());
        assertNotNull(calc.getName());
    }

    @Test
    public void testAssertArrayEquals() {
        // assertArrayEquals: checks if two arrays are equal
        int[] expected = {1, 2, 3};
        int[] actual   = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertSame() {
        // assertSame: checks if both references point to same object
        String s = "hello";
        String ref = s;
        assertSame(s, ref);
    }
}