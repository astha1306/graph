package com.dsa.graph.algorithms;

import com.dsa.graph.Graph;

import java.util.*;

public class CycleDetection {

    public static boolean inUndirectedGraphBfs(Graph graph) {

        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(inUndirectedGraphBfs(graph, visited, i)) return true;
            }
        }
        return false;
    }

    private static boolean inUndirectedGraphBfs(Graph graph, boolean[] visited, int root) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        Queue<int[]> queue = new LinkedList<>();
        visited[root] = true;
        queue.offer(new int[]{root, -1});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (Graph.Node next : adjList.get(node[0])) {
                int vertex = next.getVertex();
                if(!visited[vertex]) {
                    visited[vertex] = true;
                    queue.offer(new int[]{vertex, node[0]});
                }
                else if(vertex != node[1]) return true;
            }
        }
        return false;
    }

    public static boolean inUndirectedGraphDfs(Graph graph) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(inUndirectedGraphDfs(graph, visited, i, -1)) return true;
            }
        }
        return false;
    }

    private static boolean inUndirectedGraphDfs(Graph graph, boolean[] visited, int root, int parent) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        visited[root] = true;
        for (Graph.Node next : adjList.get(root)) {
            if(!visited[next.getVertex()]) {
                if(inUndirectedGraphDfs(graph, visited, next.getVertex(), root)) return true;
            } else if(next.getVertex() != parent) return true;
        }
        return false;
    }


    public static boolean inDirectedGraphDfs(Graph graph) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if(inDirectedGraphDfs(graph, visited, pathVisited, i)) return true;
            }
        }

        return false;
    }

    private static boolean inDirectedGraphDfs(Graph graph, boolean[] visited, boolean[] pathVisited, int root) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        visited[root] = true;
        pathVisited[root] = true;

        //traverse for adjacent nodes
        for(Graph.Node next : adjList.get(root)) {
            if(!visited[next.getVertex()]) {
                //when node not visited
                if(inDirectedGraphDfs(graph, visited, pathVisited, next.getVertex())) return true;
                //if node is previously visited but it has to be visited on same path
                else if(pathVisited[next.getVertex()]) return true;
            }
        }
        pathVisited[root] = false;
        return false;
    }

    //Topological Sorting : the src should appear before its dest.
    public static int[] topologicalSortDfs(Graph graph) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                topologicalSortDfs(graph, visited, stack, i);
            }
        }
        int[] topoSort = new int[n];
        int i = 0;
        while (!stack.isEmpty()) {
            topoSort[i++] = stack.pop();
        }
        return topoSort;
    }

    private static void topologicalSortDfs(Graph graph, boolean[] visited, Stack<Integer> stack ,  int root) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        visited[root] = true;
        for (Graph.Node next : adjList.get(root)) {
            if(!visited[next.getVertex()]) topologicalSortDfs(graph, visited, stack, root);
        }
        stack.push(root);
    }

    public static int[] kahnsAlgorithm_TopologicalSortBfs(Graph graph) {
        List<List<Graph.Node>> adjList = graph.getAdjList();
        int n = adjList.size();
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++) {
            for(Graph.Node next : adjList.get(i)) {
                inDegree[next.getVertex()]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int[] topoSort = new int[n];
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[i++] = node;

            for (Graph.Node next : adjList.get(node)) {
                int vertex = next.getVertex();
                inDegree[vertex]--;
                if(inDegree[vertex] == 0) queue.add(vertex);
            }
        }

        return topoSort;
    }

    public static boolean byTopologicalSorting(Graph graph) {
        int[] topoSort = kahnsAlgorithm_TopologicalSortBfs(graph);
        //int[] topoSort = topologicalSortDfs(graph);   use any topo sort algo
        if(topoSort.length == graph.getAdjList().size()) return false;
        return true;
    }



}
