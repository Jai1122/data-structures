package com.ds.tree.bst.construct;

public class BSTToBT {

    static int sum = 0;
    static Node root;

    private static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void convertToBT(Node node) {
        if (node == null) return;
        convertToBT(node.right);
        sum = sum + node.data;
        node.data = sum;
        convertToBT(node.left);
    }

    public static void main(String[] args) {
        root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(13);
        inorder(root);
        System.out.println();
        convertToBT(root);
        inorder(root);
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
