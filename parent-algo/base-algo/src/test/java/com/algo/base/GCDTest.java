package com.algo.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GCDTest {

    @Test
    public void testGcd(){
        GCD gcd = new GCD();
        assertEquals(4, gcd.findGCD(100,32));
        assertEquals(1, gcd.findGCD(100,33));
        assertEquals(1, gcd.findGCD(33,100));
        assertEquals(12, gcd.findGCD(24,12));
        assertEquals(1, gcd.findGCD(5612,15897));
    }

}