package org.sathyabodh.backtracking;

import java.util.Arrays;

public class GraphColoringProblem {

    private boolean canAssign(boolean [][] graph, int [] colors, int v, int color){
        for(int i =0; i < graph.length; ++i){
            if(graph[v][i]){
                if(colors[i] == color)
                    return false;
            }

        }
        return true;
    }

    private boolean colorGraph(boolean[][] graph, int[] color, int m, int vertices, int v){
        if(v == vertices)
            return true;
        boolean canColor = false;
        for(int i = 1; i <= m; ++i){
            if(canAssign (graph, color, v, i)){
                color[v] = i;
                canColor = colorGraph (graph, color, m, vertices, v+1);
                if(canColor)
                    return  true;
                color[v] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] graph = {
                { false, true, true, true },
                { true, false, true, false },
                { true, true, false, true },
                { true, false, true, false },
        };
        int m = 3; // Number of colors
        int vertices = 4;
        int [] color = new int[vertices];
        Arrays.fill (color, 0);
        GraphColoringProblem graphColoringProblem = new GraphColoringProblem ();
        boolean canColor = graphColoringProblem.colorGraph (graph, color, m, vertices, 0);
        System.out.println ("Can color with :" + m + " " + canColor);
        if(canColor){

            System.out.println ("Solution: " + Arrays.toString (color));
        }
    }
}
