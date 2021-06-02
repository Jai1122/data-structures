package com.ds.tree.bt.misc;

import java.util.ArrayList;
import java.util.List;

public class HeightFromParentArray {

    public static void findHeight(int[] array){
        Node root = buildTree(array);
        int height = getHeight(root);
        System.out.println("Tree Height is "+height);
    }

    private static int getHeight(Node node){
        if (node == null) return 0;
        int lHeight =   getHeight(node.left);
        int rHeight =   getHeight(node.right);

        return 1+ Math.max(lHeight,rHeight);
    }

    private static Node buildTree(int[] parentArray){
        List<Node> nodeList =   new ArrayList(parentArray.length);
        Node root = null;
        for (int i = 0; i < parentArray.length; i++) {
            Node node = new Node(i);
            nodeList.add(node);
        }
        for (int i = 0; i < parentArray.length; i++) {
            if (parentArray[i] == -1){
                root = nodeList.get(i);
                continue;
            }
            Node par = nodeList.get(parentArray[i]);
            if (par.left == null)
                par.left    = nodeList.get(i);
            else if(par.right == null)
                par.right   = nodeList.get(i);

        }

        return root;
    }

    public static void main(String[] args) {
        int[] parent = {1, 5, 5, 2, 2, -1, 3};
        findHeight(parent);
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
