package com.ds.tree.bt.construct;

import java.util.ArrayList;
import java.util.List;

public class TreeFromAncestorMatrix {

    public static Node constructTree(int[][] mat) {
        if (mat == null || mat.length == 0) return null;
        List<Node> nodeList = new ArrayList<>();
        boolean[] arr = new boolean[mat.length];
        for (int i = 0; i < mat.length; i++) {
            Node node = new Node(i);
            nodeList.add(node);
        }
        Node root = null;
        for (int i = 0; i < mat.length; i++) {
            int childCount = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    childCount++;
                    Node iNode = nodeList.get(i);
                    Node jNode = nodeList.get(j);
                    if (iNode.left == null && !arr[j]) {
                        iNode.left = jNode;
                        arr[j] = true;
                    } else if (iNode.right == null && !arr[j]) {
                        iNode.right = jNode;
                        arr[j] = true;
                    }
                }
            }
            if (childCount == i)
                root = nodeList.get(i);
        }

        return root;
    }

    private static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}
        };
        inorder(constructTree(mat));
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
