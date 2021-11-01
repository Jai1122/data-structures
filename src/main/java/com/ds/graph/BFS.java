package com.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    static class Graph{

        private LinkedList<Integer> adj[];
        private int V;

        Graph(int v){
            V=  v;
            adj =   new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i]  =   new LinkedList<>();
            }
        }

        public void addEdge(int u,int v){
            adj[u].add(v);
        }

        public void bfsTraversal(int start){
            boolean[] visited = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();
            visited[start] = true;
            queue.add(start);
            while (!queue.isEmpty()){
                start   =   queue.poll();
                System.out.print(start+" ");
                Iterator<Integer> iterator  =   adj[start].iterator();
                while (iterator.hasNext()){
                    Integer i = iterator.next();
                    if(!visited[i]){
                        queue.add(i);
                        visited[i]  =   true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfsTraversal(2);
    }

}
