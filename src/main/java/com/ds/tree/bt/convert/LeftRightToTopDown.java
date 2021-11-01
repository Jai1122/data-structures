package com.ds.tree.bt.convert;

public class LeftRightToTopDown {

    public static void convert(Node node) {
        if (node == null) return;
        convert(node.left);
        convert(node.right);
        if (node.left == null) {
            node.left = node.right;
        } else {
            node.left.right = node.right;
        }
        node.right = null;
    }

    public static void topDown(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        topDown(node.right);
        topDown(node.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(6);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(8);
        convert(root);
        topDown(root);
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
