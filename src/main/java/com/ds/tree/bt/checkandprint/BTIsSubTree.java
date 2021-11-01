package com.ds.tree.bt.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class BTIsSubTree {

    public static Node findNode(Node source, Node target){
        Node targetNode = null;
        if (source == null || target == null) return targetNode;

        Queue<Node> queue   =   new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data == target.data){
                targetNode  =   temp;
                break;
            }
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
        return targetNode;
    }

    public static boolean isSame(Node source, Node target){
        if (source == null || target == null) return false;
        boolean same    =   true;
        Queue<Node> sourceQueue=  new LinkedList<>();
        Queue<Node> targetQueue=  new LinkedList<>();

        sourceQueue.add(source);
        targetQueue.add(target);

        while (!sourceQueue.isEmpty() && !targetQueue.isEmpty()){
            Node temp1  =   sourceQueue.poll();
            Node temp2  =   targetQueue.poll();

            if(temp1.data != temp2.data){
                same = false;
                break;
            }

            if(temp1.left!=null){
                if(temp2.left!=null){
                    sourceQueue.add(temp1.left);
                    targetQueue.add(temp2.left);
                }else{
                    same = false;
                    break;
                }
            }

            if(temp1.right!=null){
                if(temp2.right!=null){
                    sourceQueue.add(temp1.right);
                    targetQueue.add(temp2.right);
                }else{
                    same = false;
                    break;
                }
            }
        }

        if (!targetQueue.isEmpty()) same =   false;

        return same;
    }

    public static boolean isSubTree(Node source, Node target){
        Node targetNode = findNode(source,target);
        return  isSame(targetNode,target);
    }

    public static void main(String[] args) {
        Node root1  =   new Node('x');
        root1.left  =   new Node('a');
        root1.right =   new Node('b');
        root1.left.right  =   new Node('c');

        Node root2 = new Node('z');
        root2.left  =   new Node('x');
        root2.right =   new Node('e');
        root2.right.right   =   new Node('k');
        root2.left.left =   new Node('a');
        root2.left.right    =   new Node('b');
        root2.left.left.right   =   new Node('c');
        System.out.println(isSubTree(root2,root1));
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
