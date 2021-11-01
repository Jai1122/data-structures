package com.ds.tree.bst.construct;

public class BSTFromPreOrder {

    private static Node node;

    private static Node createNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        }
        if (node.data > data) {
            node.left = createNode(node.left, data);
        }

        if (node.data < data) {
            node.right = createNode(node.right, data);
        }

        return node;
    }

    public static void create(int data) {
        node = createNode(node, data);
    }

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 1, 7, 40, 50};
        for (int i = 0; i < arr.length; i++) {
            create(arr[i]);
        }
        preorder(node);
    }

    static class Node {
        private final int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
