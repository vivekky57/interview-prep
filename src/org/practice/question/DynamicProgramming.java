package org.practice.question;

public class DynamicProgramming {

    public static  int numDecodings(String s,int[] dp,int n){
        if(s.isEmpty()){
            return 1;
        }
        if(dp[n-s.length()]!=-1 ){
            return dp[n-s.length()];
        }
        int takeone=0;
        int taketwo =0;
        if(Character.getNumericValue(s.charAt(0))!=0 ){
            takeone += numDecodings(s.substring(1),dp,n);
        }
        if(s.length()>=2 && ((s.charAt(0)=='1') || (s.charAt(0)=='2' && Character.getNumericValue(s.charAt(1))<7 )) ){
            taketwo += numDecodings(s.substring(2),dp,n);
        }

        dp[n-s.length()] = takeone +taketwo;
        return dp[n-s.length()];
    }

    public static int rob(int[] nums,int i,int n,int[]dp){
        if(i==n-1){
            return nums[i];
        }
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i] = Integer.max(nums[i]+rob(nums,i+2,n,dp),rob(nums,i+1,n,dp));
    }
}
