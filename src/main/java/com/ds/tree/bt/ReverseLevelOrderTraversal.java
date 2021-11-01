package com.ds.tree.bt;

public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printLevelOrder(root);
    }

    public static void printLevelOrder(Node node) {
        int h = getHeight(node);

        for (int i = h; i >= 1; i--) {
            printGivenLevel(node, i);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1) System.out.print(node.data + " ");
        printGivenLevel(node.left, level - 1);
        printGivenLevel(node.right, level - 1);
    }

    public static int getHeight(Node node) {
        if (node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return Math.max(lHeight, rHeight) + 1;

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
