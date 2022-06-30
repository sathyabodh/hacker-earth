package org.sathyabodh.backtracking;

import java.util.*;

public class NQueensProblem {
    private static List<List<Integer>>solve(int n){
        int[][] currentPlacement = new int[n][n];
        for(int i = 0; i < currentPlacement.length; ++i){
            for(int j = 0; j < currentPlacement.length; ++j)
            currentPlacement[i][j] = -1;
        }

        List<List<Pair>> solutions = new ArrayList<> ();
        place (n, 0, currentPlacement, solutions);
        solutions.forEach (it-> {Collections.sort (it, (first,second)-> first.queen-second.queen);System.out.println(it);});
        return null;
    }

    static class Pair{
        int row;
        int col;
        int queen;
        Pair(int col, int row, int queen){
            this.row = row;
            this.col = col;
            this.queen = queen;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "row=" + row +
                    ", col=" + col +
                    ", queen=" + queen +
                    '}';
        }
    }
    private static boolean place(int n, int col, int[][] currentPlacement, List<List<Pair>> solutions){
        if(n == 0)
        {
            solutions.add(copySolution (currentPlacement));
            return  true;
        }
        for(int row = 0; row < currentPlacement.length; row++){
                if(canPlace (currentPlacement, row, col)){
                    currentPlacement[row][col] = n;
                    boolean placed = place (n-1, col+1, currentPlacement, solutions);
                    /*
                    comment below line to get all solution
                     */
                    if(placed)
                        return true;
                    // check if last queen reached and placed is true
                    currentPlacement[row][col] = -1;
            }
        }
        return  false;
    }
    private static List<Pair> copySolution(int[][] currnetPlacement){
        List<Pair> solution = new ArrayList<> ();
        for(int i = 0; i < currnetPlacement.length; ++i){
            for(int j = 0; j < currnetPlacement.length; ++j){
                if(currnetPlacement[i][j] != -1){
                    solution.add(new Pair (i, j, currnetPlacement[i][j]));
                }
            }
        }
        return solution;
    }

    private static boolean canPlace(int[][] currentPlacement, int row, int col){
        if(currentPlacement[row][col] != -1)
            return false;
        for(int k = 0; k < col; ++k){
            if(currentPlacement[row][k] != -1)
                return  false;
        }

        int i = row;
        int j = col;
        while(i >=0 && j >=0){
            if(currentPlacement[i][j] != -1)
                return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        while(i < currentPlacement.length && j >=0){
            if(currentPlacement[i][j] != -1)
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        solve (4);
    }
}
