package com.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KosarajuAlgorithm {

    int vertexCount;
    LinkedList<Integer>[] adj;

    public KosarajuAlgorithm(int vertexCount) {
        this.vertexCount = vertexCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        KosarajuAlgorithm graph = new KosarajuAlgorithm(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.printStronglyConnectedComponents();
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    public void traverseBFS(int start) {
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            Iterator<Integer> iterator = adj[v].listIterator();
            System.out.print(v + " ");
            while (iterator.hasNext()) {
                int i = iterator.next();
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void traverseDFS(int start) {
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            dfsUtil(start, visited);
        }
    }

    private void dfsUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        Iterator<Integer> iterator = adj[start].listIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (!visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    private KosarajuAlgorithm getTranspose() {
        KosarajuAlgorithm transposeGraph = new KosarajuAlgorithm(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            Iterator<Integer> iterator = adj[i].listIterator();
            while (iterator.hasNext()) {
                transposeGraph.adj[iterator.next()].add(i);
            }
        }

        return transposeGraph;
    }

    private void fillStack(int start, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;
        Iterator<Integer> iterator = adj[start].listIterator();
        while (iterator.hasNext()) {
            int vertex = iterator.next();
            if (!visited[vertex]) {
                fillStack(vertex, visited, stack);
            }
        }
        stack.push(start);
    }

    public void printStronglyConnectedComponents() {
        boolean[] visited = new boolean[vertexCount];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertexCount; i++) {
            if(!visited[i])
                fillStack(i, visited, stack);
        }

        KosarajuAlgorithm transposedGraph = getTranspose();
        for (int i = 0; i < vertexCount; i++) {
            visited[i] = false;
        }

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                transposedGraph.dfsUtil(vertex, visited);
                System.out.println();
            }
        }
    }
}
