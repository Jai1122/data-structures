package com.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static void addEdge(List<List<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(List<List<Integer>> adj){
        for(List<Integer> i:adj){
            System.out.print("head");
            for(Integer vertex: i){
                System.out.print("->"+vertex);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int startVertices   =   5;
        List<List<Integer>> adj =   new ArrayList<>(startVertices);
        for (int i = 0; i < startVertices; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
    }
}
