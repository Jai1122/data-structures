package com.algo.backtracking;

import java.util.ArrayList;

public class SubSets {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            arr.add(i);
        }
        findAllSubsets(arr, 0, new ArrayList<>());
    }

    private static void findAllSubsets(ArrayList<Integer> arr, int currentIndex, ArrayList<Integer> subsets) {
        if (currentIndex == arr.size()) {
            subsets.stream()
                    .forEach(integer -> {
                        System.out.print(integer+" ");
                    });
            System.out.println();
            return;
        }

        findAllSubsets(arr, currentIndex + 1, new ArrayList<>(subsets));
        subsets.add(arr.get(currentIndex));
        findAllSubsets(arr, currentIndex + 1, new ArrayList<>(subsets));

    }
}
