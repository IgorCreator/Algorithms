package com.algo.base;

public class GCD {

    public int findGCD(int a, int b){
        while(b!=0){
           int i = a % b;
           a=b;
           b=i;
        }
        return a;
    }

}
