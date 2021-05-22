package com.ds.tree.bt.construct;

import java.util.Stack;

public class BTFromStringBracket {

    static int index = 0;
    static Stack<Character> stack = new Stack<>();


    public static Node constructTree(String order, int start, int end) {
        if (start > end) return null;
        Node node = new Node(Integer.parseInt("" + order.charAt(start)));
        int index = -1;

        if (start + 1 <= end && order.charAt(start + 1) == '(') {
            index = findIndex(order, start + 1, end);
        }
        if (index != -1) {
            node.left = constructTree(order, start + 2, index - 1);
            node.right = constructTree(order, index + 2, end - 1);
        }

        return node;
    }

    private static int findIndex(String order, int start, int end) {
        if (start > end)
            return -1;
        Stack<Character> stack = new Stack<>();

        for (int i = start; start <= end; i++) {
            if (order.charAt(i) == '(') {
                stack.push(order.charAt(i));
            } else if (order.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                }
                if (stack.isEmpty()) return i;
            }
        }

        return -1;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        String order = "4(2(3)(1))(6(5))";
        Node root = constructTree(order, 0, order.length() - 1);
        inorder(root);
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
