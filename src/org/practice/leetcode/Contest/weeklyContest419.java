package org.practice.leetcode.Contest;

import java.util.HashMap;
import java.util.PriorityQueue;

public class weeklyContest419 {

    public static long[] calculateXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] answer = new long[n - k + 1];

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < k-1; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        int i = 0;
        int j = k-1;
        int cnt = 0;
        while (j < n) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            j++;
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                if (b[1] == a[1]) {
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            });

            for (var entry : freqMap.entrySet()) {
                maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            }
            long xSum = 0;
            int count = 0;
            while (count < x && !maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                xSum += (long) top[0] * top[1];
                count++;
            }
            answer[cnt++] = xSum;
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) - 1);
            i++;

        }

        return answer;
    }

        public static void main(String[] args) {
//        // Example 1
//        int[] nums1 = {1, 1, 2, 2, 3, 4, 2, 3};
//        int k1 = 6;
//        int x1 = 2;
//        int[] result1 = calculateXSum(nums1, k1, x1);
//        for (int val : result1) {
//            System.out.print(val + " ");
//        }
//        System.out.println();

        // Example 2
        int[] nums2 = {1000000000,1000000000,1000000000,1000000000,1000000000,1000000000};
        int k2 = 6;
        int x2 = 1;
        long[] result2 = calculateXSum(nums2, k2, x2);
        for (long val : result2) {
            System.out.print(val + " ");
        }

    }
}
