package com.ds.tree.bt.construct;

import java.util.Vector;

public class kAryTreeFromPreOrder {

    static int ind = 0;

    public static Node constructNode(int[] pre, int k, int n, int height) {
        if (n <= 0) return null;
        Node node = new Node(pre[ind]);

        for (int i = 0; i < k; i++) {
            if (ind < n - 1 && height > 1) {
                ind++;
                node.children.add(constructNode(pre, k, n, height - 1));
            } else {
                node.children.add(null);
            }
        }

        return node;
    }

    public static Node constructTree(int[] pre, int k, int n, int in) {
        int height = (int) Math.ceil(Math.log((double) n * (k - 1) + 1) / Math.log(k));
        ind = in;
        return constructNode(pre, k, n, height);
    }

    public static void postOrder(Node node, int k) {
        if (node == null) return;
        for (int i = 0; i < k; i++) {
            postOrder(node.children.get(i), k);
        }
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        int ind = 0, n = 10, k = 3;
        postOrder(constructTree(preorder, k, n, ind), k);
    }

    static class Node {
        int data;
        Vector<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new Vector<>();
        }
    }
}
