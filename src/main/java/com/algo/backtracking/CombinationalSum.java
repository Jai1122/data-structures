package com.algo.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationalSum {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);

        int sum = 8;
        ArrayList<ArrayList<Integer>> ans = findCombinationalSum(arr, sum);
        if(ans.size() == 0){
            System.out.println("Empty");
        }else {
            for (int i = 0; i < ans.size(); i++) {

                System.out.print("(");
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.print(") ");
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> findCombinationalSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> soln = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        findNumbers(soln, arr, sum, 0, temp);
        return soln;
    }

    private static void findNumbers(ArrayList<ArrayList<Integer>> soln, ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> temp) {
        if (sum == 0) {
            soln.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if (sum - arr.get(i) >= 0) {
                temp.add(arr.get(i));
                findNumbers(soln, arr, sum - arr.get(i), i, temp);
                temp.remove(arr.get(i));
            }
        }
    }
}
