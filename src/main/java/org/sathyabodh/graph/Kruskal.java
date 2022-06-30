package org.sathyabodh.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    static class Edge {
        int from ;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.weight = weight;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
    static class Subset{
        int parent;
        int rank = 0;
        public Subset(int i){
            parent = i;
        }
    }
    private int find(Subset[] subsets, int v){
        if(subsets[v].parent != v){
            subsets[v].parent = find (subsets, subsets[v].parent);
        }
        return subsets[v].parent;
    }
    private void union(Subset[] subsets, int root1, int root2){
        if(subsets[root1].rank <= subsets[root2].rank){
            subsets[root2].parent = subsets[root1].parent;
            subsets[root1].rank ++;
        }
        else if(subsets[root2].rank < subsets[root1].rank){
            subsets[root1].parent = subsets[root2].parent;;
            subsets[root2].rank ++;
        }
    }

    public List<Edge> MST(int v, int e, List<Edge> edges){
        // Sort the edges in desc order
        Collections.sort(edges, (first, seconod)-> first.weight - seconod.weight);
        Subset[] subsets = new Subset[v+1];
        for(int i = 0 ; i < subsets.length; ++i){
            subsets[i] = new Subset (i);
        }
        int totalWeight = 0;
        List<Edge> mstEdges = new ArrayList<> ();
        for(int i = 0; i < edges.size (); ++i){
            int root1 = find (subsets, edges.get (i).from);
            int root2 = find(subsets, edges.get (i).to);
            if(root1 == root2)
                continue;
            union (subsets, root1, root2);
            mstEdges.add(edges.get (i));
            totalWeight += edges.get (i).weight;
        }
        return mstEdges;
    }

    public static void main(String[] args) {
        int v = 4;
        int e = 5;
        List<Edge> edges = new ArrayList<> ();
        edges.add(new Edge (0,1,10));
        edges.add(new Edge (0,2,6));
        edges.add(new Edge (0,3,5));
        edges.add(new Edge (1,3,15));
        edges.add(new Edge (2,3,4));
        List<Edge> result = new Kruskal ().MST(v, e, edges);
        int totalWeights = 0;
        for(Edge edge : result){
            totalWeights += edge.weight;
        }
        result.forEach (it-> System.out.println (it));
        System.out.println ("Min weight: " + totalWeights);
    }
}
