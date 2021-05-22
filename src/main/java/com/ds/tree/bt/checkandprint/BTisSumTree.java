package com.ds.tree.bt.checkandprint;

import java.util.HashMap;
import java.util.Map;

public class BTisSumTree {

    static Map<Node, Integer> treeMap = new HashMap<>();
    static boolean flag = true;

    public static boolean isSumTree(Node node) {
        traverse(node);
        return true;
    }

    public static void traverse(Node node) {
        int height = getHeight(node);
        for (int i = height; i > 0; i--) {
            traverseLevel(node, i);
            System.out.println(flag);
        }
    }

    public static void traverseLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1) {
            System.out.print(node.data + " ");
            int lData = 0;
            int rData = 0;
            if (node.left != null) {
                lData = node.left.data;
            }
            if (node.right != null) {
                rData = node.right.data;
            }
            treeMap.put(node, node.data + lData + rData);
            int lSum = 0, rSum = 0;
            if (node.left != null) {
                lSum = treeMap.get(node.left);
            }
            if (node.right != null) {
                rSum = treeMap.get(node.right);
            }
            if (node.left != null || node.right != null) {
                if (node.data != lSum + rSum) {
                    flag = false;
                }
            }
        }
        traverseLevel(node.left, level - 1);
        traverseLevel(node.right, level - 1);
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);
        return 1 + Math.max(lHeight, rHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        isSumTree(root);
        //System.out.println(flag);
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
