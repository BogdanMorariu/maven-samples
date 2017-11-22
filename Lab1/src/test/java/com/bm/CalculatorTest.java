package com.bm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bogdan on 03.10.2017.
 */

//TODO teste diferite pe metode
public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void add() throws Exception {
        assertEquals(7, calculator.calculate(3.0,4.0, "+"), 0.001);
        assertEquals(-1, calculator.calculate(3.0,-4.0, "+"), 0.001);
        assertEquals(7, calculator.calculate(7.0,0.0, "+"), 0.001);
        assertEquals(0, calculator.calculate(0.0,0.0, "+"), 0.001);
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(7, calculator.calculate(11.0,4.0, "-"), 0.001);
        assertEquals(4, calculator.calculate(4.0,0.0, "-"), 0.001);
        assertEquals(-5, calculator.calculate(-1.0,4.0, "-"), 0.001);
        assertEquals(10, calculator.calculate(6.0,-4.0, "-"), 0.001);
        assertEquals(-4, calculator.calculate(0.0,4.0, "-"), 0.001);
        assertEquals(4, calculator.calculate(0.0,-4.0, "-"), 0.001);
        assertEquals(7, calculator.calculate(7.0,0.0, "-"), 0.001);
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(12, calculator.calculate(3.0,4.0, "*"), 0.001);
        assertEquals(-12, calculator.calculate(3.0,-4.0, "*"), 0.001);
        assertEquals(0, calculator.calculate(3.0,0.0, "*"), 0.001);
        assertEquals(0, calculator.calculate(0.0,4.0, "*"), 0.001);
        assertEquals(0, calculator.calculate(0.0,0.0, "*"), 0.001);
    }

    @Test
    public void divide() throws Exception {
        assertEquals(7.0, calculator.calculate(14.0,2.0, "/"), 0.001);
        assertEquals(3.0, calculator.calculate(3.0,1.0, "/"), 0.001);
        assertEquals(3.0, calculator.calculate(12.0,4.0, "/"), 0.001);
        assertEquals(Double.POSITIVE_INFINITY, calculator.calculate(14.0,0.0, "/"), 0.001);
    }

}