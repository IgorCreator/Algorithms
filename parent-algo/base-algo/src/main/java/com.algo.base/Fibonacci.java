package com.algo.base;

public class Fibbonachi {

    public int fib(int n){
        int sum = 1;
        if(n == 0 || n == 1)
            return sum;

        sum += fib(n-1);

        return sum;
    }
}
