package com.ds.tree.bt.construct;

//https://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/

import java.util.ArrayList;
import java.util.List;

public class SpecialTreeFromPreOrder {


    public static Node constructTree(int[] pre, char[] preLN) {
        if (pre == null || preLN == null || pre.length == 0 || pre.length != preLN.length) return null;
        int preIndex = 0;
        Node root = new Node(pre[preIndex]);
        List<Node> nodeList = new ArrayList<>();
        if (preLN[preIndex] == 'N') {
            nodeList.add(root);
        } else {
            return root;
        }
        for (preIndex = 1; preIndex < pre.length; preIndex++) {
            Node node = new Node(pre[preIndex]);
            Node prev = nodeList.get(nodeList.size() - 1);
            if (prev.left == null) {
                prev.left = node;
            } else {
                prev.right = node;
            }
            if (prev.left != null && prev.right != null) {
                nodeList.remove(prev);
            }
            if (preLN[preIndex] == 'N' && (node.left == null || node.right == null)) {
                nodeList.add(node);
            }
            if (nodeList.isEmpty()) break;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        char[] preLN = {'N', 'N', 'N', 'L', 'L', 'L', 'N', 'L', 'L'};
        preorder(constructTree(pre, preLN));
    }

    private static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
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
