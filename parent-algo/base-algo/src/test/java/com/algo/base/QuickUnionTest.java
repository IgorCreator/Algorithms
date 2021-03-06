package com.algo.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickUnionTest {

    @Test
    public void runTests() {
        //makeSimpleQuickUnion();
        makeWeightedQuickUnion();
    }

    private void makeSimpleQuickUnion() {
        QuickUnion qUnion = new QuickUnion(10);

        qUnion.union(4, 3);
        qUnion.union(3, 8);

        qUnion.union(6, 5);
        qUnion.union(9, 4);

        qUnion.union(5, 0);
        qUnion.union(0, 1);
        qUnion.union(2, 1);
        qUnion.union(7, 2);

        qUnion.union(9, 8);
        qUnion.union(7, 3);

        int[] expectedArray = new int[]{1, 8, 1, 8, 3, 0, 5, 1, 8, 8};
        for (int i = 0; i < qUnion.array.length; i++) {
            System.out.println("node: " + i + " parent: " + qUnion.array[i]);
            assertEquals(expectedArray[i], qUnion.array[i]);
        }
    }

    private void makeWeightedQuickUnion() {
        QuickUnionWeighted qUnion = new QuickUnionWeighted(10);

        qUnion.union(4, 3);
        qUnion.union(3, 8);
        qUnion.union(6, 5);
        qUnion.union(9, 4);
        qUnion.union(2, 1);
        qUnion.union(5, 0);
        qUnion.union(7, 2);
        qUnion.union(6, 1);  // mergin of the equal trees
        qUnion.union(7, 3);  // smaller tree - goes below bigger

        int[] expectedArray = new int[]{6, 7, 7, 8, 8, 6, 8, 6, 8, 8};
        for (int i = 0; i < qUnion.array.length; i++) {
            System.out.println("node: " + i + " parent: " + qUnion.array[i]);
            assertEquals(expectedArray[i], qUnion.array[i]);
        }
    }
}