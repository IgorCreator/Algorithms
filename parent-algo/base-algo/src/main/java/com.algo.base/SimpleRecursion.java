package com.algo.base;

import java.util.Arrays;

public class SimpleRecursion {

    public int getFactorial(int fact){
        if(fact == 1)
            return 1;
        return fact * getFactorial(fact - 1);
    }

    public int getSum(int[] numbs){
        if(numbs.length == 0) return 0;

        if(numbs.length == 1) return numbs[0];
        int[] arrayCut = Arrays.copyOfRange(numbs, 1, numbs.length);
        return numbs[0] + getSum(arrayCut);
    }

    public int countSize(int[] numbs){
        if(numbs.length == 0) return 0;

        if(numbs.length == 1) return 1;
        int[] arrayCut = Arrays.copyOfRange(numbs, 1, numbs.length);
        return 1 + countSize(arrayCut);
    }

    public int findMax(int[] numbs){
        if(numbs.length == 0) return 0;
        if(numbs.length == 1) return numbs[0];

        int[] arrayCut = Arrays.copyOfRange(numbs, 1, numbs.length);
        return Math.max(numbs[0], findMax(arrayCut));
    }
}
