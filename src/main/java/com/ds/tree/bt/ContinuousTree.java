//https://www.geeksforgeeks.org/continuous-tree/
package com.ds.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

public class ContinuousTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(41);
        root.left.left = new Node(1);
        root.left.right = new Node(10);
        root.right.right = new Node(5);
        if (isContinuous(root)) System.out.println("Yes");
        else System.out.println("No");

    }

    public static boolean isContinuous(Node node) {
        if (node == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null) {
                if (Math.abs(temp.data - temp.left.data) == 1) {
                    queue.add(temp.left);
                } else {
                    return false;
                }
            }
            if (temp.right != null) {
                if (Math.abs(temp.data - temp.right.data) == 1) {
                    queue.add(temp.right);
                } else {
                    return false;
                }
            }
        }
        return true;
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
