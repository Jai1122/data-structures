package com.algo.backtracking;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        String pattern = "aba";
        Map<Character, String> map = new HashMap<>();
        if(match(str,0,pattern,0, map)) {
            System.out.println("Match Found");
            for(Map.Entry<Character,String> entry : map.entrySet()){
                System.out.println(entry.getKey() +" -> "+entry.getValue());
            }
        }else
            System.out.println("Nahh!!");
    }

    private static boolean match(String str, int i, String pattern, int j, Map<Character,String> map){
        int n = str.length();
        int m = pattern.length();

        if(n<m)
            return false;

        if(i == n && j == m)
            return true;

        if( i == n || j == m)
            return false;

        char curr = pattern.charAt(j);

        if(map.containsKey(curr)){
            String s = map.get(curr);
            int k = s.length();

            String ss;
            if(i+k < str.length()){
                ss = str.substring(i, i+k);
            }else {
                ss = str.substring(i);
            }

            if(ss.compareTo(s) != 0)
                return false;

            return match(str, i+k, pattern, j+1, map);
        }

        for (int k = 1; k <= n - i; k++) {
            map.put(curr, str.substring(i , i+k));
            if(match(str, i+k, pattern, j+1, map))
                return true;

            map.remove(curr);
        }

        return false;
    }
}
