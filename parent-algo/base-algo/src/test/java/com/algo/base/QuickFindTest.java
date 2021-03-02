package com.algo.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickFindTest {

    @Test
    public void testQuickFind(){
        QuickFind qFind = new QuickFind(10);

        qFind.union(1, 4);
        qFind.union(4, 5);
        assertTrue(qFind.connected(1, 5));

        qFind.union(6, 2);
        qFind.union(2, 3);
        qFind.union(3, 7);
        assertTrue(qFind.connected(6, 7));

        assertFalse(qFind.connected(0, 8));
        assertFalse(qFind.connected(5, 6));
    }

}