package com.dsa.graph;

public class Edge {

    int src;
    int dest;
    int weight;

    public Edge(int src, int dest) {
        this(src, dest, 1);
    }

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
