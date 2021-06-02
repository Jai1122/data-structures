package com.ds.tree.bt.misc;

import java.util.*;

public class CustomTree {

    public static void printForest(String[] links){
        List<Node> forest = prepareForest(links);
        for(Node root:forest){
            printTree(root);
            System.out.println();
        }
    }

    private static void printTree(Node node){
        if (node == null) return;
        Queue<Node> queue   =   new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }

    }

    private static List<Node> prepareForest(String[] links){
        List<Node> treeList =   new ArrayList<>();
        Map<Character,Integer> map=    new HashMap<>();

        for (int i = 0; i < links.length; i++) {
            Node source = new Node(links[i].charAt(0));
            Node target = new Node(links[i].charAt(2));
            int index = 0;
            if(map.containsKey(source.data)){
                index   =   map.get(source.data);
                Node node = treeList.get(index);
                Node sourceNodeInTree = findNode(node,source);
                if (sourceNodeInTree.left == null){
                    sourceNodeInTree.left   =   target;
                }else {
                    sourceNodeInTree.right = target;
                }
                map.put(target.data,index);
            }else {
                source.left =   target;
                treeList.add(source);
                map.put(source.data, treeList.size()-1);
                map.put(target.data, treeList.size()-1);
            }
        }

        return treeList;
    }

    private static Node findNode(Node node, Node source){
        if (node == null) return null;
        Queue<Node> queue   =   new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if (temp.data == source.data){
                return temp;
            }
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }
        return null;
    }

    public static void main(String[] args) {
        String[] links1 = {"a b", "b c", "b d", "a e"};
        System.out.println("------------ Forest 1 ----------------");
        printForest(links1);
        String[] links2 = {"a b", "a g", "b c", "c d", "d e", "c f",
                "z y", "y x", "x w"};
        System.out.println("------------ Forest 2 ----------------");
        printForest(links2);
    }

    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            left = right = null;
        }
    }
}
