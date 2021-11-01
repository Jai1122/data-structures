package com.algo.backtracking;

public class FillNumbers {

    public static void main(String[] args) {
        fill(7);
    }

    private static void fill(int n){
        int twoN = 2*n;
        int[] res = new int[twoN];
        int i;
        for (i = 0; i < twoN; i++) {
            res[i] = 0;
        }
        if (fillUtil(res, n, n))
            System.out.println("Yess");
        else
            System.out.println("Nahh");
    }

    private static boolean fillUtil(int[] res, int curr, int n){
        if (curr == 0) {
            return true;
        }

        int i;
        for (i = 0; i < 2 * n - curr - 1; i++) {
            if(res[i] == 0 && res[i+curr+1] == 0){
                res[i] = res[i+curr+1] = curr;
                if(fillUtil(res, curr-1, n)){
                    return true;
                }
                res[i] = res[i+curr+1] = 0;
            }
        }
        return false;
    }
}
