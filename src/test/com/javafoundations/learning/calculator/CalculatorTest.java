package com.javafoundations.learning.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    // 1st approach:
    // One instance of this field, all test methods use the same instance of the calculator
    // important to be mindful of as if the calculator class was capable of maintaining state (i.e. storing values), the act of storing values in it could affect subsequent calculations
    // Not necessarily a bad approach though, in this example more efficient, specifically because the calculator does not maintain state
    // private final Calculator calc = new Calculator();

    // 2nd approach:
    // If the calculator did maintain state and we wanted to ensure that on each test method we got a brand new pristine calculator method each time, then using the setup() method would be smarter way
    // setup() clears things out beforeEach test.
    private Calculator calc;
    // JUnit test methods have to follow signature: have to be public and void
    // Test decorator has been dropped in new Junit versions

    // TDD - Let tests drive the code we write for actual program
    // write tests first
    // test code and program code
    // test folder and main folder

    // Annotation specific to Junit: annotate void methods to be run before any test methods
    // junit finds all tests annotated with Test, but then run BeforeEach method first before each test method
    // Java's garbage collector can reclaim memory of first instance of Calculator after it has been 'orphaned' by first test, etc
    // doesn't necessarily mean that the memory will be reclaimed but flags it as being eligible for garbage collection
    // the first instance of the calculator that was created before the first test was run would now become de-referenced, meaning htere is no variable that is referrering to it anymore, and a new caculator isntance is created and pointed to by this same field variable, and then the 2nd method refers to that.
    //
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    // an annotation = metadata for a method, field or param
    // Junit looks for methods annotated with Test (on or above method)
    @Test
    public void canAddZeroPlusZero() {
        int sum = calc.add(0, 0);
        // junit:
        // we expect (assert) the sum = 0
        assertEquals(0, sum, "Was expecting sum of 0");
    }

    // One principle in TDD is that we don't write anymore code than our test demands of us
    // basic idea of test is setting up a scenario (a calculator) and we need to assert that 0 + 0 = 0

    @Test
    public void canAddOnePlusOne() {
        int sum = calc.add(1, 1);
        assertEquals(2, sum);
    }

    @Test
    public void canAddOnePlusMinusOne() {
        int sum = calc.add(1, -1);
        assertEquals(0, sum);
    }

    @Test
    public void canAddMinusOnePlusMinusOne() {
        int sum = calc.add(-1, -1);
        assertEquals(-2, sum);
    }

    // Unit tests are only as good as the scenarios you can think of
    // why companies hire dedicated testers to think of scenarios

    // duplication of code bad in test code as well as production code

    ////////////
    // EDGE CASES
    ////////////
    // What would happen if we were to pass in the largest number that an integer can hold in Java + 1 or 2?
    /*
    @Test
    // @Ignore prior to junit version 5
    @Disabled // disables test from running // DISABLED NOT WORKING!?
    public void canAddMaxIntPlusOne() {
        int sum = calc.add(Integer.MAX_VALUE, 1); // = -2147483648 not 2147483647 as expected
        // We're assuming that adding 1 to this interger value is going to do what we think it's going to do
        // we might just be doubling down on logic that is faulty
        // printing out we get the wrong sign, it's negative:
        // so our unit tests are only as good as the scenarios we can think of
        // and our unit tests are only as good as the assumptions of what we can expect
        // Signed Integer can hold up to 32-bit or [-2.147.483.648 to 2.147.483.647]
        // Unsigned is [0 - 4294967295]
        // Integer.MAX_VALUE is 2147483647
        // Integer.MIN_VALUE is -2147483648
        System.out.println(sum);
//        assertEquals(Integer.MAX_VALUE + 1, sum);
        // since we only have 32 bits available to use and the most significant bit for an integer is used for a sign
        // what happens when you take the largest number that you can hold for an integer and then add 1 more to it?
        // you run up against the edge of the 32 bits and the sign flips to negative
        // so we can force the JVM to tdo this math with more bits by makign one of these numbers not be a int
        assertEquals(Integer.MAX_VALUE + 1L, sum);
        // THINK OF TRUE EDGE CASES and then be very careful about how you test these
        // print out the values
    }
     */

    ////////////
    // TESTING ANNUITY CALCULATION
    ////////////
    @Test
    public void annuityExample() {
        String answer = calc.calcAnnuity("22000", 7, ".06", 1);
    assertEquals("£184,664.43", answer);
    }

    @Test
    public void annuityPractice2() {
        String answer = calc.calcAnnuity("1200", 10, ".08", 4);
        assertEquals("£72,482.38", answer);
    }

}
