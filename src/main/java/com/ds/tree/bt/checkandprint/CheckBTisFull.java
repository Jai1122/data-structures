package com.ds.tree.bt.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBTisFull {

    public static boolean isFull(Node node){
        boolean full    =   true;
        Queue<Node> queue   =   new LinkedList<>();
        if (node == null) return full;
        queue.add(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if((temp.left==null && temp.right!=null)||(temp.left!=null && temp.right == null)){
                full = false;
                break;
            }
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
        return full;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(isFull(root));
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
