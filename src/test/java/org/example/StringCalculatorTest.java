package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testEmptyString(){
        assertEquals(0, stringCalculator.add(""));
    }
}
