package com.ds.tree.bst.construct;

import java.util.LinkedList;
import java.util.Queue;

public class BSTToMinHeap {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static int[] arr;
    static int index    =   0;
    static Node root;

    private static void fillArray(Node node){
        if (node == null) return;
        fillArray(node.left);
        arr[index++] = node.data;
        fillArray(node.right);
    }

    private static Node buildHeap(Node node){
        Queue<Node> queue    =   new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            temp.data   =   arr[index++];
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }

        return node;
    }

    private static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public static Node convertToMinHeap(Node node){
        fillArray(node);
        index = 0;
        node = buildHeap(node);
        return node;
    }

    public static void main(String[] args) {
        root = new Node(8);
        root.left   =   new Node(4);
        root.right  =   new Node(12);
        root.left.left  =   new Node(2);
        root.left.right =   new Node(6);
        root.right.left =   new Node(10);
        root.right.right    =   new Node(14);
        arr = new int[7];
        System.out.println("Tree");
        inorder(root);
        Node node   =   convertToMinHeap(root);
        System.out.println("\n Min Heap");
        inorder(node);
    }
}
