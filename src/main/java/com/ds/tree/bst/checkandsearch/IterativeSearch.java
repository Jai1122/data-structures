package com.ds.tree.bst.checkandsearch;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeSearch {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left   = insert(root.left,data);
        }else {
            root.right  = insert(root.right,data);
        }

        return root;
    }

    public static void traverseInorder(Node node){
        if(node == null) return;
        traverseInorder(node.left);
        System.out.print(node.data+" ");
        traverseInorder(node.right);
    }

    public static boolean find(Node node, int num){
        if(node == null) return false;
        Queue<Node> queue   =   new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data == num) return true;
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root,50);
        root = insert(root,30);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,70);
        root = insert(root,60);
        root = insert(root,80);
        System.out.println(find(root, 20));
    }
}
