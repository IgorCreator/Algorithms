package com.algo.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    public void testWithRecursion(){
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.recursionWay(0));
        assertEquals(1, fibonacci.recursionWay(1));
        assertEquals(2, fibonacci.recursionWay(2));
        assertEquals(3, fibonacci.recursionWay(3));
        assertEquals(5, fibonacci.recursionWay(4));
        assertEquals(8, fibonacci.recursionWay(5));
        assertEquals(13, fibonacci.recursionWay(6));
        assertEquals(6765, fibonacci.recursionWay(19));
        assertEquals(10946, fibonacci.recursionWay(20));
    }

    @Test
    public void testWithoutRecurcion(){
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.optimized(0));
        assertEquals(1, fibonacci.optimized(1));
        assertEquals(2, fibonacci.optimized(2));
        assertEquals(3, fibonacci.optimized(3));
        assertEquals(5, fibonacci.optimized(4));
        assertEquals(8, fibonacci.optimized(5));
        assertEquals(13, fibonacci.optimized(6));
        assertEquals(6765, fibonacci.optimized(19));
        assertEquals(10946, fibonacci.optimized(20));
    }

    @Test
    public void testWithDynamicArray(){
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.dynamic(0));
        assertEquals(1, fibonacci.dynamic(1));
        assertEquals(2, fibonacci.dynamic(2));
        assertEquals(3, fibonacci.dynamic(3));
        assertEquals(5, fibonacci.dynamic(4));
        assertEquals(8, fibonacci.dynamic(5));
        assertEquals(13, fibonacci.dynamic(6));
        assertEquals(6765, fibonacci.dynamic(19));
        assertEquals(10946, fibonacci.dynamic(20));
    }

    @Test
    public void testNotEffective(){
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.calculateMyHardWay(0));
        assertEquals(1, fibonacci.calculateMyHardWay(1));
        assertEquals(2, fibonacci.calculateMyHardWay(2));
        assertEquals(3, fibonacci.calculateMyHardWay(3));
        assertEquals(5, fibonacci.calculateMyHardWay(4));
        assertEquals(8, fibonacci.calculateMyHardWay(5));
        assertEquals(13, fibonacci.calculateMyHardWay(6));
        assertEquals(6765, fibonacci.calculateMyHardWay(19));
        assertEquals(10946, fibonacci.calculateMyHardWay(20));
    }

    @Test
    public void printTime(){
        Fibonacci fibonacci = new Fibonacci();
        measure(fibonacci.recursionWay(20), "fibonacci recursion way: ");
        measure(fibonacci.optimized(20), "fibonacci optimized: ");
        measure(fibonacci.dynamic(20), "fibonacci dynamic way: ");
        measure(fibonacci.calculateMyHardWay(20), "fibonacci linked array way: ");
    }

    private void measure(int i, String s) {
        long now;
        long worked;

        now = System.nanoTime();
        System.out.println(i);
        worked = System.nanoTime();
        System.out.println(s + (worked - now));
    }


    private HashMap<String, List<Long>> hashMap = new HashMap<String, List<Long>>(){{
        put("fibonacci recursion way: ", new LinkedList<>());
        put("fibonacci optimized: ", new LinkedList<>());
        put("fibonacci dynamic way: ", new LinkedList<>());
        put("fibonacci linked array way: ", new LinkedList<>());
    }};


    @Test
    public void testTimeWork(){
        Fibonacci fibonacci = new Fibonacci();
        long now;
        long worked;
        int n = 30;

        for (int i = 0; i < 50; i++) {
            now = System.nanoTime();
            fibonacci.recursionWay(n);
            worked = System.nanoTime();
            hashMap.get("fibonacci recursion way: ").add(worked - now);

            now = System.nanoTime();
            fibonacci.optimized(n);
            worked = System.nanoTime();
            hashMap.get("fibonacci optimized: ").add(worked - now);

            now = System.nanoTime();
            fibonacci.dynamic(n);
            worked = System.nanoTime();
            hashMap.get("fibonacci dynamic way: ").add(worked - now);

            now = System.nanoTime();
            fibonacci.calculateMyHardWay(n);
            worked = System.nanoTime();
            hashMap.get("fibonacci linked array way: ").add(worked - now);

        }

        hashMap.forEach((k, v) -> {
            System.out.print(k + ": ");
            System.out.println(" average work time [" + v.stream().mapToLong(i -> i).average().getAsDouble() + "]");
        });

    }
}