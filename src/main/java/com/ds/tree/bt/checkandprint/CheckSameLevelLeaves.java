package com.ds.tree.bt.checkandprint;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckSameLevelLeaves {

    static List<Node> nodeList = new LinkedList<>();

    public static boolean isSameLevel(Node root) {
        int h = getHeight(root);
        prepareNodeList(root, h);
        return checkLeafNodes(root);
    }

    public static boolean checkLeafNodes(Node node) {
        boolean isSameLevelLeaves = true;
        if (node == null) return isSameLevelLeaves;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left == null && temp.right == null) {
                if (!nodeList.contains(temp)) {
                    isSameLevelLeaves = false;
                    break;
                }
            }

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return isSameLevelLeaves;
    }

    public static void prepareNodeList(Node node, int level) {
        if (node == null) return;
        if (level == 1) {
            nodeList.add(node);
        }
        prepareNodeList(node.left, level - 1);
        prepareNodeList(node.right, level - 1);
    }

    public static int getHeight(Node node) {
        if (node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.left = new Node(3);
        root.right.right = new Node(1);
        System.out.println(isSameLevel(root));
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
