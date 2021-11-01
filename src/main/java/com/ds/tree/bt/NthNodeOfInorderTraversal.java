package com.ds.tree.bt;

public class NthNodeOfInorderTraversal {
    static int n = 0;

    public static void findNthNodeOfInorderTraversal(Node node) {
        if (node == null) return;
        //if(n-- == 0) System.out.print(node.data);
        if (n >= 0) {
            findNthNodeOfInorderTraversal(node.left);
            n--;
            if (n == 0)
                System.out.print(node.data + " ");
            findNthNodeOfInorderTraversal(node.right);
        }

    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        n = 4;
        inorder(root);
        System.out.println();
        findNthNodeOfInorderTraversal(root);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
