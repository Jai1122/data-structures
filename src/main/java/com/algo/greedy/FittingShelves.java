package com.algo.greedy;

public class FittingShelves {

    public static void main(String[] args) {
        minSpace(24,5,3);
    }

    private static void minSpace(int wall, int m, int n){
        int num_m   =   0;
        int num_n   =   0;
        int min_empty   =   wall;

        int p = wall/m;
        int q   =   0;
        int rem =   wall%m;

        while(wall >= n){
            q   +=  1;
            wall    =   wall    -   n;
            p   =   wall    /   m;
            rem = wall %    m;

            if(rem <=min_empty){
                num_m   =   p;
                num_n   =   q;
                min_empty   =   rem;
            }

            q+=1;
            wall    =   wall-n;

        }
        System.out.println(num_m+" "+num_n+" "+min_empty);
    }


}
