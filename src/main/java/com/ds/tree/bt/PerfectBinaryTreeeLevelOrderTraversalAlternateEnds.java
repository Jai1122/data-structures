package com.ds.tree.bt;

import java.util.ArrayList;
import java.util.List;

public class PerfectBinaryTreeeLevelOrderTraversalAlternateEnds {
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
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        root.left.left.left.left = new Node(16);
        root.left.left.left.right = new Node(17);
        root.left.left.right.left = new Node(18);
        root.left.left.right.right = new Node(19);
        root.left.right.left.left = new Node(20);
        root.left.right.left.right = new Node(21);
        root.left.right.right.left = new Node(22);
        root.left.right.right.right = new Node(23);
        root.right.left.left.left = new Node(24);
        root.right.left.left.right = new Node(25);
        root.right.left.right.left = new Node(26);
        root.right.left.right.right = new Node(27);
        root.right.right.left.left = new Node(28);
        root.right.right.left.right = new Node(29);
        root.right.right.right.left = new Node(30);
        root.right.right.right.right = new Node(31);
        printLevel(root);
    }

    public static List<Node> printGivenLevel(Node node, int level, List<Node> nodeList) {
        if (node == null) return null;
        if (level == 1) nodeList.add(node);
        printGivenLevel(node.left, level - 1, nodeList);
        printGivenLevel(node.right, level - 1, nodeList);

        return nodeList;
    }

    public static void printLevel(Node node) {
        int h = getHeight(node);
        for (int i = 1; i <= h; i++) {
            List<Node> nodeList = printGivenLevel(node, i, new ArrayList<>());
            if (nodeList.size() == 1) {
                System.out.print(nodeList.get(0).data + " ");
            } else {
                for (int start = 0, end = nodeList.size() - 1; start < nodeList.size() && end > 0 && start < end; start++, end--) {
                    System.out.print(nodeList.get(start).data + " " + nodeList.get(end).data + " ");
                }
            }
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
        }
    }

}
