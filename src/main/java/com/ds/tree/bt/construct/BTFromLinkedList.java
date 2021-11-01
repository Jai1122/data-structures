package com.ds.tree.bt.construct;

import java.util.LinkedList;
import java.util.Queue;

public class BTFromLinkedList {

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static Node constructTree(ListNode head) {
        if (head == null) return null;
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(head.data);
        queue.add(node);
        head = head.next;
        while (head != null) {
            Node parent = queue.poll();
            Node left, right = null;
            left = new Node(head.data);
            queue.add(left);
            head = head.next;
            if (head != null) {
                right = new Node(head.data);
                queue.add(right);
                head = head.next;
            }

            parent.left = left;
            parent.right = right;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(12);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(25);
        head.next.next.next.next = new ListNode(30);
        head.next.next.next.next.next = new ListNode(36);
        Node root = constructTree(head);
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

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
