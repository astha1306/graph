package com.dsa.graph.algorithms;

import com.dsa.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    //Time Complexity : O(N) + O(2E)
    //Space Complexity : O(3N) ~ O(N) : for queue, visited array, output arr

    //visited array : to store visited nodes
    //queue : contains starting node

    //Algorithm :
    // queue will have initial starting element in it.
    // whatever u take out of queue, mark it as visited.
    // store its adj elements in queue, mark them visited.
    //repeat!
    public static int[] traversalIterative(Graph graph, int root) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int[] bfs = new int[adjList.size()];
        int[] visited = new int[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = 1;
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs[i++] = node;
            for(Graph.Node next : graph.getAdjList().get(node)) {
                if(visited[next.getVertex()] != 1) {
                    queue.offer(next.getVertex());
                    visited[next.getVertex()] = 1;
                }
            }
        }
        return bfs;
    }

    //Not suitable in bfs as bfs is level by level
    public static int[] traversalRecursive(Graph graph, int root) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int[] bfs = new int[adjList.size()];
        int[] visited = new int[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = 1;

        traversalRecursive(graph, queue, visited, bfs, 0);

        return bfs;
    }

    public static void traversalRecursive(Graph graph, Queue<Integer> queue, int[] visited, int[] bfs, int i) {
        while (queue.isEmpty()) {
            return;
        }
        int node = queue.poll();
        bfs[i++] = node;
        for(Graph.Node next : graph.getAdjList().get(node)) {
            if(visited[next.getVertex()] != 1) {
                queue.offer(next.getVertex());
                visited[next.getVertex()] = 1;
            }
        }
        traversalRecursive(graph, queue, visited, bfs, i);
    }
}
