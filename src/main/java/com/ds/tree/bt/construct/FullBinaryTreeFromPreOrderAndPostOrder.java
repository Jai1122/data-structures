package com.ds.tree.bt.construct;

public class FullBinaryTreeFromPreOrderAndPostOrder {

    static int preIndex = 0;

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        Node root = constructTree(pre, post);
        inorder(root);
    }

    public static Node constructTree(int[] pre, int[] post) {
        if (pre == null || post == null || post.length == 0 || pre.length != post.length)
            return null;
        return constructNode(pre, post, 0, pre.length - 1, pre.length);
    }

    private static Node constructNode(int[] pre, int[] post, int start, int end, int size) {
        if (preIndex >= size || start > end) return null;
        Node root = new Node(pre[preIndex++]);
        if (start == end || preIndex >= size) return root;
        int i;
        for (i = start; i <= end; i++) {
            if (post[i] == pre[preIndex]) break;
        }

        if (i <= end) {
            root.left = constructNode(pre, post, start, i, size);
            root.right = constructNode(pre, post, i + 1, end, size);
        }

        return root;
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
