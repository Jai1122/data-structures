package com.ds.tree.bt.construct;

public class FullBinaryTreeFromPreOrderAndPreOrderMirror {

    static int preIndex = 0;

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] preMirror = {1, 3, 7, 6, 2, 5, 4};
        inorder(constructTree(pre, preMirror));
    }

    public static Node constructTree(int[] pre, int[] preMirror) {
        if (pre == null || pre.length == 0 || preMirror == null || pre.length != preMirror.length) return null;
        return constructNode(pre, preMirror, 0, pre.length - 1);
    }

    private static Node constructNode(int[] pre, int[] preMirror, int start, int end) {
        if (start > end || preIndex > pre.length) return null;
        Node root = new Node(pre[preIndex++]);
        if (start == end) return root;
        int index;
        for (index = start; index <= end; index++) {
            if (pre[preIndex] == preMirror[index]) break;
        }

        root.left = constructNode(pre, preMirror, index, end);
        root.right = constructNode(pre, preMirror, start + 1, index - 1);

        return root;
    }

    private static void inorder(Node node) {
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
