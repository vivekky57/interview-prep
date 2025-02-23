package org.practice.leetcode;

import java.util.*;

public class Contest1 {
    public static int[] getSneakyNumbers(int[] nums) {
//        HashMap<Integer,Integer> hash = new HashMap<>();
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> l = new ArrayList<>();
        hash.forEach(
                (key, value)
                        -> {
                    if (value == 2) {
                        l.add(key);
                    }
                });
        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int maxScore(int[] a, int[] b) {
        int n = b.length;

        int[] dp0 = new int[n - 3];
        int[] dp1 = new int[n - 2];
        int[] dp2 = new int[n - 1];
        int[] dp3 = new int[n];


        dp0[0] = a[0] * b[0];
        for (int j = 1; j < n - 3; j++) {
            dp0[j] = Math.max(dp0[j - 1], a[0] * b[j]);
        }

        dp1[1] = dp0[0] + a[1] * b[1];
        for (int j = 2; j < n - 2; j++) {
            dp1[j] = Math.max(dp1[j - 1], dp0[j - 1] + a[1] * b[j]);
        }

        dp2[2] = dp1[1] + a[2] * b[2];
        for (int j = 3; j < n - 1; j++) {
            dp2[j] = Math.max(dp2[j - 1], dp1[j - 1] + a[2] * b[j]);
        }

        dp3[3] = dp2[2] + a[3] * b[3];
        for (int j = 4; j < n; j++) {
            dp3[j] = Math.max(dp3[j - 1], dp2[j - 1] + a[3] * b[j]);
        }

        // The answer is the maximum value in dp3 array
        int result = Integer.MIN_VALUE;
        for (int j = 3; j < n; j++) {
            result = Math.max(result, dp3[j]);
        }

        return result;
    }


//    public int countOfSubstrings(String word, int k) {
//
//        if(word.charAt(i))
//
//    }

    public static char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while (word.length() < k) {
            StringBuilder newWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char alpha = (char) ((word.charAt(i) - 'a' + 1) % 26 + 'a');
                newWord.append(alpha);
            }
            word.append(newWord);
        }
        return word.charAt(k - 1);
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static boolean containsAllVowels(Map<Character, Integer> vowelCount) {
        return vowelCount.get('a') > 0 &&
                vowelCount.get('e') > 0 &&
                vowelCount.get('i') > 0 &&
                vowelCount.get('o') > 0 &&
                vowelCount.get('u') > 0;
    }

    public static int countOfSubstrings(String word, int k) {
        Map<Character, Integer> vowel = new HashMap<>();
        vowel.put('a', 0);
        vowel.put('e', 0);
        vowel.put('i', 0);
        vowel.put('o', 0);
        vowel.put('u', 0);

        int result = 0;
        int n = word.length();
        for (int left = 0; left < n; left++) {
            HashSet<Character> vowelSet = new HashSet<>();
            int constantCount = 0;
            for (int right = left; right < n; right++) {
                char ch = word.charAt(right);

                if (isVowel(ch)) {
                    vowelSet.add(ch);
                } else {
                    constantCount++;
                }
                if(constantCount>k){
                    break;
                }
                if(vowelSet.size()==5 && constantCount ==k){
                    result++;
                }
            }
        }
        return result;
    }
/*
* a+b+c
* a+c+b
* b+a+c
* b+c+a
* c+b+a
* c+a+b
* 1111111
* */
    public static  int maxGoodNumber(int[] nums) {
        List<String> bs = new ArrayList<>();
        Long max = Long.MIN_VALUE;
        for (int num : nums) {
            String a = Integer.toBinaryString(num);
            bs.add(a);
        }
        Collections.sort(bs, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder result = new StringBuilder();
        for (String binary : bs) {
            result.append(binary);
        }
//        String first = bs.get(0) + bs.get(1) + bs.get(2);
//        if (max < Long.parseLong(first)) {
//            max = Long.parseLong(first);
//        }
//        String second = bs.get(0) + bs.get(2) + bs.get(1);
//        if (max < Long.parseLong(second)) {
//            max = Long.parseLong(second);
//        }
//        String third = bs.get(1) + bs.get(0) + bs.get(2);
//        if (max <Long.parseLong(third)) {
//            max = Long.parseLong(third);
//        }
//        String four = bs.get(1) + bs.get(2) + bs.get(0);
//        if (max < Long.parseLong(four)) {
//            max = Long.parseLong(four);
//        }
//        String five = bs.get(2) + bs.get(0) + bs.get(1);
//        if (max < Long.parseLong(five)) {
//            max = Long.parseLong(five);
//        }
//        String six = bs.get(2) + bs.get(1) + bs.get(0);
//        if (max < Long.parseLong(six)) {
//            max = Long.parseLong(six);
//        }
        return Integer.parseInt(String.valueOf(result), 2);
    }

}
