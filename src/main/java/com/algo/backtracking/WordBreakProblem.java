package com.algo.backtracking;

import java.util.*;

public class WordBreakProblem {
    public static void main(String[] args) {
        String str1 = "iloveicecreamandmango";
        String str2 ="ilovesamsungmobile";
        int n1 = str1.length();
        int n2 = str2.length();

        // List of strings in dictionary
        List <String> dict= Arrays.asList("mobile","samsung","sam","sung",
                "man","mango", "icecream","and",
                "go","i","love","ice","cream");
        wordBreak(n1,dict,str1);
        System.out.println();
        wordBreak(n2,dict,str2);
    }

    private static void wordBreak(int n, List<String> dict, String str) {
        String ans = "";
        wordBreakUtil(n, dict,str,ans);
    }

    private static void wordBreakUtil(int n, List<String> dict, String str, String ans) {

        for (int i = 1; i <= n ; i++) {
            String prefix = str.substring(0,i);
            if(dict.contains(prefix)){
                if(i == n){
                    ans+=prefix;
                    System.out.println(ans+" ");
                    return;
                }
                wordBreakUtil(n-i,dict,str.substring(i,n),ans+prefix+" ");
            }
        }
    }


}
