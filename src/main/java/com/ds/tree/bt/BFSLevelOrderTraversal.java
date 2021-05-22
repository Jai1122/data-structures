package com.ds.tree.bt;
//https://www.geeksforgeeks.org/level-order-tree-traversal/

import java.util.LinkedList;
import java.util.Queue;

/**
 * Two approaches are available.
 * 1) Using Recursion - Involves O(n^2) time and O(n) space
 * 2) Using queue and iterating - O(n) time and O(n) space
 */
public class BFSLevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        bfsLevelOrder(root);
    }

    public static void bfsLevelOrder(Node node) {
        if (node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
