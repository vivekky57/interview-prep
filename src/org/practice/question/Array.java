package org.practice.question;


import java.util.HashMap;

public class Array {

    public static int findMin(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return -1;
    }

    public static int findMinimumInRotatedSortedArray(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int mini = Integer.MAX_VALUE;
        int m = l + (h - l) / 2;
        while (l <= h) {
            if (nums[m] >= nums[l]) {
                mini = Math.min(mini, nums[l]);
                l = m + 1;


            } else {
                mini = Math.min(mini, nums[m]);
                h = m - 1;
            }
            m = l + (h - l) / 2;
        }
        return mini;
    }

    public static void moveZeroes(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (j >= 0 && nums[j] == 0) {
            j--;
        }
        while (i < j) {
            if (nums[i] == 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                j--;
            }
            i++;
        }

    }

    public static int countLength(Integer num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    public static int compress(char[] chars) {
        return -1;
    }


    public static boolean validPalindrome(StringBuilder st) {
        int low = 0;
        int high = st.length() - 1;
        while (low < high) {
            if (st.charAt(low) != st.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        System.out.println(s);

        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb);

        return validPalindrome(sb);
    }

    public static boolean isSubsequence(String s, String t) {
        int low = 0;
        int n = s.length();
        for (int i = 0; i < t.length(); i++) {
            if (n > low && s.charAt(low) == t.charAt(i)) {
                low++;
            }
        }
        if (low == n) {
            return true;
        }
        return false;
    }

    public static int jump2(int pos, int[] nums, int jump) {
        if (pos >= nums.length - 1) {
            return jump;
        }
        int mini = Integer.MAX_VALUE;
        for (int k = 1; k <= nums[pos]; k++) {
            mini = Math.min(mini, jump2(pos + k, nums, jump + 1));
        }
        return mini;
    }
    public static int romanToInt(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int res =0;
        for(int i=0;i< s.length()-1;i++){
            if(mp.get(s.charAt(i)) < mp.get(s.charAt(i+1)) ){
                res -= mp.get(s.charAt(i));
            }else{
                res += mp.get(s.charAt(i));
            }
        }
        return res +mp.get(s.charAt(s.length()-1));
    }

    public static void main(String[] args) {
    String s =  "MCMXCIV";
        System.out.println(romanToInt(s));



//
//        char[] ch = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        System.out.println(isSubsequence("axc", "ahbgdc"));
////        print(compress(ch));
//        System.out.println(jump2(0, new int[]{2, 3, 1, 1, 4}, 0));
    }
}
