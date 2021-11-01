package com.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobScheduling {

    private static void scheduleJobs(ArrayList<Job> jobs, int t) {
        Collections.sort(jobs, (o1, o2) -> o2.profit - o1.profit);

        boolean[] result = new boolean[t];
        ArrayList<Job> scheduledJobs = new ArrayList<>(t);

        for (int i = 0; i < jobs.size(); i++) {
            for (int j = Math.min(t - 1, jobs.get(i).deadline - 1); j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    scheduledJobs.add(jobs.get(i));
                    break;
                }
            }
        }

        scheduledJobs.forEach(System.out::println);

        int profit = scheduledJobs.stream()
                .mapToInt(value -> value.profit)
                .sum();

        System.out.println("Total Profit is "+profit);
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 120));
        jobs.add(new Job('e', 3, 15));
        scheduleJobs(jobs, 3);
    }

    static class Job {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }
    }
}
