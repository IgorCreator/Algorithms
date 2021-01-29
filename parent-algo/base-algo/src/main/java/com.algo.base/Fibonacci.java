package com.algo.base;

import java.util.LinkedList;
import java.util.List;

public class Fibonacci {

    public int recursionWay(int n){
        if (n <= 1)
            return 1;
        return recursionWay(n-1) + recursionWay(n-2);
    }

    public int optimized(int n){
        int a = 1, b = 1, c;
        if(n < 2)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public int dynamic(int n) {
        int[]f = new int[n+1];
        if (n<2)
            return 1;
        else {
            f[0] = f[1] = 1;
            for (int i = 2; i <= n; i++)
                f[i] = f[i - 1] + f[i - 2];
            return f[n];
        }
    }

    public int calculateMyHardWay(int n){
        List<Integer> res = new LinkedList<>();
        res.add(1);
        if(n > 0) {
            res.add(1);
            for (int i = 1; i < n; i++) {
                res.add(res.get(i) + res.get(i-1));
            }
        }
        return res.get(n);
    }
}
