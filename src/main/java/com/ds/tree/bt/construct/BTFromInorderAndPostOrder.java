package com.ds.tree.bt.construct;

public class BTFromInorderAndPostOrder {

    static int postIndex = 0;

    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        postIndex = post.length - 1;
        inorder(constructTree(in, post));
    }

    public static Node constructTree(int[] in, int[] post) {
        return constructNode(in, post, 0, post.length - 1);
    }

    public static Node constructNode(int[] in, int[] post, int start, int end) {
        if (start > end) return null;
        Node node = new Node(post[postIndex--]);
        if (start == end) return node;
        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if (post[postIndex + 1] == in[i]) {
                inIndex = i;
                break;
            }
        }
        node.right = constructNode(in, post, inIndex + 1, end);
        node.left = constructNode(in, post, start, inIndex - 1);


        return node;
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
