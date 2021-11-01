package com.algo.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxTrainStoppages {

    private static int maxTrainsHandled(List<TrainSchedule> trainScheduleList, int numOfPlatforms) {

        int trainCount = 0;

        for (int i = 1; i <= numOfPlatforms; i++) {
            System.out.println("Trains on Platform :" + i);
            List<TrainSchedule> trainsScheduledOnPlatformI = new ArrayList<>();
            for (TrainSchedule trainSchedule : trainScheduleList) {
                if (trainSchedule.platform == i) {
                    trainsScheduledOnPlatformI.add(trainSchedule);
                }
            }
            if(trainsScheduledOnPlatformI.isEmpty()) break;
            trainsScheduledOnPlatformI.sort(Comparator.comparingInt(trainSchedule -> trainSchedule.arrival));

            if (trainsScheduledOnPlatformI.size() == 1) {
                trainCount++;
                System.out.println(trainsScheduledOnPlatformI.get(0));
            } else {
                System.out.println(trainsScheduledOnPlatformI.get(0));
                trainCount++;
                int k = 0;
                for (int j = 1; j < trainsScheduledOnPlatformI.size(); j++) {
                    if (trainsScheduledOnPlatformI.get(j).arrival >= trainsScheduledOnPlatformI.get(k).departure) {
                        System.out.println(trainsScheduledOnPlatformI.get(j));
                        trainCount++;
                        k = j;
                    }
                }
            }
        }

        System.out.println("Total Trains handled " + trainCount);
        return trainCount;
    }

    public static void main(String[] args) {
        List<TrainSchedule> trainScheduleList = new ArrayList<>();

  /*    trainScheduleList.add(new TrainSchedule(1, 1, 1000, 1030));
        trainScheduleList.add(new TrainSchedule(2, 1, 1010, 1030));
        trainScheduleList.add(new TrainSchedule(3, 2, 1000, 1020));
        trainScheduleList.add(new TrainSchedule(4, 2, 1030, 1230));
        trainScheduleList.add(new TrainSchedule(5, 3, 1200, 1230));
        trainScheduleList.add(new TrainSchedule(6, 1, 900, 1005));
*/
        trainScheduleList.add(new TrainSchedule(1, 1, 1000, 1030));
        trainScheduleList.add(new TrainSchedule(2, 1, 1110, 1130));
        trainScheduleList.add(new TrainSchedule(3, 1, 1200, 1220));
        maxTrainsHandled(trainScheduleList, 1);
    }

    static class TrainSchedule {
        private final int trainNo;
        private final int platform;
        private final int arrival;
        private final int departure;

        public TrainSchedule(int trainNo, int platform, int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
            this.platform = platform;
            this.trainNo = trainNo;
        }

        @Override
        public String toString() {
            return "TrainSchedule{" +
                    "trainNo=" + trainNo +
                    ", platform=" + platform +
                    ", arrival=" + arrival +
                    ", departure=" + departure +
                    '}';
        }
    }
}
