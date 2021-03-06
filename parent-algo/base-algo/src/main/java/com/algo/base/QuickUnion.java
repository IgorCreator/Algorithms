package com.algo.base;

public class QuickUnion {

    int[] array;

    //Running time init: N
    public QuickUnion(int elements) {
        this.array = new int[elements];

        for (int i = 0; i < elements; i++)
            array[i] = i;
    }

    //Running time union: N
    public void union(int child, int parent){
        if(child > count() || parent > count() || child < 0 || parent < 0){
            throw new IllegalArgumentException("element can't be found in array");
        }
        int i = root(child);
        int j = root(parent);
        array[i] = j;

    }

    //Running time connected: N
    protected boolean connected(int nodeA, int pointB){
        if(nodeA > count() || pointB > count() || nodeA < 0 || pointB < 0){
            throw new IllegalArgumentException("element can't be found in array");
        }
        return root(nodeA) == root(pointB);
    }

    private int root(int val) {
        while (val != array[val]) val = array[val];
        return val;
    }

    private int count(){
        return array.length;
    }
}