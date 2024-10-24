package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    //visited array : to store visited nodes
    //queue : contains starting node

    //Algorithm :
    // queue will have initial starting element in it.
    // whatever u take out of queue, mark it as visited.
    // store its adj elements in queue, mark them visited.
    //repeat!

    public static int[] traversalIterative(Graph graph, int root) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int[] bfs = new int[adjList.size() + 1];
        int[] visited = new int[adjList.size() + 1];
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
}
