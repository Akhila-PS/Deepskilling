package com.example.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    Calculator calc = new Calculator();

    @Test
    public void testAssertEquals() {
        assertEquals(5, calc.add(2, 3));
        assertEquals("Calculator", calc.getName());
    }

    @Test
    public void testAssertTrue() {
        assertTrue(calc.add(2, 3) > 4);
        assertTrue("Calculator".startsWith("Cal"));
    }

    @Test
    public void testAssertFalse() {
        assertFalse(calc.add(2, 3) < 3);
        assertFalse("Calculator".isEmpty());
    }

    @Test
    public void testAssertNull() {
        assertNull(calc.getNullValue());
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Calculator());
        assertNotNull(calc.getName());
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual   = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAssertSame() {
        String s = "hello";
        String ref = s;
        assertSame(s, ref);
    }
}