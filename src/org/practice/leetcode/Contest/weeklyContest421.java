package org.practice.leetcode.Contest;

public class weeklyContest421 {

    // Method to calculate GCD
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to calculate LCM
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

//    // Method to compute GCD of an array
//    public static int computeGCD(int[] nums) {
//        int result = nums[0];
//        for (int num : nums) {
//            result = gcd(result, num);
//        }
//        return result;
//    }
//
//    // Method to compute LCM of an array
//    public static int computeLCM(int[] nums) {
//        int result = 1;
//        for (int num : nums) {
//            result = lcm(result, num);
//        }
//        return result;
//    }

    public static long maxFactorScore(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return (long) nums[0] * nums[0]; // GCD and LCM of a single element is the element itself

        // Calculate prefix GCD and LCM
        long[] prefixGCD = new long[n];
        long[] prefixLCM = new long[n];
        long[] suffixGCD = new long[n];
        long[] suffixLCM = new long[n];

        prefixGCD[0] = nums[0];
        prefixLCM[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixGCD[i] = gcd(prefixGCD[i - 1], nums[i]);
            prefixLCM[i] = lcm(prefixLCM[i - 1], nums[i]);
        }

        suffixGCD[n - 1] = nums[n - 1];
        suffixLCM[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(suffixGCD[i + 1], nums[i]);
            suffixLCM[i] = lcm(suffixLCM[i + 1], nums[i]);
        }

        // Calculate the maximum factor score
        long maxScore = 0;

        // Case 1: Removing no elements
        maxScore = Math.max(maxScore, prefixGCD[n - 1] * prefixLCM[n - 1]);

        // Case 2: Removing one element
        for (int i = 0; i < n; i++) {
            long currentGCD;
            long currentLCM;

            if (i == 0) {
                currentGCD = suffixGCD[1];
                currentLCM = suffixLCM[1];
            } else if (i == n - 1) {
                currentGCD = prefixGCD[n - 2];
                currentLCM = prefixLCM[n - 2];
            } else {
                currentGCD = gcd(prefixGCD[i - 1], suffixGCD[i + 1]);
                currentLCM = lcm(prefixLCM[i - 1], suffixLCM[i + 1]);
            }

            maxScore = Math.max(maxScore, currentGCD * currentLCM);
        }

        return maxScore;
    }

    public static int getTransformedLength(String s, int t) {
//        final int MOD = 1_000_000_007;
//        long length = s.length();
//
//        for (int i = 0; i < t; i++) {
//            long newCountZ = 0;
//            StringBuilder newString = new StringBuilder();
//            System.out.println(s);
//            for (char c : s.toCharArray()) {
//                if (c == 'z') {
//                    newCountZ++;
//                    newString.append("ab");
//                } else {
//                    newString.append((char)(c + 1));
//                }
//            }
//
//            length = (length + newCountZ) % MOD;
//            s = newString.toString();
//        }
//
//        return (int) length;

        final int MOD = 1_000_000_007;
        long length = s.length(); // Initial length
        long countZ = 0; // Count of 'z's after transformations

        // Calculate how many 'z's will be in the final string after t transformations
        if (t > 25) {
            // All characters will eventually turn into 'z' after 25 transformations
            countZ = length; // All characters become 'z'
            // After the 26th transformation, every 'z' turns into "ab"
            length += countZ; // Increase length by countZ (1 for each 'z' turning into "ab")
            t -= 26; // Adjust t to reflect remaining transformations
        } else {
            // If t <= 25, we can simply simulate this
            for (int i = 0; i < t; i++) {
                for (char c : s.toCharArray()) {
                    if (c == 'z') {
                        countZ++;
                    }
                }
                length += countZ; // Update length based on the number of 'z's found
            }
            return (int) (length % MOD);
        }

        // After the 26th transformation, every remaining transformation keeps producing 'ab'
        // For each subsequent transformation, every 'ab' becomes 'bc', ..., and continues to grow
        length += (2L * t); // Each 'ab' will contribute 2 characters per additional transformation
        return (int) (length % MOD);
    }


    public static void main(String[] args) {
////        int[] nums = {2,4,8,16};
//        int[] nums = {16,25,7,27,11,13,17,19,23,29};
//        System.out.println(maxFactorScore(nums)); // Output: 64

        String s = "azbk";
        int t = 100;
        System.out.println(getTransformedLength(s, t));
    }

}
