package com.ds.tree.bt.checkandprint;

public class TraversalOfSameTree {

    static int preIndex = 0;
    static int postIndex = 0;
    static int[] postOrderTraversal;

    private static Node constructTree(int[] in, int[] pre, int start, int end) {
        if (start > end) return null;
        Node node = new Node(pre[preIndex++]);
        int iIndex = 0;
        for (int i = start; i <= end; i++) {
            if (in[i] == node.data) {
                iIndex = i;
                break;
            }
        }

        node.left = constructTree(in, pre, start, iIndex - 1);
        node.right = constructTree(in, pre, iIndex + 1, end);
        return node;
    }

    private static Node constructTreeFromInorderAndPreOrder(int[] in, int[] pre) {
        return constructTree(in, pre, 0, in.length - 1);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postOrderTraversal[postIndex++] = node.data;
    }

    public static void main(String[] args) {
        int[] in = {4, 2, 5, 1, 3};
        int[] pre = {1, 2, 4, 5, 3};
        int[] post = {4, 5, 2, 3, 1};
        postOrderTraversal = new int[post.length];
        Node root = constructTreeFromInorderAndPreOrder(in, pre);
        postOrder(root);
        boolean flag = true;
        for (int i = 0; i < post.length; i++) {
            if (post[i] != postOrderTraversal[i])
                flag = false;
        }
        System.out.println(flag);
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
