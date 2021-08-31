package com.algo.greedy;

import java.util.ArrayList;

public class DivideIntoGroups {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Integer> list1    =   new ArrayList<>();
        ArrayList<Integer>  list2   =   new ArrayList<>();
        int list1Sum = n;
        int list2Sum = n-1;
        list1.add(n);
        list2.add(n-1);
        for (int i = n-2; i > 0; i--) {
            if(list1Sum < list2Sum  ) {
                list1.add(i);
                list1Sum+=i;
            }else {
                list2.add(i);
                list2Sum+=i;
            }
        }

        System.out.println("List 1 : "+list1.size());
        list1.stream()
                .forEach(i -> {
                    System.out.print(i+", ");
                });
        System.out.println();
        System.out.println("List 2 : "+list2.size());
        list2.stream()
                .forEach(i -> {
                    System.out.print(i+", ");
                });
    }
}
