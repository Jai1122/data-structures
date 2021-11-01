//https://www.geeksforgeeks.org/deletion-binary-tree/

package com.ds.tree.bt;

public class Deletion {
    public static void main(String[] args) {
        Node root = new Node(10);
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        inorder(root);
        deleteByReplacingLastLeaf(root, 11);
        System.out.println();
        inorder(root);
    }

    public static void deleteByReplacingLastLeaf(Node root, int data) {
        Node node = root;
        if (node == null) return;
        int replacement = deleteLastNode(node);
        traverse(node, data, replacement);
    }

    public static void traverse(Node node, int data, int replacement) {
        if (node == null) return;
        if (node.data == data) {
            node.data = replacement;
        }
        traverse(node.left, data, replacement);
        traverse(node.right, data, replacement);
    }

    public static int deleteLastNode(Node root) {
        if (root == null) return -1;
        int returnData = -1;
        Node node = root;
        Node temp = root;
        while (node.right != null) {
            temp = node;
            node = node.right;
        }
        if (node.left == null) {
            returnData = node.data;
            temp.right = null;
            return returnData;
        }
        returnData = node.left.data;
        node.left = null;
        return returnData;
    }

    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
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
