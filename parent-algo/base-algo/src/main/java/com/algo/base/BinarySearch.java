package com.algo.base;

import java.util.Arrays;

public class BinarySearch {

    private int i = 0;

    public void findElementWithRecursion(int[] sortedArray, int elementToFind) {
        if(sortedArray.length == 0) {
            System.out.println("Element can't be found in provided array. Amount of tries: " + i);
            zeroOutIncrementor();
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
        findElementWithRecursion(newArrayAfterCutting, elementToFind);
    }

    public void findElementWithWhile(int[] sortedArray, int elementToFind) {
        if(sortedArray.length == 0) {
            System.out.println("Element can't be found in provided array. Amount of tries: " + i);
            zeroOutIncrementor();
            return;
        }

        int idxLow = 0;
        int idxHigh = sortedArray.length;


        while (idxLow <= idxHigh){
            i++;
            int mid = (idxLow + idxHigh) / 2;
            if (sortedArray[mid] == elementToFind) {
                System.out.println("success, number found. Amount of tries: " + i);
                zeroOutIncrementor();
                return;
            } else if (sortedArray[mid] > elementToFind) {
                idxHigh = mid - 1 ;
            } else if (sortedArray[mid] < elementToFind) {
                idxLow = mid + 1;
            } else {
                System.out.println("Element can't be found in provided array. Amount of tries: " + i);
                zeroOutIncrementor();
                return;
            }
        }
    }

    private void zeroOutIncrementor(){
        i = 0;
    }

    public void findElementWithStaightImp(int[] sortedArray, int elementToFind) {
        for (int elem : sortedArray) {
            i++;
            if(elem == elementToFind){
                System.out.println("Found. Amount of tries: " + i);
                zeroOutIncrementor();
                return;
            }
        }
    }

}
