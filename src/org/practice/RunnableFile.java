package org.practice;


import org.practice.leetcode.Contest1;

import java.util.ArrayList;
import java.util.List;


import static org.practice.question.utils.print;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunnableFile {
    public static void main(String[] args) {
        int[] nums = {32,38,77};

        String s = "12";
//        int[] dp = new int[s.length()+1];
//        Arrays.fill(dp, -1);

//        System.out.println(DynamicProgramming.numDecodings(s,dp,s.length()));
//        System.out.println((DynamicProgramming.rob(nums)));
//        System.out.println(Arrays.findMinimumInRotatedSortedArray(arr));

//        int[] dp = new int[nums.length+1];
//        Arrays.fill(dp, -1);
//        int first = DynamicProgramming.rob(nums,0,nums.length-1,dp);
//        Arrays.fill(dp, -1);
//        int second = DynamicProgramming.rob(nums,1,nums.length,dp);
//        System.out.println(Integer.max(first ,second));

//        Array.moveZeroes(nums);
//        print(nums);

        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1,4});
//        intervals.add(new int[]{4,5});
//        intervals.add(new int[]{8,10});
//        intervals.add(new int[]{15,18});

//        int [][] tempIntervals = intervals.toArray(new int[intervals.size()][2]);
//        print("Interval",tempIntervals);
//        print("Merge Interval",Intervals.merge(tempIntervals));
//        print(Contest.getSneakyNumbers(nums));


        int[] a = {-1, 4, 5, -2};
        int[] b = {-5, -1, -3, -2, -4};
//        System.out.println(maxScore(a, b));

//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        print("QUES:",matrix);
//        print("ANS:", Matrix.spiralOrder(matrix));

//        print(Contest.kthCharacter(5));

//        print(Contest.countOfSubstrings("iqeaouqi",2));

//        print(hitesh.findDifference(a,b));

//        Trie trie = new Trie();
//        print(trie.startsWith("a")); // return False
//        trie.insert("apple");
//        print(trie.search("apple"));   // return True
//        print(trie.search("app"));     // return False
//        print(trie.startsWith("app")); // return True
//        trie.insert("app");
//        print(trie.search("app"));

        System.out.println(Contest1.maxGoodNumber(nums));
    }
}