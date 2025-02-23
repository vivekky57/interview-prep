package org.practice.question;

import java.util.List;

public class utils {

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void print(char s) {
            System.out.println(s);

    }
    public static void print(int s) {
        System.out.println(s);

    }

    public static void print(String s,int[][] nums) {
        System.out.println(s);
        for (int[] n : nums) {
            for (int num : n) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void print(List<List<Integer>> nums) {
        System.out.println("ans : ");
        for (List<Integer> n : nums) {
            for (Integer num : n) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void print(String s, List<Integer> nums) {
        System.out.println(s);
        for (Integer n : nums) {
            System.out.print(n + " ");
        }
    }
    public static void print(boolean bool){
        System.out.println(bool);
    }
}
