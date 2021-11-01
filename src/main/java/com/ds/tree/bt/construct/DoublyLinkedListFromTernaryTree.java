package com.ds.tree.bt.construct;

//TODO: Check this
public class DoublyLinkedListFromTernaryTree {

    public static ListNode constructDLL(Node treeNode, ListNode listNode) {
        if (treeNode == null) return listNode;
        listNode = new ListNode(treeNode.data);
        return null;
    }

    public static void printDLL(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(5);
        root.middle = new Node(11);
        root.right = new Node(63);
        root.left.left = new Node(1);
        root.left.middle = new Node(4);
        root.left.right = new Node(8);
        root.middle.left = new Node(6);
        root.middle.middle = new Node(7);
        root.middle.right = new Node(15);
        root.right.left = new Node(31);
        root.right.middle = new Node(55);
        root.right.right = new Node(65);
        // printDLL(constructDLL(root));
    }

    static class Node {
        int data;
        Node left, middle, right;

        public Node(int data) {
            this.data = data;
            left = right = middle = null;
        }
    }

    static class ListNode {
        int data;
        ListNode prev;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            prev = next = null;
        }
    }
}
