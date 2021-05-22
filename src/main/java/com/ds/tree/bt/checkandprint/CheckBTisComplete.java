package com.ds.tree.bt.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBTisComplete {


    public static boolean isComplete(Node node){
        if (node == null) return true;
        boolean flag = false;
        Queue<Node> queue   =   new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left!=null){
                if(flag) return false;
                queue.add(temp.left);
            }else{
                flag = true;
            }

            if(temp.right!=null){
                if(flag) return false;
                queue.add(temp.right);
            }else {
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left   =   new Node(2);
        root.right  =   new Node(3);
        root.left.left  =   new Node(4);
        System.out.println(isComplete(root));
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
