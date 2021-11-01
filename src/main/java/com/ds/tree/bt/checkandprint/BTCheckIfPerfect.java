package com.ds.tree.bt.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class BTCheckIfPerfect {

    static int leafLevel = 0;
    static boolean sameLevel = true;

    public static boolean checkInteriorNodes(Node node) {
        Node root = node;
        if (node == null) return true;
        boolean hasTwoChilds    =   true;
        Queue<Node> queue   =   new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left == null && temp.right == null){
                int level = getLevel(root,temp);
                if(leafLevel!=level){
                    sameLevel   =   false;
                    break;
                }
            }
            if((temp.left!=null && temp.right==null)|| (temp.left==null&& temp.right!=null)){
                hasTwoChilds = false;
                break;
            }
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return hasTwoChilds;
    }

    public static int getLevel(Node root, Node node) {
        if (root == null) return 0;
        if (root == node) return 0;
        int llevel = getLevel(root.left, node);
        if (llevel != 0) return llevel;
        return getLevel(node.right, node);
    }

    public static boolean isPerfect(Node node) {
        initLevel(node);
        return checkInteriorNodes(node);
    }

    public static void initLevel(Node node){
        if (node == null) return;
        while (node.left!=null){
            leafLevel++;
            node = node.left;
        }
        System.out.println(leafLevel);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        System.out.println(isPerfect(root));
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
