package com.algo.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickUnionTest {

    @Test
    public void main() {
        QuickUnion qUnion = new QuickUnion(10);

        qUnion.union(6, 5);
        qUnion.union(5, 0);
        qUnion.union(0, 1);
        qUnion.union(2, 1);
        qUnion.union(7, 1);
        qUnion.union(4, 3);
        qUnion.union(3, 8);
        qUnion.union(9, 8);
        qUnion.union(1, 8);

        int[] expectedArray = new int[]{1, 8, 1, 8, 3, 0, 5, 1, 8, 8};
        for (int i = 0; i < qUnion.array.length; i++) {
            System.out.println(" i: " + i + " id: " + qUnion.array[i]);
            assertEquals(expectedArray[i], qUnion.array[i]);
        }
    }
}