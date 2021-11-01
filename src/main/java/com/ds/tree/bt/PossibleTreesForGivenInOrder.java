package com.ds.tree.bt;

//https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class PossibleTreesForGivenInOrder {
    public static void main(String[] args) {
        int[] in = {4, 5, 7};
        List<Node> trees = getTrees(in, 0, in.length - 1);
        trees.forEach(root -> {
            System.out.println();
            preorder(root);
        });
    }

    public static List<Node> getTrees(int[] in, int start, int end) {
        List<Node> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<Node> leftTree = getTrees(in, start, i - 1);
            List<Node> rightTree = getTrees(in, i + 1, end);

            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    Node node = new Node(in[i]);
                    node.left = leftTree.get(j);
                    node.right = rightTree.get(k);
                    trees.add(node);
                }
            }
        }

        return trees;
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
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
