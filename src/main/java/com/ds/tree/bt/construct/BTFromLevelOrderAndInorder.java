package com.ds.tree.bt.construct;

public class BTFromLevelOrderAndInorder {

    public static void main(String[] args) {
        int[] in = new int[]{4, 8, 10, 12, 14, 20, 22};
        int[] level = new int[]{20, 8, 22, 4, 12, 10, 14};

        Node root = constructTree(in, level);
        inorder(root);
    }

    public static Node constructTree(int[] in, int[] level) {
        Node startNode = null;
        return constructNode(startNode, level, in, 0, in.length - 1);
    }

    public static Node constructNode(Node startNode, int[] level, int[] in, int start, int end) {
        if (start > end) return null;
        if (start == end) return new Node(in[start]);

        boolean found = false;
        int index = 0;

        for (int i = 0; i < level.length - 1; i++) {
            int data = level[i];
            for (int j = start; j < end; j++) {
                if (data == in[j]) {
                    startNode = new Node(data);
                    index = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        startNode.left = constructNode(startNode, level, in, start, index - 1);
        startNode.right = constructNode(startNode, level, in, index + 1, end);
        return startNode;
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
