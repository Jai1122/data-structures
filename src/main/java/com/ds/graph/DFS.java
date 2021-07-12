package com.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    static class Graph{
        int v;
        LinkedList<Integer> adj[];

        public Graph(int v){
            this.v  =   v;
            this.adj    =   new LinkedList[v];
            for (int i = 0; i < this.v; i++) {
                adj[i]  =   new LinkedList<>();
            }
        }

        public void addEdge(int i,int j){
            adj[i].add(j);
        }

        public void traverseDFS(int v, boolean[] visited){
            visited[v]  =   true;
            System.out.print(v+" ");
            Iterator<Integer>   iterator=   adj[v].listIterator();
            while (iterator.hasNext()){
                Integer integer =   iterator.next();
                if(!visited[integer]){
                    traverseDFS(integer,visited);
                }
            }
        }

        public void DFS(){
            boolean[] visited   =   new boolean[v];
            for (int i = 0; i < v; i++) {
                if (!visited[i]){
                    traverseDFS(i,visited);
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

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS();
    }
}
