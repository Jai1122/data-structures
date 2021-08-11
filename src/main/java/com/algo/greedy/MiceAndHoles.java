package com.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MiceAndHoles {
    public static void main(String[] args) {
        ArrayList<Integer> mice = new ArrayList<Integer>();
        mice.add(4);
        mice.add(-4);
        mice.add(2);
        ArrayList<Integer> holes = new ArrayList<Integer>();
        holes.add(4);
        holes.add(0);
        holes.add(5);
        calculateMaxTimeTakenToHoleTheMouse(mice,holes);
    }

    private static void calculateMaxTimeTakenToHoleTheMouse(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        Collections.sort(mice);
        Collections.sort(holes);
        int max = 0;
        for (int i = 0; i < mice.size(); i++) {
            if(max < Math.abs(mice.get(i)-holes.get(i)))
                max = Math.abs(mice.get(i)-holes.get(i));
        }
        System.out.println(max);
    }
}
