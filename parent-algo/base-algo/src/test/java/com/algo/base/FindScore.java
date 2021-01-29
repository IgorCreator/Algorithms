package com.algo.base;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class FindScore {

    public static void main(String[] args) {
        int[] score = {100, 90, 90, 80, 75, 60};
        int[] alice = {50, 65, 77, 90, 102};
        System.out.println(Arrays.toString(climbingLeaderboard(score, alice)));
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        TreeSet<Integer> mySet = new TreeSet<>();
        for (int score : scores) {
            mySet.add(score);
        }
        TreeSet<Integer> intsReverse = (TreeSet<Integer>) mySet.descendingSet();

        int[] res = new int[alice.length];

        for(int i = 0; i<alice.length; i++){
            int aliceScore = alice[i];
            res[i] = findInScores(intsReverse, aliceScore);
        }

        return res;
    }

    private static int findInScores(TreeSet<Integer> mySet, int alice){
        Iterator<Integer> it = mySet.iterator();

        int i = 0;
        Integer current = null;
        while(it.hasNext()) {
            i++;
            current = it.next();
            if (current > alice){
                continue;
            }
            else
                return i;
        }
        return mySet.size() + 1;
    }
}