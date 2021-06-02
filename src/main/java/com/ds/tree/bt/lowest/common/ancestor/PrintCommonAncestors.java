package com.ds.tree.bt.lowest.common.ancestor;

import java.util.ArrayList;
import java.util.List;

public class PrintCommonAncestors {

    static List<Node> nodeList1  =   new ArrayList<>();
    static List<Node> nodeList2  =   new ArrayList<>();

    public static void displayCommonAncestors(Node root, Node n1,Node n2){
        nodeList1.clear();
        nodeList2.clear();
        if (!findPath(root,n1,nodeList1)||!findPath(root,n2,nodeList2))
            return;
        int i=0;
        for (;i<nodeList1.size()&& i<nodeList2.size();i++){
            if (nodeList1.get(i).data == nodeList2.get(i).data){
                System.out.print(nodeList1.get(i).data+" ");
            }else {
                break;
            }
        }
        return;
    }

    private static boolean findPath(Node root, Node n1, List<Node> nodeList){
        if (root == null) return false;
        nodeList.add(root);
        if (root.data == n1.data)   return true;
        if (root.left!=null && findPath(root.left,n1,nodeList)) return true;
        if (root.right!=null && findPath(root.right,n1,nodeList)) return true;
        nodeList.remove(nodeList.size()-1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left   =   new Node(2);
        root.right  =   new Node(3);
        root.left.left  =   new Node(4);
        root.left.right =   new Node(5);
        root.right.left =   new Node(6);
        root.right.right    =   new Node(7);
        root.left.left.left  =   new Node(8);
        root.right.left.left    =   new Node(9);
        root.right.left.right    =   new Node(10);
        displayCommonAncestors(root,root.left.left.left,root.left.left);
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
