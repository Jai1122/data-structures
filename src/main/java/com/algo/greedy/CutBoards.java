package com.algo.greedy;

import java.util.Arrays;
import java.util.Collections;

public class CutBoards {
    public static void main(String[] args) {
        int m = 6, n = 4;
        Integer X[] = {2, 1, 3, 1, 4};
        Integer Y[] = {4, 1, 2};
        minimumCostOfBreaking(X,Y,m-1,n-1);
    }

    private static void minimumCostOfBreaking(Integer[] x,Integer[] y, int m, int n){
        int res = 0;
        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());

        int hzntl = 1, vert = 1;
        int i=0, j=0;

        while(i < m && j < n){
            if(x[i] > y[j]){
                res += x[i++] * vert;
                hzntl++;
            }else {
                res += y[j++] * hzntl;
                vert++;
            }
        }
        int total = 0;
        while (i <m)
            total += x[i++];
        res += total*vert;

        total   =0;

        while (j<n)
            total += y[j++];
        res += total * hzntl;

        System.out.println(res);
    }
}
