package com.ds.tree.bt.convert;

public class BTToDLLSet1 {

    static ListNode tail = null;
    static ListNode head = tail;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        convertBTToDLL(root);
        printList();
    }

    public static void convertBTToDLL(TreeNode treeNode) {
        if (treeNode == null) return;

        convertBTToDLL(treeNode.left);

        if (tail == null) {
            tail = new ListNode(treeNode.data);
            head = tail;
        } else {
            ListNode next = new ListNode(treeNode.data);
            tail.next = next;
            next.prev = tail;
            tail = next;
        }

        convertBTToDLL(treeNode.right);

    }

    public static void printList() {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class ListNode {
        int data;
        ListNode prev, next;

        public ListNode(int data) {
            this.data = data;
            prev = next = null;
        }
    }
}
