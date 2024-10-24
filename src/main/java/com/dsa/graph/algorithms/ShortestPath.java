package com.dsa.graph.algorithms;

import com.dsa.graph.Graph;

import java.util.*;

public class ShortestPath {

    public static int[] byBfs(Graph graph) {
        //given unit distance between each node, find shortest path to each node from src(0)
        //Time complexity(BFS) : Vertex + 2Edges
        //Space complexity : N
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);//adding src

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(Graph.Node next : adjList.get(node)) {
                int vertex = next.getVertex();
                if(dist[node] + 1 < dist[vertex]) {
                    dist[vertex] = dist[node] + 1;
                    queue.offer(vertex);
                }

            }
        }
        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }


}
