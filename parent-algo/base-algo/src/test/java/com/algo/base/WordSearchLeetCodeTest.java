package com.algo.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordSearchLeetCodeTest {

    @Test
    public void testInternetSol(){
        char[][] grid = new char[][]{"abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray()};
        assertTrue(WordSearchLeetCode.checkMatch(grid, "abcced"));
    }

    @Test
    public void testSol() {
        WordSearchLeetCode wordSearch = new WordSearchLeetCode();
        char grid[][] = { "axmy".toCharArray(),
                "bgdf".toCharArray(),
                "xeet".toCharArray(),
                "raks".toCharArray() };
        assertTrue(wordSearch.exist(grid, "geeks"));

        wordSearch = new WordSearchLeetCode();
        grid = new char[][]{"abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray()};
        assertTrue(wordSearch.exist(grid, "abcced"));

        wordSearch = new WordSearchLeetCode();
        grid = new char[][]{"abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray()};
        assertTrue(wordSearch.exist(grid, "see"));

        wordSearch = new WordSearchLeetCode();
        grid = new char[][]{"a".toCharArray()};
        assertTrue(wordSearch.exist(grid, "a"));

        wordSearch = new WordSearchLeetCode();
        grid = new char[][]{"caa".toCharArray(),
                "aaa".toCharArray(),
                "bcd".toCharArray()};
        assertTrue(wordSearch.exist(grid, "aab"));

        wordSearch = new WordSearchLeetCode();
        grid = new char[][]{"a".toCharArray()};
        assertFalse(wordSearch.exist(grid, "b"));

        wordSearch = new WordSearchLeetCode();
        grid = new char[][]{"abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray()};
        assertFalse(wordSearch.exist(grid, "abcb"));
    }

}