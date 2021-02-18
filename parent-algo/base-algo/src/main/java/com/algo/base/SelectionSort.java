package com.algo.base;

import java.util.ArrayList;

public class SelectionSort {

    public ArrayList<Integer> sortList(ArrayList<Integer> unsorted){
        if(unsorted.size() == 0){
            System.out.println("Empty input array");
            return null;
        }

        ArrayList<Integer> sortedList = new ArrayList<>();
        int steps = unsorted.size();
        for (int i = 0; i < steps; i++) {
            Integer minElement = findSmallest(unsorted);
            sortedList.add(minElement);
            unsorted.remove(minElement);
        }

        return sortedList;
    }

    private Integer findSmallest(ArrayList<Integer> unsorted) {
        Integer minElement = unsorted.get(0);
        for (int i = 1; i < unsorted.size(); i++) {
            if(minElement > unsorted.get(i)){
                minElement = unsorted.get(i);
            }
        }
        return minElement;
    }

    void sortArray(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

}
