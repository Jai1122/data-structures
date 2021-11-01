package com.ds.tree.bst.construct;

public class BSTFromLevelOrder {

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    private static Node buildTree(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = buildTree(node.left, data);
        } else {
            node.right = buildTree(node.right, data);
        }

        return node;
    }

    public static Node constructBST(int[] arr) {
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildTree(root, arr[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] lvlOrder = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        inorder(constructBST(lvlOrder));
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
