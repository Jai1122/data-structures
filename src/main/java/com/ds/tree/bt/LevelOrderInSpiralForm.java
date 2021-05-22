package com.ds.tree.bt;

public class LevelOrderInSpiralForm {

    public static void printLevelOrder(Node node) {
        int h = findHeight(node);
        boolean ltr = false;
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i, ltr);
            ltr = !ltr;
        }
    }

    public static void printGivenLevel(Node node, int level, boolean ltr) {
        if (node == null) return;
        if (level == 1) System.out.print(node.data + " ");
        if (ltr) {
            printGivenLevel(node.left, level - 1, ltr);
            printGivenLevel(node.right, level - 1, ltr);
        } else {
            printGivenLevel(node.right, level - 1, ltr);
            printGivenLevel(node.left, level - 1, ltr);
        }
    }

    public static int findHeight(Node node) {
        if (node == null) return 0;
        int lheight = findHeight(node.left);
        int rheight = findHeight(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        printLevelOrder(root);
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
