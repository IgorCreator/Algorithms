package com.algo.base;

public class QuickUnionWeighted {

    int[] array;
    int[] size; // count number of objects in the tree;

    //Running time init: N
    public QuickUnionWeighted(int elements) {
        this.array = new int[elements];
        this.size = new int[elements];

        for (int i = 0; i < elements; i++) {
            array[i] = i;
            size[i] = i;
        }
    }

    //Running time union: lg N
    public void union(int child, int parent){
        if(child > count() || parent > count() || child < 0 || parent < 0){
            throw new IllegalArgumentException("element can't be found in array");
        }
        int i = root(child);
        int j = root(parent);

        if(i == j) return;
        if(size[i] < size[j]) {array[i] = j; size[j] += size[i];}
        else {array[j] = i; size[i] += size[j];}
    }

    //Running time connected: lg N
    protected boolean connected(int nodeA, int pointB){
        if(nodeA > count() || pointB > count() || nodeA < 0 || pointB < 0){
            throw new IllegalArgumentException("element can't be found in array");
        }
        return root(nodeA) == root(pointB);
    }

    private int root(int val) {
        while (val != array[val]) {
            // implementation of the path compression: point every other node to grandparent
            // halving the path length -> tree almost completely flat
            // it give as running time in lg* N - very efficient find func
            array[val] = array[array[val]];
            val = array[val];
        }
        return val;
    }

    private int count(){
        return array.length;
    }
}
