package com.algo.greedy;

import java.util.ArrayList;

public class ThiefAndPolicemen {

    public static void main(String[] args) {
        char[] arr = {'P', 'T', 'T', 'P', 'T', 'P'};
        int k = 1;
        int n = arr.length;
        boolean[] caught = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                for (int j = i-k; j <= i + k; j++) {
                    if(j<0) continue;
                    if (arr[j] == 'T' && !caught[j]) {
                        caught[j] = true;
                        break;
                    }
                }
            }
        }

        int caughtCount = 0;
        for (int i = 0; i < caught.length; i++) {
            if (caught[i])
                caughtCount++;
        }

        System.out.println(caughtCount);
        betterApproach();
    }

    private static void betterApproach(){
        char[] arr = {'P', 'T', 'T', 'P', 'T', 'P'};
        int k = 1;
        int n = arr.length;
        int res = 0;
        ArrayList<Integer> policeIndex  =   new ArrayList<>();
        ArrayList<Integer> thiefIndex  =   new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(arr[i] == 'P')
                policeIndex.add(i);
            else
                thiefIndex.add(i);
        }
        int l = 0, r = 0;
        while (l< policeIndex.size() && r < thiefIndex.size()){
            if(Math.abs(policeIndex.get(l) - thiefIndex.get(r)) <= k){
                res++;
                l++;
                r++;
            }else if(thiefIndex.get(r) < policeIndex.get(l)){
                r++;
            }else {
                l++;
            }
        }
        System.out.println(res);
    }
}
