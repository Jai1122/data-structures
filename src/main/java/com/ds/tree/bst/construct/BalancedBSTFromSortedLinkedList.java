package com.ds.tree.bst.construct;

public class BalancedBSTFromSortedLinkedList {

    static class LNode{
        int data;
        LNode prev,next;

        public LNode(int data){
            this.data   =   data;
            prev = next = null;
        }
    }

    static class TNode{
        int data;
        TNode left,right;

        public TNode(int data){
            this.data   =   data;
            left = right    =   null;
        }
    }

    static LNode head = null;
    static TNode root = null;

    private static LNode pushLNode(int data){
        LNode lNode =   new LNode(data);
        if(head == null){
            head = lNode;
            return lNode;
        }
        LNode temp = head;
        while (temp!=null && temp.next != null){
            temp = temp.next;
        }
        temp.next   =   lNode;
        lNode.prev  =   temp;

        return lNode;
    }

    private static void printList(){
        LNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ->");
            temp    =   temp.next;
        }
    }

    private static void inorder(TNode node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    private static void printListInReverse(){
        LNode temp = head;
        while (temp!=null && temp.next!=null){
            temp    =   temp.next;
        }
        while (temp!=null){
            System.out.print(temp.data+" <-");
            temp    =   temp.prev;
        }
    }

    public static TNode buildBST(LNode start, LNode end){
        if(start == null || end == null || start.data > end.data) return null;
        LNode midNode = findMidNode(start,end);
        TNode node = new TNode(midNode.data);
        node.left   =   buildBST(start,midNode.prev);
        node.right  =   buildBST(midNode.next,end);
        return node;
    }

    private static LNode findMidNode(LNode start, LNode end){
        if(start.data == end.data) return start;
        LNode slowPointer = start;
        LNode fastPointer = start;

        while (fastPointer!= null && fastPointer.next!= null && fastPointer.data <= end.data){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        head = new LNode(1);
        pushLNode(2);
        pushLNode(3);
        pushLNode(4);
        pushLNode(5);
        pushLNode(6);
        System.out.println("List");
        printList();
        System.out.println();
        System.out.println("List in reverse");
        printListInReverse();
        System.out.println();
        LNode end = head;
        while (end !=null && end.next!=null){
            end = end.next;
        }
        System.out.println("Tree");
        root = buildBST(head,end);
        inorder(root);
    }
}
