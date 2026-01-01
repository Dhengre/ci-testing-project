package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorFailTest {

	Calculator calc = new Calculator();  
    @Test
    public void testMultiplyFail() {
        int expected = 50; // ❌ wrong expectation
        int actual = calc.multiply(5, 4);

        System.out.println("FAIL TEST: Multiplication");
        System.out.println("Expected = " + expected);
        System.out.println("Actual   = " + actual);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddFail() {
        int expected = 20; // ❌ wrong expectation
        int actual = calc.add(10, 5);

        System.out.println("FAIL TEST: Addition");
        System.out.println("Expected = " + expected);
        System.out.println("Actual   = " + actual);

        Assert.assertEquals(actual, expected);
    }
}
