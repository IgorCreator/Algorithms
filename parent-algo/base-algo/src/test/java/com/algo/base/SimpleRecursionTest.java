package com.algo.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRecursionTest {

    @Test
    public void testRecursion(){
        SimpleRecursion recurs = new SimpleRecursion();
        assertEquals(120, recurs.getFactorial(5));
        assertEquals(3628800, recurs.getFactorial(10));
    }

}