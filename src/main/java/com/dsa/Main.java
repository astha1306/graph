package com.dsa;

import com.dsa.graph.BFS;
import com.dsa.graph.DFS;
import com.dsa.graph.Graph;
import com.dsa.graph.algorithms.CycleDetection;
import com.dsa.graph.algorithms.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CycleDetection_inDirectedGraphDfs_Test();

        ShortestPath_byBfs_Test();
    }

    public static void traversal_test() {
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

    public static void CycleDetection_inDirectedGraphDfs_Test() {
        List<Graph.Edge> edges = new ArrayList<>();
        edges.add(new Graph.Edge(1, 2));
        edges.add(new Graph.Edge(1, 3));
        edges.add(new Graph.Edge(2, 5));
        edges.add(new Graph.Edge(5, 7));
        edges.add(new Graph.Edge(7, 6));
        edges.add(new Graph.Edge(6, 3));
        edges.add(new Graph.Edge(3, 4));
        edges.add(new Graph.Edge(4, 5));
        Graph graph = new Graph(edges, true);

        System.out.println(CycleDetection.inDirectedGraphDfs(graph));
    }

    public static void ShortestPath_byBfs_Test() {
        List<Graph.Edge> edges = new ArrayList<>();
        edges.add(new Graph.Edge(0, 1));
        edges.add(new Graph.Edge(0, 3));
        edges.add(new Graph.Edge(3, 4));
        edges.add(new Graph.Edge(4, 5));
        edges.add(new Graph.Edge(5, 6));
        edges.add(new Graph.Edge(1, 2));
        edges.add(new Graph.Edge(2, 6));
        edges.add(new Graph.Edge(6, 7));
        edges.add(new Graph.Edge(7, 8));
        edges.add(new Graph.Edge(6, 8));

        Graph graph = new Graph(edges);

        System.out.println(Arrays.toString(ShortestPath.byBfs(graph)));
    }
}
