package com.ds.tree.bt.construct;

public class BTFromInorderandPreorder {

    static int preIndex = 0;

    public static void main(String[] args) {
        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        Node root = constructTree(in, pre, 0, in.length - 1);
        inorder(root);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static Node constructTree(char[] in, char[] pre, int start, int end) {
        if (start > end) return null;

        Node node = new Node(pre[preIndex++]);
        if (start == end) return node;

        int inIndex = search(in, start, end, node.data);
        node.left = constructTree(in, pre, start, inIndex - 1);
        node.right = constructTree(in, pre, inIndex + 1, end);

        return node;
    }

    public static int search(char[] in, int start, int end, char data) {
        int i;
        for (i = start; start < end; i++) {
            if (in[i] == data) {
                return i;
            }
        }

        return i;
    }

    static class Node {
        char data;
        Node left, right;

        public Node(char key) {
            this.data = key;
            left = right = null;
        }
    }
}
