package com.dsa;

import com.dsa.graph.BFS;
import com.dsa.graph.DFS;
import com.dsa.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Graph.Edge> edges = new ArrayList<>();
        edges.add(new Graph.Edge(1, 2));
        edges.add(new Graph.Edge(1, 3));
        edges.add(new Graph.Edge(2, 5));
        edges.add(new Graph.Edge(5, 7));
        edges.add(new Graph.Edge(7, 6));
        edges.add(new Graph.Edge(6, 3));
        edges.add(new Graph.Edge(3, 4));
        edges.add(new Graph.Edge(4, 5));
        Graph graph = new Graph(edges);

        graph.printGraphAdjList();

        System.out.println(Arrays.toString(BFS.traversalIterative(graph, 1)));
        System.out.println(Arrays.toString(DFS.dfsTraversalRecursive(graph)));
    }
}
