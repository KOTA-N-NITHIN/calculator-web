package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorControllerUnitTests {

    private CalculatorController controller;

    @BeforeEach
    void setup() {
        controller = new CalculatorController();
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, add, 8",
        "10, 4, subtract, 6",
        "6, 7, multiply, 42",
        "20, 4, divide, 5",
        "10, 0, divide, 0",
        "10, 5, mod, 0"  // unknown operation returns 0
    })
    void testOperations(double num1, double num2, String op, double expected) {
        assertEquals(expected, controller.compute(num1, num2, op));
    }

    @Test
    void testDivideByZero() {
        assertEquals(0.0, controller.compute(10, 0, "divide"));
    }
}
