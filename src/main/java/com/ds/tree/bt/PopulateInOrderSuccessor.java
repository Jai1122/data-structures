package com.ds.tree.bt;

//https://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/

public class PopulateInOrderSuccessor {
    static Node next = null;

    public static void populateInOrderNext(Node node) {
        if (node == null) {
            return;
        }

        populateInOrderNext(node.right);
        node.next = next;
        next = node;
        populateInOrderNext(node.left);
    }

    public static void inorderWithNext(Node node) {
        if (node == null) {
            return;
        }

        inorderWithNext(node.left);
        System.out.print(node.key);
        if (node.next != null) {
            System.out.print("(" + node.next.key + ") - ");
        }
        inorderWithNext(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        populateInOrderNext(root);
        inorderWithNext(root);
    }

    static class Node {
        int key;
        Node left, right, next;

        public Node(int key) {
            this.key = key;
            left = right = next = null;
        }
    }
}
