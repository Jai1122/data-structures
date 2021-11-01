package com.algo.greedy;

import java.util.ArrayList;

public class MinFibonacciTerms {

    public static void main(String[] args) {
        int k = 4;
        ArrayList<Integer> fibList = new ArrayList<>();
        fibList.add(0);
        fibList.add(1);
        fibList.add(1);
        int i = 3;
        while (true) {
            int nextTerm = fibList.get(i - 1) + fibList.get(i - 2);
            if (nextTerm > k) {
                break;
            }
            fibList.add(nextTerm);
            i++;
        }

        int j = fibList.size() - 1;
        int count = 0;
        while (k>0){
            count = count + (k/fibList.get(j));
            k = k %  fibList.get(j);
            j--;
        }

        System.out.println(count);
    }
}
