package org.sathyabodh.graph;

import java.util.*;

public class ShortestPath {

    static class AdjListNode{
        int vertex;
        int weight;
        AdjListNode(int vertex, int weight){
            this.vertex =vertex;
            this.weight =weight;
        }
    }


    private AdjListNode[] shortestPath(int v, int source, List<List<AdjListNode>> graph){
        AdjListNode[] currentDistance = new AdjListNode[v];
        for(int i =0 ; i < currentDistance.length; ++i){
            currentDistance[i] = new AdjListNode (i, Integer.MAX_VALUE);
        }
        currentDistance[source].weight = 0;
        TreeSet<AdjListNode> queue =new TreeSet<> ((first, second)-> first.weight - second.weight);
        for(AdjListNode node : currentDistance){
            queue.add (node);
        }
        HashSet<Integer> spt = new HashSet<> ();
        int[] parent = new int[v];
        Arrays.fill (parent, -1);
        parent[source] = source;
        while(!queue.isEmpty ()){
            AdjListNode node = queue.pollFirst ();

            List<AdjListNode> adjNodes = graph.get(node.vertex);
            spt.add (node.vertex);
            for(AdjListNode adjNode : adjNodes){
                if(adjNode.weight + currentDistance[node.vertex].weight < currentDistance[adjNode.vertex].weight){
                    AdjListNode currentDisNode =  currentDistance[adjNode.vertex];
                    queue.remove (currentDisNode);
                    currentDisNode.weight  = currentDistance[node.vertex].weight + adjNode.weight;
                    queue.add (currentDisNode);
                    parent[currentDisNode.vertex] = node.vertex;
                }
            }
            queue.remove (node);
        }
        for(int i = 0 ; i< parent.length; ++i){
            System.out.println ("Pair:" + i + "-" + parent[i]);
        }

        return currentDistance;
    }

    public static void main(String[] args) {
        int V = 9;
        List<List<AdjListNode> > graph
                = new ArrayList<> ();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjListNode(1, 4));
        graph.get(0).add(new AdjListNode(7, 8));
        graph.get(1).add(new AdjListNode(2, 8));
        graph.get(1).add(new AdjListNode(7, 11));
        graph.get(1).add(new AdjListNode(0, 7));
        graph.get(2).add(new AdjListNode(1, 8));
        graph.get(2).add(new AdjListNode(3, 7));
        graph.get(2).add(new AdjListNode(8, 2));
        graph.get(2).add(new AdjListNode(5, 4));
        graph.get(3).add(new AdjListNode(2, 7));
        graph.get(3).add(new AdjListNode(4, 9));
        graph.get(3).add(new AdjListNode(5, 14));
        graph.get(4).add(new AdjListNode(3, 9));
        graph.get(4).add(new AdjListNode(5, 10));
        graph.get(5).add(new AdjListNode(4, 10));
        graph.get(5).add(new AdjListNode(6, 2));
        graph.get(6).add(new AdjListNode(5, 2));
        graph.get(6).add(new AdjListNode(7, 1));
        graph.get(6).add(new AdjListNode(8, 6));
        graph.get(7).add(new AdjListNode(0, 8));
        graph.get(7).add(new AdjListNode(1, 11));
        graph.get(7).add(new AdjListNode(6, 1));
        graph.get(7).add(new AdjListNode(8, 7));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(7, 1));

        AdjListNode[] distance = new ShortestPath().shortestPath (V, 0, graph);
        // Printing the Output
        System.out.println("Vertex  "
                + "  Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(distance[i].vertex + "             "
                    + distance[i].weight);
        }
    }
}
