package org.practice.question;

import java.util.Objects;
import java.util.PriorityQueue;

public class Heap {
    private  static long ans;
    public static void solve(int[] n1 , int[] n2, int k, int i, PriorityQueue<Integer> heap,int n,int sum){
        if(i >= n){
            if(k==0){
                ans = Math.max(ans, (long) heap.peek()* sum);
                return;
            }
            return;
        }
        if(k==0){
            ans = Math.max(ans, (long) heap.peek()* sum);
            return;
        }

        //take
        heap.add(n2[i]);
        solve(n1,n2,k-1,i+1,heap,n,sum + n1[i]);
        heap.remove(n2[i]);

        // not take
        solve(n1,n2,k,i+1,heap,n,sum);
    }
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        solve(nums1,nums2,k,0,heap,nums1.length,0);
        return ans;
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>();

//        for(int i=0;i<candidates;i++){
//            heap1.offer(costs[i]);
//            heap2.offer(costs[ costs.length -1 - i]);
//        }
        int i = 0;
        int j = costs.length - 1;
        while (heap1.size() < candidates && i <= j) {
            heap1.offer(costs[i++]);
        }
        while (heap2.size() < candidates && i <= j) {
            heap2.offer(costs[j--]);
        }
        long sum =0;
        while(k!=0){
            if(heap1.peek() > heap2.peek()){
                sum += heap2.poll();
                if(i+1<j){
                    heap2.offer(costs[--j]);
                }
            }else if(Objects.equals(heap1.peek(), heap2.peek()) || heap1.peek()< heap2.peek()){
                sum+= heap1.poll();
                if(i+1<j){
                    heap1.offer(costs[++i]);
                }
            }
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,3,3,2};
//        int[] nums2 = new int[]{2,1,3,4};
//        int k =3;
//        System.out.println(maxScore(nums1,nums2,k));
        int[] costs = new int[]{18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75};
        System.out.println(totalCost(costs,13,23));
    }
}
