package com.algo.base;

import java.util.Arrays;

public class BinarySearch {

    private int i = 0;

    public void findElement(int[] sortedArray, int elementToFind) {
        if(sortedArray.length == 0) {
            System.out.println("Element can't be found in provided array. Amount of tries: " + i);
            return;
        }

        int idxLow = 0;
        int idxHigh = sortedArray.length;
        int mid = idxHigh / 2;

        if (sortedArray[mid] == elementToFind) {
            System.out.println("success, number found. Amount of tries: " + i);
            zeroOutIncrementor();
            return;
        } else if (sortedArray[mid] > elementToFind) {
            idxHigh = mid;
        } else if (sortedArray[mid] < elementToFind) {
            idxLow = mid;
        }

        int[] newArrayAfterCutting = Arrays.copyOfRange(sortedArray, idxLow, idxHigh);
        i++;
        findElement(newArrayAfterCutting, elementToFind);
    }

    private void zeroOutIncrementor(){
        i = 0;
    }

}
