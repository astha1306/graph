package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Integer, List<Edge>> adjList;
    private boolean isDirected;

    public Map<Integer, List<Edge>> getAdjList() {
        return adjList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Graph() {
        adjList = new HashMap<>();
        isDirected = false;
    }

    public Graph(List<Edge> edges, boolean isDirected) {
        this();
        for (Edge edge : edges) {
            addEdge(edge);
        }
        this.isDirected = isDirected;
    }

    public Graph(List<Edge> edges) {
        this(edges, false);
    }

    //add a vertex to the graph
    public void addVertex(int vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<Edge>());
        }
    }

    //add an edge
    public void addEdge(Edge edge) {
        if (!adjList.containsKey(edge.src)) {
            addVertex(edge.src);
        }
        adjList.get(edge.src).add(edge);

        if(!this.isDirected) {//undirected
            if (!adjList.containsKey(edge.dest)) {
                addVertex(edge.dest);
            }
            adjList.get(edge.dest).add(new Edge(edge.dest, edge.src, edge.weight));
        }
    }
}
