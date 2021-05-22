package com.ds.tree.bt;

public class NthNodeOfPostOrderTraversal {
    static int n = 0;

    public static void findNthNodeOfPostOrderTraversal(Node node) {
        if (node == null) return;
        if (n > 0) {
            findNthNodeOfPostOrderTraversal(node.left);
            findNthNodeOfPostOrderTraversal(node.right);
            n--;
            if (n == 0)
                System.out.print(node.data);
        }
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        n = 4;
        postorder(root);
        System.out.println();
        findNthNodeOfPostOrderTraversal(root);

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
