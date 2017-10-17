package com.bm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bogdan on 03.10.2017.
 */
public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void add() throws Exception {
        assertEquals(7, calculator.add(3,4));
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(7, calculator.subtract(11,4));
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(12, calculator.multiply(3,4));
    }

    @Test
    public void divide() throws Exception {
        assertEquals(7.0, calculator.divide(14,2), 0.001);
    }

}