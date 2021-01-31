package com.algo.base;

import java.util.ArrayList;

public class QuickSort {

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        if (array.size() < 1) return array;

        int pivot = array.get(0);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        for (int j = 1; j < array.size(); j++) {
            Integer elem = array.get(j);
            if (elem < pivot) {
                less.add(elem);
            } else {
                greater.add(elem);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(sort(less));
        res.add(pivot);
        res.addAll(sort(greater));
        return res;
    }
}
