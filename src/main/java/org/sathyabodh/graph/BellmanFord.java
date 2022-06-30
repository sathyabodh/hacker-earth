package org.sathyabodh.graph;

import java.util.Arrays;

public class BellmanFord {
    static class Edge{
        int src = 0;
        int dest = 0 ;
        int weight = 0;
        Edge(){

        }
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class Graph{
        int v;
        int e;
        Graph(int v, int e){
            this.v = v;
            this.e = e;
            edge = new Edge[e];
            for(int i = 0; i < e; ++i){
                edge[i] = new Edge ();
            }
        }

        Edge[] edge;
    }
    private final int MAX_DIST = 999999;
    private int[] shortestPath(Graph graph, int source){
        int[] dist = new int[graph.v];
        Arrays.fill (dist, MAX_DIST);
        dist[source] = 0;

        boolean isDistChanged = true;
        for(int i =0; i < graph.v -1 && isDistChanged; ++i){
            isDistChanged = false;
            for(int j = 0; j < graph.e; ++j){
                Edge edge = graph.edge[j];
                if(dist[edge.src] + edge.weight < dist[edge.dest]){
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                    isDistChanged = true;
                }
            }
            if(!isDistChanged){
                System.out.println ("Breaking from evaluating the edges at round:"  + i + " out of " + (graph.v-1));
            }
        }
        for(int j = 0; j < graph.e; ++j){
            Edge edge = graph.edge[j];
            if(dist[edge.src] + edge.weight < dist[edge.dest]){
                throw new RuntimeException("Graph contains negative weight cycle");
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        BellmanFord bellmanFord = new BellmanFord ();
        int[] dist = bellmanFord.shortestPath (graph, 0);
        System.out.println ("Distance: " + Arrays.toString (dist));

        testNegativeWeightCycle();
    }

    private static void testNegativeWeightCycle(){
        int V = 5, E = 8;
        Graph graph = new Graph (V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        Graph graph1 = new Graph (4,4);
        graph1.edge[0].src = 0;
        graph1.edge[0].dest = 1;
        graph1.edge[0].weight = -1;

        graph1.edge[1].src = 1;
        graph1.edge[1].dest = 2;
        graph1.edge[1].weight = -1;

        graph1.edge[2].src = 2;
        graph1.edge[2].dest = 3;
        graph1.edge[2].weight = -1;

        graph1.edge[3].src = 3;
        graph1.edge[3].dest = 0;
        graph1.edge[3].weight = -1;

        BellmanFord bellmanFord = new BellmanFord ();
        try{
            int[] dist = bellmanFord.shortestPath (graph1, 0);
            System.out.println ("Graph does not contain negative weight cycle");
        }catch (RuntimeException e){
            System.out.println (e.getMessage ());
            e.printStackTrace ();
        }

    }
}
