package com.ds.tree.bt.construct;

import java.util.LinkedList;
import java.util.Queue;

public class BTFromLevelOrderArray {

    public static Node constructTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int index = 0;
        Node root = new Node(arr[index++]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (index != arr.length) {
            Node parent = queue.poll();
            Node left, right = null;
            left = new Node(arr[index++]);
            queue.add(left);
            if (index != arr.length) {
                right = new Node(arr[index++]);
                queue.add(right);
            }
            parent.left = left;
            parent.right = right;
        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        Node root = constructTree(arr);
        inorder(root);
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
