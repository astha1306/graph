package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void dfsTraversalRecursive(Graph graph) {
        int[] visited = new int[graph.getAdjList().size() + 1];
        List<Integer> output = new ArrayList<>();
        dfsRecursive(graph, visited, 0, output);
    }

    public static void dfsRecursive(Graph graph, int[] visited, int node, List<Integer> output) {
        visited[node] = 1;
        output.add(node);
        for (int next : graph.getAdjList().get(node)) {
            if(visited[next] != 1) {
                dfsRecursive(graph, visited, next, output);
            }
        }
    }
}
