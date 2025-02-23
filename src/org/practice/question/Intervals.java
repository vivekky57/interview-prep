package org.practice.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.practice.question.utils.print;

public class Intervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> newInterval = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i <= n - 1) {
            if (i < n - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);

            } else {
                newInterval.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            i++;
        }

        return newInterval.toArray(new int[newInterval.size()][2]);
    }

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int prev = points[0][1];
        int count = 1;
        for(int i = 1;i<points.length;i++){
            if(prev >= points[i][0]){
                continue;
            }
            count++;
            prev = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] interval = new int[][]{ {-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] interval = new int[][]{{10,16},{2,8},{1,6},{7,12}};
       print(findMinArrowShots(interval));


    }
}
