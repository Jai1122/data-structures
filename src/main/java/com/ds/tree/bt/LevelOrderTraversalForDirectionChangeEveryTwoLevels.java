package com.ds.tree.bt;

public class LevelOrderTraversalForDirectionChangeEveryTwoLevels {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(1);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(2);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(2);
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.right.left.right.left = new Node(18);
        root.right.right.left.right = new Node(19);
        printLevelOrder(root);
    }

    public static void printLevelOrder(Node node) {
        int h = getHeight(node);
        boolean ltr = true;
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i, ltr);
            if (i % 2 == 0) ltr = !ltr;
            System.out.println();
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
