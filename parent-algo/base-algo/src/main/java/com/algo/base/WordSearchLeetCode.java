package com.algo.base;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class WordSearchLeetCode {

    class Position {
        int x;
        int y;
        int ch;

        Position(int x, int y, char ch){
            this.x = x;
            this.y = y;
            this.ch = ch;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y && ch == position.ch;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, ch);
        }

        @Override
        public String toString() {
            return Character.toString(ch) + " -[" + x +
                    "][" + y +
                    ']';
        }
    }

    Set<Position> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;

        char[] wordCh = word.toCharArray();

        Position startPos = new Position(0,0, board[0][0]);
        char beginCh = word.charAt(0);
        while(true){

            startPos = searchBeginning(board, beginCh, startPos);

            if(startPos.x == Integer.MAX_VALUE && startPos.y == Integer.MAX_VALUE)
                return false;

            if(wordCh.length == 1)
                return true;

            visited.add(startPos);
            Position prevCh = startPos;
            for(int i=1; i < wordCh.length; i++){
                char lookingFor = wordCh[i];

                Stack<Position> searchPositions = formPosiblePos(board, prevCh);

                Position newPosition = prevCh;
                while(!searchPositions.empty()){
                    Position posiblePos = searchPositions.pop();

                    if(lookingFor == board[posiblePos.x][posiblePos.y]){
                        newPosition = posiblePos;
                        visited.add(newPosition);
                        if(i == wordCh.length - 1)
                            return true;
                        else
                            break;
                    }
                }

                if(searchPositions.empty() && prevCh == newPosition)
                    break;

                prevCh = newPosition;
            }
        }
    }

    private Position searchBeginning(char[][] board, char searchFor, Position startSearch){
        for(int i=startSearch.x; i<board.length; i++){
            for(int j=startSearch.y; j<board[i].length; j++){
                if(board[i][j] == searchFor) {
                    Position position = new Position(i, j, board[i][j]);
                    if (!visited.contains(position))
                        return position;
                }
            }
        }
        return new Position(Integer.MAX_VALUE, Integer.MAX_VALUE, board[0][0]);
    }

    private Stack<Position> formPosiblePos(char[][] board, Position prevCh){

        Stack<Position> searchPositions = new Stack<>();

        if(prevCh.x != 0 ){
            Position pos = new Position(prevCh.x - 1, prevCh.y, board[prevCh.x - 1][prevCh.y]);
            if(!visited.contains(pos)) searchPositions.push(pos);
        }
        if(prevCh.y != 0 ){
            Position pos = new Position(prevCh.x, prevCh.y - 1, board[prevCh.x][prevCh.y-1]);
            if(!visited.contains(pos)) searchPositions.push(pos);
        }
        if(prevCh.x != board.length - 1 ){
            Position pos = new Position(prevCh.x+1, prevCh.y, board[prevCh.x + 1][prevCh.y]);
            if(!visited.contains(pos)) searchPositions.push(pos);
        }
        if(prevCh.y != board[prevCh.x].length - 1){
            Position pos = new Position(prevCh.x, prevCh.y + 1, board[prevCh.x][prevCh.y + 1]);
            if(!visited.contains(pos)) searchPositions.push(pos);
        }
        return searchPositions;
    }




    static boolean findmatch(char mat[][], String pat, int x, int y,
                             int nrow, int ncol, int level)
    {
        int l = pat.length();

        // Pattern matched
        if (level == l)
            return true;

        // Out of Boundary
        if (x < 0 || y < 0 || x >= nrow || y >= ncol)
            return false;

        // If grid matches with a letter while
        // recursion
        if (mat[x][y] == pat.charAt(level))
        {

            // Marking this cell as visited
            char temp = mat[x][y];
            mat[x][y] = '#';

            // finding subpattern in 4 directions
            boolean res = findmatch(mat, pat, x - 1, y, nrow, ncol, level + 1) |
                    findmatch(mat, pat, x + 1, y, nrow, ncol, level + 1) |
                    findmatch(mat, pat, x, y - 1, nrow, ncol, level + 1) |
                    findmatch(mat, pat, x, y + 1, nrow, ncol, level + 1);

            // marking this cell
            // as unvisited again
            mat[x][y] = temp;
            return res;
        }
        else // Not matching then false
            return false;
    }

    // Function to check if the word exists in the grid or not
    static boolean checkMatch(char mat[][], String pat)
    {

        int l = pat.length();
        int nrow = mat.length;
        int ncol = mat[0].length;

        if (l > nrow * ncol)
            return false;

        // Traverse in the grid
        for (int i = 0; i < nrow; i++)
        {
            for (int j = 0; j < ncol; j++)
            {
                // If first letter matches, then recur and check
                if (mat[i][j] == pat.charAt(0))
                    if (findmatch(mat, pat, i, j, nrow, ncol, 0))
                        return true;
            }
        }
        return false;
    }
}
