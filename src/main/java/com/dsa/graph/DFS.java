package com.dsa.graph;

import java.util.Stack;

public class DFS {

    public static int[] traversalRecursive(Graph graph) {
        int n = graph.getAdjList().size();
        int[] visited = new int[n];
        int[] output = new int[n];
        int[] ind = {0};
        for(int i = 0; i < n; i++) {// loop through nodes to get all nodes in case of non-connected graph components, in case of connected graph, directly all recursive func
            if(visited[i] != 1) {
                traversalRecursive(graph, visited, i, output, ind);
            }

        }
        return output;

    }

    public static void traversalRecursive(Graph graph, int[] visited, int node, int[] output, int[] ind) {
        visited[node] = 1;
        output[ind[0]++] = node;
        for (Graph.Node next : graph.getAdjList().get(node)) {
            if(visited[next.getVertex()] != 1) {
                traversalRecursive(graph, visited, next.getVertex(), output, ind);
            }
        }
    }

    public static int[] traversalIterative(Graph graph) {
        int n = graph.getAdjList().size();
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        int ind = 0;
        for(int i = 0; i < n; i++) {// loop through nodes to get all nodes in case of non-connected graph components, in case of connected graph, directly all recursive func
            if(visited[i] != 1) {
                stack.push(i);
                while (!stack.isEmpty()) {
                    int node = stack.pop();

                    if(visited[node] != 1) {
                        visited[node] = 1;
                        output[ind++] = node;

                        // Push all unvisited neighbors onto the stack
                        for(Graph.Node next : graph.getAdjList().get(node)) {
                            if(visited[next.getVertex()] != 1) {
                                stack.push(next.getVertex());
                            }

                        }
                    }
                }
            }
        }
        return output;
    }

}
