package com.ds.graph;

import java.util.*;

public class TransitiveClosureWithDFS {
    LinkedList<Integer>[] adjList;
    int vertexCount;
    int[][] transitiveClosure;

    public TransitiveClosureWithDFS(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList =   new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjList[i] = new LinkedList<>();
            this.transitiveClosure = new int[this.vertexCount][this.vertexCount];
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void traverseBFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            ListIterator<Integer> listIterator = adjList[v].listIterator();
            System.out.print(v + " ");
            while (listIterator.hasNext()) {
                int i = listIterator.next();
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void dfsUtil(int start) {
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            traverseDFS(start, visited);
        }
    }

    private void traverseDFS(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        Iterator<Integer> listIterator = adjList[start].listIterator();
        while (listIterator.hasNext()) {
            int i = listIterator.next();
            if (!visited[i]) {
                traverseDFS(i, visited);
            }
        }
    }

    private void dfsUtil(int s, int v) {

        // Mark reachability from
        // s to v as true.
        if(s==v){
            if(adjList[v].contains(v))
                transitiveClosure[s][v] = 1;
        }
        else
            transitiveClosure[s][v] = 1;

        // Find all the vertices reachable
        // through v
        for (int adj : adjList[v]) {
            if (transitiveClosure[s][adj]==0) {
                dfsUtil(s, adj);
            }
        }
    }

    public void getTransitiveClosure() {
        for (int i = 0; i < vertexCount; i++) {
            dfsUtil(i, i);
        }

        for (int i = 0; i < vertexCount; i++) {
            System.out.println(Arrays.toString(transitiveClosure[i]));
        }
    }

    public static void main(String[] args) {
        TransitiveClosureWithDFS g   =   new TransitiveClosureWithDFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");

        g.getTransitiveClosure();
    }
}
