package com.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;


public class ActivitySelection {

    /**
     * Prints the maximum activities that can be performed by one person
     *
     * @param start  array of start times
     * @param finish array of finish time
     */

    private static void printMaxActivities(int[] start, int[] finish) {
        Activity[] activities = new Activity[start.length];
        for (int i = 0; i < start.length; i++) {
            activities[i] = new Activity(start[i], finish[i]);
        }

        Arrays.sort(activities, Comparator.comparingInt(o -> o.finish));

        int i = 0;
        System.out.println(activities[i]);


        for (int j = 1; j < activities.length; j++) {
            if (activities[j].start >= activities[i].finish) {
                System.out.println(activities[j]);
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        printMaxActivities(start, finish);
    }

    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }

    }
}
