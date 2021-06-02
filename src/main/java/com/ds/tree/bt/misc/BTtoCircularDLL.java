package com.ds.tree.bt.misc;

public class BTtoCircularDLL {

    static ListNode listHead = null;
    static ListNode listNext = null;

    public static void convertTreeToDLL(TreeNode treeNode){
        convert(treeNode,null);

        System.out.println("List Head "+listHead.data);
        System.out.println("List Tail "+listNext.data);
        System.out.println();
        listHead.prev   =   listNext;
        listNext.next   =   listHead;
    }

    private static void convert(TreeNode treeNode, ListNode listNode) {
        if (treeNode == null) return;
        convert(treeNode.left, listNode);
        listNode = new ListNode(treeNode.data);
        if(listHead == null){
            listHead = listNode;
            listNext = listHead;
        }else {
            listNode.prev   =   listNext;
            listNext.next   =   listNode;
            listNext    =   listNext.next;
        }
        convert(treeNode.right, listNode);
    }

    private static void printDLL(ListNode listNode){
        int init = listNode.data;
        while (listNode!=null){
            System.out.print(listNode.data+" ");
            listNode    =   listNode.next;
            if (listNode.data == init)
                break;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        convertTreeToDLL(root);
        printDLL(listHead);
    }

    static class ListNode {
        int data;
        ListNode prev, next;

        public ListNode(int data) {
            this.data = data;
            prev = next = null;
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
}
