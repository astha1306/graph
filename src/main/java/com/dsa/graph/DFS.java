package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static int[] dfsTraversalRecursive(Graph graph) {//ToDo add for loop to cover all node instead of starting from 1
        int n = graph.getAdjList().size();
        int[] visited = new int[graph.getAdjList().size() + 1];
        int[] output = new int[n];
        int i = 0;
        dfsRecursive(graph, visited, 1, output, i);
        return output;

    }

    public static void dfsRecursive(Graph graph, int[] visited, int node, int[] output, int i) {
        visited[node] = 1;
        output[i++] = node;
        for (Graph.Node next : graph.getAdjList().get(node)) {
            if(visited[next.getVertex()] != 1) {
                dfsRecursive(graph, visited, next.getVertex(), output, i);
            }
        }
    }
}
