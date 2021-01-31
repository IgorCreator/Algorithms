package com.algo.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    public void testValues(){
        QuickSort algo = new QuickSort();
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(10);
        array.add(90);
        array.add(80);
        array.add(9);
        array.add(7);
        array.add(6);
        array.add(11);
        array.add(70);
        array.add(25);

        System.out.println(algo.sort(array));
    }

}