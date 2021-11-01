package com.algo.greedy;

public class Number {

    public static void main(String[] args) {
        int s = 9, d= 2;
        int[] res = new int[d];
        s = s-1;

        for (int i = d-1; i >=0 ; i--) {
            if(s >9){
                res[i] = 9;
                s = s-9;
            }else {
                res[i] = s;
                s = 0;
            }
        }

        res[0] = s+1;
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
