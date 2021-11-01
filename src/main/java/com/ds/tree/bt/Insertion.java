package com.ds.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
public class Insertion {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        preorder(root);
        insert(root, 12);
        System.out.println();
        preorder(root);

    }

    private static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private static void insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
