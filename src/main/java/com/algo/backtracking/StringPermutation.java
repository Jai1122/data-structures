package com.algo.backtracking;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "ABCD";
        permutate(str,0,str.length());
    }

    private static void permutate(String str, int l, int r){
        if(l == r){
            System.out.println(str);
        }else {
            for (int i = l; i < r; i++) {
                str = swap(str, l ,i);
                permutate(str, l+1,r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String str, int l, int r){
        char[] inPutChars = str.toCharArray();
        char temp = inPutChars[r];
        inPutChars[r] = inPutChars[l];
        inPutChars[l] = temp;
        return String.valueOf(inPutChars);
    }
}
