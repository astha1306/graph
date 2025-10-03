package com.dsa.graph;


import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Node>> adjList;

    private int[][] adjMatrix;

    private boolean isDirected;

    public List<List<Node>> getAdjList() {
        return adjList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Graph() {
        adjList = new ArrayList<>();
        isDirected = false;
    }

    public Graph(List<Edge> edges, boolean isDirected) {
        this();
        this.isDirected = isDirected;
        int n = 0;
        for(Edge edge : edges) {
            n = Math.max(n , Math.max(edge.src, edge.dest));
        }
        adjMatrix = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<Node>());
        }
        for (Edge edge : edges) {
            addEdge(edge);
        }
    }

    public Graph(List<Edge> edges) {
        this(edges, false);
    }

    //add an edge
    public void addEdge(Edge edge) {
        adjList.get(edge.src).add(new Node(edge.dest, edge.weight));
        adjMatrix[edge.src][edge.dest] = edge.weight == 0 ? 1 : edge.weight;
        if(!this.isDirected) {//undirected
            adjList.get(edge.getDest()).add(new Node(edge.src, edge.weight));
            adjMatrix[edge.dest][edge.src] = edge.weight == 0 ? 1 : edge.weight;
         }
    }

    public void printGraph() {
        System.out.println("-----Graph-----");
        for(int i = 0; i < adjList.size(); i++) {
            for(Node node : adjList.get(i)) {
                System.out.print(i + " --");
                if(node.weight != 0) System.out.println(node.weight);
                System.out.println("--> " + node.vertex);

            }
        }
    }

    public void printGraphAdjList() {
        for(int i = 0; i < adjList.size(); i++) {
            System.out.println(i + "--" + adjList.get(i));
        }
    }

    public void printGraphAdjMatrix() {
        for(int i = 0; i < adjMatrix.length; i++) {
            System.out.print("[ ");
            for(int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static class Edge {
        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public Edge(int src, int dest) {
            this(src, dest, 0);
        }

        public int getSrc() {
            return src;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static class Node {
        private int vertex;
        private int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public Node(int vertex) {
            this(vertex, 0);
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            String str = "{" +vertex;
            if(weight != 0) str += ", " + weight;
            str += "}";
            return str;
        }
    }
}
