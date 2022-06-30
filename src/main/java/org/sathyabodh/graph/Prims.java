package org.sathyabodh.graph;

import com.sun.source.tree.Tree;

import java.util.*;

public class Prims {

    static class Edge{
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Graph{
        int vertex ;
        List<Edge>[] adj ;
        Graph(int vertex) {
            this.vertex = vertex;
            adj = new ArrayList[vertex];
        }
    }

    static class Node {
        int key;
        int v;
    }

    private static int prims(Graph graph){
        int[] parent = new int[graph.vertex];
        Node[] currentDistance = new Node[graph.vertex];
        TreeSet<Node> queue = new TreeSet<> ((node1, node2)-> node1.key - node2.key);

        for(int i = 0; i < currentDistance.length; ++i){
            currentDistance[i] = new Node ();
            currentDistance[i].v = i;
            currentDistance[i].key = Integer.MAX_VALUE;
        }
        currentDistance[0].key = 0;
        for(int i =0; i < currentDistance.length; ++i){
            queue.add (currentDistance[i]);
        }

        Set<Integer> mst = new HashSet<> ();
        int totalWeight = 0;
        List<Edge> minEdges = new ArrayList<> ();
        while(!queue.isEmpty ()){
            Node node = queue.pollFirst ();
            mst.add (node.v);
            List<Edge> adj = graph.adj[node.v];
            for(Edge edge : adj){
                Node adjNode = currentDistance[edge.to];
                if(!mst.contains (edge.to) && edge.weight < adjNode.key){
                    queue.remove (adjNode);
                    adjNode.key = edge.weight;
                    queue.add (adjNode);
                    totalWeight+= edge.weight;
                    minEdges.add (edge);
                }
            }
            queue.remove (node);

        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Graph g = new Graph (9);

        for(int i = 0; i < g.vertex; i++){
            g.adj[i] = new ArrayList<> ();
        }
        g.adj[0].add (new Edge (1,4));
        g.adj[0].add (new Edge (7,8));
        g.adj[1].add (new Edge (0,4));
        g.adj[7].add (new Edge (0,8));

        g.adj[1].add (new Edge (2,8));
        g.adj[1].add (new Edge (7,11));
        g.adj[2].add (new Edge (1,8));
        g.adj[7].add (new Edge (1,11));

        g.adj[2].add (new Edge (3,7));
        g.adj[2].add (new Edge (8,2));
        g.adj[2].add (new Edge (5,4));
        g.adj[3].add (new Edge (2,7));
        g.adj[8].add (new Edge (2,2));
        g.adj[5].add (new Edge (2,4));

        g.adj[3].add (new Edge (4,9));
        g.adj[3].add (new Edge (5,14));
        g.adj[4].add (new Edge (3,9));
        g.adj[5].add (new Edge (3,14));

        g.adj[4].add (new Edge (5,10));
        g.adj[5].add (new Edge (4,10));

        g.adj[6].add (new Edge (7,1));
        g.adj[7].add (new Edge (6,1));

        g.adj[6].add (new Edge (8,6));
        g.adj[8].add (new Edge (6,6));

        g.adj[7].add (new Edge (8,7));
        g.adj[8].add (new Edge (7,7));



        int totalWeight = Prims.prims (g);
        System.out.println ("totalWeight:" + totalWeight);
    }
}
