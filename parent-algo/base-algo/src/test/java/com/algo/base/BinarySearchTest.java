package com.algo.base;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void testWithRecursion(){
        BinarySearch binarySearch = new BinarySearch();

        int[] array = createArray(100000000);
//        binarySearch.findElementWithRecursion(array, 10);
        binarySearch.findElementWithWhile(array, 90);

//        binarySearch.findElementWithRecursion(array, 0);
        binarySearch.findElementWithWhile(new int [0], 0);

        binarySearch.findElementWithWhile(array, 10000000);
        binarySearch.findElementWithStaightImp(array, 100000000);
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