package org.sathyabodh.backtracking;

import java.util.Arrays;

public class TSP {

    private int findMinimumCostTravel(int[][] graph, boolean[] visited, int[] bestPath, int[] path, int currNode, int currCost, int count, int answer){
        if(count == graph.length && graph[currNode][0] > 0){
            if(currCost + graph[currNode][0] < answer){
                System.out.println ("Cost:" + (currCost + graph[currNode][0]) + " Path: " + Arrays.toString (path));
                System.arraycopy (path, 0, bestPath, 0, path.length);
                bestPath[count] = 1;
            }
            return Math.min (currCost + graph[currNode][0], answer);
        }
        int cost = 0;
        for(int i = 0; i < graph.length; ++i){
            if(graph[currNode][i] != 0 && currCost+ graph[currNode][i] < answer && !visited[i]){
                currCost+= graph[currNode][i];
                visited[i] = true;
                path[count] = i+1;
                answer = findMinimumCostTravel(graph, visited, bestPath, path, i, currCost, count + 1, answer);
//                boolean allVisited = true;
//                for(boolean visit : visited){
//                    if(!visit){allVisited = false; break;}
//                }
//                if(cost < answer)
//                    answer = cost;
                currCost-= graph[currNode][i];
                path[count] = -1;
                visited[i] = false;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
        boolean[] visited = new boolean[n];
        Arrays.fill (visited, false);
        int[] path = new int[n];
        int[] bestPath = new int[n+1];
        Arrays.fill (path, -1);
        Arrays.fill (bestPath, -1);
        bestPath[0] = 1;
        path[0] = 1;
        TSP tsp = new TSP ();
        visited[0] = true;
        int cost = tsp.findMinimumCostTravel(graph, visited, bestPath, path, 0, 0, 1, Integer.MAX_VALUE);
        System.out.println ("Cost:" + cost + " path:" + Arrays.toString (bestPath));
    }
}
