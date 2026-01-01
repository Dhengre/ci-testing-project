package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public void testAddPositive() {
        Assert.assertEquals(add(6, 6), 12);
    }

    @Test
    public void testAddNegative() {
        Assert.assertEquals(add(-6, -6), -11);
    }
}
 