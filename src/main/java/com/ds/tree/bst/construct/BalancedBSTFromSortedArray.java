package com.ds.tree.bst.construct;

public class BalancedBSTFromSortedArray {

    static Node root;

    public static Node constructBBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (end + start) / 2;
        Node node = new Node(arr[mid]);
        node.left = constructBBST(arr, start, mid - 1);
        node.right = constructBBST(arr, mid + 1, end);
        return node;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        root = constructBBST(arr, 0, arr.length - 1);
        inorder(root);
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
