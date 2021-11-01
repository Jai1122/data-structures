package com.ds.tree.bt;

import java.util.Stack;

public class IterativePostOrderTraversalSet1 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        postorder(root);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> stackStore = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            stackStore.push(temp);
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }

        while (!stackStore.isEmpty()) {
            System.out.print(stackStore.pop().data + " ");
        }
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
