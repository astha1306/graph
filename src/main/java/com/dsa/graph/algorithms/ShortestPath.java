package com.dsa.graph.algorithms;

import com.dsa.graph.Graph;

import java.util.*;

public class ShortestPath {

    public static int[] byBfsForUnitWeight(Graph graph) {
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

    //Dijkstra is not applicable for negative weights
    //TC : E log V
    //Space Complexity : N
    public static int[] byDijkstraUsingPriorityQueue(Graph graph) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        Queue<Graph.Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Graph.Node::getWeight));
        minHeap.offer(new Graph.Node(0, 0));
        while (!minHeap.isEmpty()) {
            int dis = minHeap.peek().getWeight();
            int node = minHeap.peek().getVertex();
            minHeap.poll();

            for(Graph.Node next : adjList.get(node)) {
                int adjNode = next.getVertex();
                int edgeWeight = next.getWeight();
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    minHeap.offer(new Graph.Node(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }

    //Applicable only in Directed Graph
    //can apply on negative weight
    public static int[] byBellmanFord(Graph graph) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for(int i = 1; i < n; i++) {//Relaxation : do n-1 iterations
            for(int j = 0; j < n; j++) {
                for(Graph.Node next : adjList.get(j)) {
                    if(dist[j] != Integer.MAX_VALUE && dist[j] + next.getWeight() < dist[next.getVertex()]) {
                        dist[next.getVertex()] = dist[j] + next.getWeight();
                    }
                }
            }
        }
        return dist;
    }
}
