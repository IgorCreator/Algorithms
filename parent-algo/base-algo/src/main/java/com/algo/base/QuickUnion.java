package com.algo.base;

public class QuickUnion {

    int[] array;

    public QuickUnion(int elements) {
        this.array = new int[elements];

        for (int i = 0; i < elements; i++)
            array[i] = i;
    }

    public void union(int child, int parent){
        if(child > count() || parent > count() || child < 0 || parent < 0){
            throw new IllegalArgumentException("element can't be found in array");
        }
        int i = root(child);
        int j = root(parent);
        array[i] = j;

    }

    private int root(int val) {
        while (val != array[val]) val = array[val];
        return val;
    }

    protected boolean connected(int pointA, int pointB){
        if(pointA > count() || pointB > count() || pointA < 0 || pointB < 0){
            throw new IllegalArgumentException("element can't be found in array");
        }
        return find(pointA) == find(pointB);
    }

    private int find(int point){
        return array[point];
    }

    private int count(){
        return array.length;
    }
}