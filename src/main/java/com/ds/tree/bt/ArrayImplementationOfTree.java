package com.ds.tree.bt;
//https://www.geeksforgeeks.org/binary-tree-array-implementation/

/**
 * if (say)father=p;
 * then left_son=(2*p)+1;
 * and right_son=(2*p)+2;
 */

public class ArrayImplementationOfTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setRoot("A");
        //tree.setLeft("B",0);
        tree.setRight("C", 0);
        tree.setLeft("D", 1);
        tree.setRight("E", 1);
        tree.setRight("F", 2);
        tree.printTree();
    }

    static class Tree {
        int root = 0;
        String[] str = new String[10];

        public void setRoot(String key) {
            str[0] = key;
        }

        public void setLeft(String data, int root) {
            if (str[root] == null) return;
            str[(2 * root) + 1] = data;
        }

        public void setRight(String data, int root) {
            if (str[root] == null) return;
            str[(2 * root) + 2] = data;
        }

        public void printTree() {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null)
                    System.out.print(str[i] + " ");
                else
                    System.out.print("-");
            }
        }
    }
}