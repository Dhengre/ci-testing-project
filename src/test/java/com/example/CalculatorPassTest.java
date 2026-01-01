package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPassTest {

    Calculator calc = new Calculator();
 
    @Test
    public void testAdd() {
        int expected = 8;
        int actual = calc.add(5, 5);

        System.out.println("PASS TEST: Addition");
        System.out.println("Expected = " + expected);
        System.out.println("Actual   = " + actual);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSubtract() {
        int expected = 4;
        int actual = calc.subtract(7, 1);

        System.out.println("PASS TEST: Subtraction");
        System.out.println("Expected = " + expected);
        System.out.println("Actual   = " + actual);

        Assert.assertEquals(actual, expected);
    }
 
    @Test
    public void testDivide() {
        int expected = 5;
        int actual = calc.divide(9, 2);

        System.out.println("PASS TEST: Division");
        System.out.println("Expected = " + expected);
        System.out.println("Actual   = " + actual);

        Assert.assertEquals(actual, expected);
    }
}
