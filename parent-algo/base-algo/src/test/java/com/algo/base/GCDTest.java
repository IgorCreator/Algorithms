package com.algo.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GCDTest {

    @Test
    public void testGcd(){
        GCD gcd = new GCD();
        assertEquals(4, gcd.findGCD(100,32));
        assertEquals(1, gcd.findGCD(100,33));
        assertEquals(2, gcd.findGCD(33,100));
    }

}