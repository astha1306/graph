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

    public static void bfsTraversalIterative(Graph graph, int root) {
        List<Integer> bfs = new ArrayList<>();
        int[] visited = new int[graph.getAdjList().size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            for(Edge edge : graph.getAdjList().get(node)) {
                if(visited[edge.dest] != 1) {
                    queue.offer(edge.dest);
                    visited[edge.dest] = 1;
                }
            }
        }

    }
}
