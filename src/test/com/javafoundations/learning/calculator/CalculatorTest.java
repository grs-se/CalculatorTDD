package com.javafoundations.learning.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    // JUnit test methods have to follow signature: have to be public and void
    // Test decorator has been dropped in new Junit versions

    // TDD - Let tests drive the code we write for actual program
    // write tests first
    // test code and program code
    // test folder and main folder

    // an annotation = metadata for a method, field or param
    // Junit looks for methods annotated with Test (on or above method)
    @Test
    public void canAddZeroPlusZero() {
        Calculator calc = new Calculator();
        int sum = calc.add(0, 0);
        // junit:
        // we expect (assert) the sum = 0
        assertEquals(0, sum, "Was expecting sum of 0");
    }

    // One principle in TDD is that we don't write anymore code than our test demands of us
    // basic idea of test is setting up a scenario (a calculator) and we need to assert that 0 + 0 = 0
}
