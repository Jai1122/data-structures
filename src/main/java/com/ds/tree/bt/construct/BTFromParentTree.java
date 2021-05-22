package com.ds.tree.bt.construct;

import java.util.ArrayList;
import java.util.List;

public class BTFromParentTree {

    public static Node constructTree(int[] parent) {

        List<Node> nodeList = new ArrayList<>();
        Node root = null;
        for (int i = 0; i < parent.length; i++) {
            Node node = new Node(i);
            nodeList.add(node);
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                root = nodeList.get(i);
                continue;
            }
            Node par = nodeList.get(parent[i]);
            if (par.left == null) {
                par.left = nodeList.get(i);
            } else if (par.right == null) {
                par.right = nodeList.get(i);
            }
        }
        return root;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 3, 5};
        inorder(constructTree(parent));
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
