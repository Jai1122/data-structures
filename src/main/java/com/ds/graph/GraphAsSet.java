package com.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class GraphAsSet {

    static  class Graph{
        int v;
        HashMap<Integer, TreeSet<Integer>>  graph;

        public Graph(int v){
            this.v  =   v;
            this.graph  =   new HashMap<>();
            for (int i = 0; i < this.v; i++) {
                graph.put(i, new TreeSet<>());
            }
        }

        public void addEdge(int src, int dest){
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        public void findEdge(int src, int dest){
            TreeSet<Integer> edges = graph.get(src);
            if (edges.contains(dest)){
                System.out.println("Found edge");
                return;
            }
            System.out.println("Not Edge found");
        }

        public void printGraph(){
            for (int i = 0; i < v; i++) {
                Iterator set = graph.get(i).iterator();
                while (set.hasNext()){
                    System.out.print(set.next()+" ");
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph =   new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

        graph.findEdge(2, 1);
        graph.findEdge(0, 3);
    }
}
