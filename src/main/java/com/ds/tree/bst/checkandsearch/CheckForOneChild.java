package com.ds.tree.bst.checkandsearch;

public class CheckForOneChild {

    private static boolean isOneChild(int[] pre) {
        boolean flag = false;
        for (int i = 0; i < pre.length - 1; i++) {
            if(!isAllLesser(pre, i, pre[i]) && !isAllGreater(pre, i, pre[i])){
                return false;
            }
        }
        return true;
    }

    private static boolean isAllLesser(int[] arr, int index, int val) {
        for (int i = index; i < arr.length - 1; i++) {
            if (val < arr[i + 1])
                return false;
        }
        return true;
    }

    private static boolean isAllGreater(int[] arr, int index, int val) {
        for (int i = index; i < arr.length - 1; i++) {
            if (val > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pre = {20, 10, 11, 13, 12};
        System.out.println(isOneChild(pre));
    }
}
