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
        assertEquals(-1, calculator.add(3,-4));
        assertEquals(7, calculator.add(7,0));
        assertEquals(0, calculator.add(0,0));
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(7, calculator.subtract(11,4));
        assertEquals(4, calculator.subtract(4,0));
        assertEquals(-5, calculator.subtract(-1,4));
        assertEquals(10, calculator.subtract(6,-4));
        assertEquals(-4, calculator.subtract(0,4));
        assertEquals(4, calculator.subtract(0,-4));
        assertEquals(7, calculator.subtract(7,0));
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(12, calculator.multiply(3,4));
        assertEquals(-12, calculator.multiply(3,-4));
        assertEquals(0, calculator.multiply(3,0));
        assertEquals(0, calculator.multiply(0,4));
        assertEquals(0, calculator.multiply(0,0));
    }

    @Test
    public void divide() throws Exception {
        assertEquals(7.0, calculator.divide(14,2), 0.001);
        assertEquals(3.0, calculator.divide(3,1), 0.001);
        assertEquals(3.0, calculator.divide(12,4), 0.001);
        try{
            assertEquals(7.0, calculator.divide(14,0), 0.001);
            assertTrue(false);
        }catch (ArithmeticException ignored){
        }
    }

}