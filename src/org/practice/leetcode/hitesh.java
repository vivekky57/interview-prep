package org.practice.leetcode;

import java.util.*;

public class hitesh {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list1 = Arrays.stream(nums1).boxed().toList();
        List<Integer> list2 = Arrays.stream(nums2).boxed().toList();
        Set<Integer> diff1 = new HashSet<Integer>(  list1);
        Set<Integer> diff2 = new HashSet<Integer>(list2);
        diff1.removeAll(list2);
        list1.forEach(diff2::remove);
        List<Integer> temp = List.of();
        for(Integer num : diff1){
            temp.add(num);
        }
        ans.add(temp);
        temp.clear();
        for(Integer num : diff2){
            temp.add(num);
        }
        ans.add(temp);
        return ans;
    }
}
