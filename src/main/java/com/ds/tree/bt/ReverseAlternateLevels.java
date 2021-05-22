package com.ds.tree.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseAlternateLevels {
    public static List<Node> printGivenLevel(Node node, int level, List<Node> nodeList) {
        if (node == null) return null;
        if (level == 1) nodeList.add(node);
        printGivenLevel(node.left, level - 1, nodeList);
        printGivenLevel(node.right, level - 1, nodeList);
        return nodeList;
    }

    public static void printLevels(Node node) {
        int h = getHeight(node);
        for (int i = 1; i <= h; i++) {
            List<Node> nodeList = printGivenLevel(node, i, new ArrayList<Node>());
            if (nodeList != null && !nodeList.isEmpty()) {
                if (nodeList.size() == 1) {
                    //System.out.print(nodeList.get(0).data + " ");
                } else {
                    for (int start = 0, end = nodeList.size() - 1; start <= end; start++, end--) {
                        if (i % 2 == 0) {
                            char startData = nodeList.get(start).data;
                            char endData = nodeList.get(end).data;
                            char temp = startData;
                            nodeList.get(start).data = endData;
                            nodeList.get(end).data = temp;
                        }
                        //System.out.print(nodeList.get(start).data + " " + nodeList.get(end).data + " ");
                    }
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

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void levelOrder(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');
        root.right.right = new Node('g');
        root.left.left.left = new Node('h');
        root.left.left.right = new Node('i');
        root.left.right.left = new Node('j');
        root.left.right.right = new Node('k');
        root.right.left.left = new Node('l');
        root.right.left.right = new Node('m');
        root.right.right.left = new Node('n');
        root.right.right.right = new Node('o');
        System.out.println("Before");
        inorder(root);
        System.out.println();
        printLevels(root);
        System.out.println("After");
        inorder(root);
        System.out.println();
    }

    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            left = right = null;
        }
    }
}
