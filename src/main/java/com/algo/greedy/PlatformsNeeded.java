package com.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;
//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

//TODO: Does not work.. need to check
public class PlatformsNeeded {
    public static void main(String[] args) {
       // int[] arr = {900, 940, 950, 1100, 1500, 1800};
       // int[] dept = {910, 1200, 1120, 1130, 1900, 2000};

        int[] arr = {900,940};
        int[] dept = {910,1200};
        Schedule[] schedules = new Schedule[arr.length];

        for (int i = 0; i < arr.length; i++) {
            schedules[i] = new Schedule(arr[i], dept[i]);
        }

        Arrays.sort(schedules, Comparator.comparingInt(o -> o.dept));
        for (int i = 0; i < arr.length; i++) {
           System.out.println(schedules[i]);
        }

        int count = 1;
        System.out.println("\n\nTrains Considered");
        System.out.println(schedules[0]);
        for (int i = 1; i < schedules.length; i++) {
            if(schedules[i].arr <= schedules[i-1].dept){
                System.out.println(schedules[i]);
                count++;
            }else{
                count--;
            }
        }
        System.out.println(count);
    }

    static class Schedule {
        int arr;
        int dept;

        public Schedule(int arr, int dept) {
            this.dept = dept;
            this.arr = arr;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                    "arr=" + arr +
                    ", dept=" + dept +
                    '}';
        }
    }
}
