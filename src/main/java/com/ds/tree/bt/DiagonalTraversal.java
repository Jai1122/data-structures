package com.ds.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    public static void traverse(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            Node ltemp = temp;
            System.out.print(temp.data + " ");
            while (temp.right != null) {
                if (!queue.contains(temp.right)) {
                    queue.add(temp.right);
                }
                temp = temp.right;
            }
            if (ltemp.left != null) {
                queue.add(ltemp.left);
                if (ltemp.left.right != null) {
                    queue.add(ltemp.left.right);
                }
            }

        }

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);
        traverse(root);
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
