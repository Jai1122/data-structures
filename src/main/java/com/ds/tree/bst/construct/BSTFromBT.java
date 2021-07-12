package com.ds.tree.bst.construct;

import java.util.ArrayList;
import java.util.Collections;

public class BSTFromBT {
    static ArrayList<Integer> list = new ArrayList<>();
    static int index    =   0;
    private static void inorderofBT(Node root) {
        if (root == null) return;
        inorderofBT(root.left);
        list.add(root.data);
        inorderofBT(root.right);
    }

    private static void inorderofBST(Node root) {
        if (root == null) return;
        inorderofBST(root.left);
        root.data = list.get(index++);
        inorderofBST(root.right);
    }

    public static void convertBTToBST(Node root) {
        inorderofBT(root);
        Collections.sort(list);
        System.out.println();
        inorderofBST(root);
        traverseInorder(root);
    }

    private static void traverseInorder(Node node) {
        if (node == null) return;
        traverseInorder(node.left);
        System.out.print(node.data + " ");
        traverseInorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        convertBTToBST(root);
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
