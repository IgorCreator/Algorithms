package com.algo.base;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void testWithRecursion(){
        BinarySearch binarySearch = new BinarySearch();

        int[] array = createArray(100);
        binarySearch.findElement(array, 10);
        binarySearch.findElement(array, 90);
        binarySearch.findElement(array, 0);
        binarySearch.findElement(new int [0], 0);
    }

    private int[] createArray(int elementsInArray) {
        int[] res = new int[elementsInArray];
        for (int i = 0; i < elementsInArray; i++)
        {
            res[i] = i + 1;
        }
        return res;
    }

}