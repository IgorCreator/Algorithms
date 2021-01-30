package com.algo.base;

public class SimpleRecursion {

    public int getFactorial(int fact){
        if(fact == 1)
            return 1;
        return fact * getFactorial(fact - 1);
    }
}
