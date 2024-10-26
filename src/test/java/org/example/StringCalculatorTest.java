package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void terminate(){
        stringCalculator = null;
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testAddingOneNumber() {
        assertEquals(7, stringCalculator.add("7"));
    }

    @Test
    public void testAddingMultipleNumbers() {
        assertEquals(10, stringCalculator.add("4,6"));
    }

    @Test
    public void testNegativeNumber() throws IllegalArgumentException {
        try {
            String[] array = {"2", "-5"};
            stringCalculator.sum(array);
        } catch (IllegalArgumentException exception) {
            assertEquals(exception.getMessage(), "Negative numbers not allowed: -5");
        }
    }

    @Test
    public void testDelimiters() {
        assertEquals(7, stringCalculator.add("//;\n3;4"));
    }
}
