package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Integer>> adjList;
    private boolean isDirected;

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Graph(List<Edge> edges, boolean isDirected ) {
        int n = edges.size();
        adjList = new ArrayList<>();
        this.isDirected = isDirected;
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(Edge edge : edges) {
            adjList.get(edge.src).add(edge.dest);
            if(!isDirected) {
                adjList.get(edge.dest).add(edge.src);
            }
        }
    }

    public Graph(List<Edge> edges) {
        this(edges, false);
    }
}
