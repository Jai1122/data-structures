package com.ds.tree.bst;

public class BSTFromPreOrderSet1 {

    static Node node;

    public static void main(String[] args) {
        int[] nodeData = {10, 5, 1, 7, 40, 50};
        for (int i = 0; i < nodeData.length; i++) {
            createNode(nodeData[i]);
        }
        inorder(node);
    }

    public static void createNode(int key) {
        node = createBSTNode(node, key);
    }

    public static Node createBSTNode(Node node, int key) {
        if (node == null) {
            node = new Node(key);
        }
        if (node.data > key) {
            node.left = createBSTNode(node.left, key);
        }
        if (node.data < key) {
            node.right = createBSTNode(node.right, key);
        }

        return node;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
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
