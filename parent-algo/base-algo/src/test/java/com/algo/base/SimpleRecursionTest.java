package com.algo.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRecursionTest {

    @Test
    public void testFactorialRecursion(){
        SimpleRecursion recurs = new SimpleRecursion();
        assertEquals(120, recurs.getFactorial(5));
        assertEquals(3628800, recurs.getFactorial(10));
    }

    @Test
    public void testSumRecursion(){
        int[] array = new int[] {2, 4, 6, 8, 5};
        SimpleRecursion recurs = new SimpleRecursion();
        assertEquals(25, recurs.getSum(array));
        assertEquals(0, recurs.getSum(new int [0]));
    }

    @Test
    public void testSizeRecursion(){
        int[] array = new int[] {2, 4, 6, 8, 5};
        SimpleRecursion recurs = new SimpleRecursion();
        assertEquals(5, recurs.countSize(array));
        assertEquals(0, recurs.countSize(new int [0]));
    }

    @Test
    public void testFindMaxRecursion(){
        int[] array = new int[] {2, 44, 6, 8, 55};
        SimpleRecursion recurs = new SimpleRecursion();
        assertEquals(55, recurs.findMax(array));
        assertEquals(0, recurs.countSize(new int [0]));
    }


}