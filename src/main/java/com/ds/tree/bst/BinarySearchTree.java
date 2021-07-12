package com.ds.tree.bst;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data   =   data;
            left = right = null;
        }
    }

    public Node insert(int data, Node root){
        if (root == null){
            root = new Node(data);
            return root;
        }

        if (data < root.data){
            root.left   =   insert(data, root.left);
        }else{
            root.right  =   insert(data, root.right);
        }

        return root;
    }

    private int minValue(Node node){
        int minV    =   node.data;
        while(node.left!=null){
            node = node.left;
            minV = node.data;
        }
        return minV;
    }

    public Node delete(int data, Node root){
        if (root == null) return root;
        if(root.data == data){
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right == null){
                root.data = root.left.data;
                root.left = null;
            }else if(root.left == null){
                root.data = root.right.data;
                root.right  =   null;
            }else{
                root.data   =   minValue(root.right);
                delete(root.data,root.right);
            }
        }else if(data < root.data){
            root.left   =   delete(data,root.left);
        }else if(data > root.data){
            root.right  =   delete(data,root.right);
        }
        return root;
    }

    public Node search(int data, Node root){
        if (root == null || root.data == data) return root;
        if (data<root.data){
            search(data, root.left);
        }else {
            search(data,root.right);
        }
        return null;
    }

    public void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public void preorder(Node node){
        if (node == null) return;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3, root);
        bst.insert(10, root);
        bst.insert(1, root);
        bst.insert(6, root);
        bst.insert(14, root);
        bst.inorder(root);
        bst.delete(1,root);
        System.out.println();
        bst.inorder(root);
    }

}
