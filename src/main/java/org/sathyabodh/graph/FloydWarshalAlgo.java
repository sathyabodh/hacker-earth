package org.sathyabodh.graph;

public class FloydWarshalAlgo {
    static final int INF=9999;
    private void findShortestPath(int[][] a, int v){
        for(int k =0; k<v; ++k){
            for(int i = 0; i < v; ++i){
                for(int j=0; j < v; ++j){
                    a[i][j] = Math.min (a[i][j], a[i][k]+a[k][j]);
                }
            }
        }
        printSolution (a, v);
    }

    void printSolution(int dist[][], int v )
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<v; ++i)
        {
            for (int j=0; j<v; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        new FloydWarshalAlgo ().findShortestPath (graph, 4);
    }
}
