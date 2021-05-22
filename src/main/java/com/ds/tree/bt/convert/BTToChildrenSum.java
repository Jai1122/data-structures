package com.ds.tree.bt.convert;

public class BTToChildrenSum {

    private static Node convertToChildrenSumTree(Node node) {
        if (node == null) return node;
        convertToChildrenSumTree(node.left);
        convertToChildrenSumTree(node.right);

        if (node.left != null && node.right != null) {
            int childrensum = node.left.data + node.right.data;
            int diff = childrensum - node.data;
            if (diff > 0) {
                node.data = diff + node.data;
            }
            if (diff < 0) {
                increment(node, -diff);
            }
        }
        return node;
    }

    public static void increment(Node node, int diff) {
        if (node.left != null) {
            node.left.data += diff;
            increment(node.left, diff);
        } else if (node.right != null) {
            node.right.data += diff;
            increment(node.right, diff);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);
        inorder(convertToChildrenSumTree(root));
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
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
