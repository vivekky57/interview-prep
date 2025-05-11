package org.practice.question;

import java.util.*;

public class BarRaiser {
// "You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a non virus infected system, or
// 2 representing a virus infected system.

// Every minute, any non virus system that is connected to any 4-directionally virus infected system becomes virus infected system.

// Return the minimum number of minutes that must elapse so that all system become virus infected.

// Input: grid =
// [
// [2,1,0],
// [2,1,0],
// [0,1,1]
// ]

//

// [2,2,0]
// [2,2,0]
// [0,1,1]

// [2,2,0]
// [2,2,0]
// [0,2,1]

// [2,2,2]
// [2,2,0]
// [0,2,2]

// 3

    // [2,2,2]
// [2,2,0]
// [0,0,1]
// Output: 4
    static int min = 0;
    static int unInfect = 0;
    public boolean possible(int x, int y, int m, int n, int[][] num) {
        if ((x < m && x >= 0) && (y >= 0 && y < n) && num[x][y] != 0) {
            return true;
        }
        return false;
    }


    public void solve(List<List<Integer>> loc, int[][] nums) {
        boolean flag = false;
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < loc.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(loc.get(i).get(0));
            temp.add(loc.get(i).get(1));
            queue.add(temp);
        }
        while (queue.size() > 0) {
            flag = false;
            for (int i = 0; i < queue.size(); i++) {
                List<Integer> temp = queue.poll();
                int x = temp.get(0);
                int y = temp.get(1);
                System.out.println(temp);

                // 1,0   0,1    -1,0   0,-1
                //right

                if (possible(x + 1, y, nums.length, nums[0].length, nums) && nums[x + 1][y] == 1) {
                    List<Integer> t = new ArrayList<>();
                    t.add(x + 1);
                    t.add(y);
                    queue.add(t);
                    nums[x + 1][y] = 2;
                    unInfect++;
                    flag = true;
                }
                //up
                if (possible(x, y + 1, nums.length, nums[0].length, nums) && nums[x][y + 1] == 1) {
                    List<Integer> t = new ArrayList<>();
                    t.add(x);
                    t.add(y + 1);
                    queue.add(t);
                    unInfect++;

                    flag = true;
                    nums[x][y + 1] = 2;
                }
                //left
                if (possible(x - 1, y, nums.length, nums[0].length, nums) && nums[x - 1][y] == 1) {
                    List<Integer> t = new ArrayList<>();
                    t.add(x - 1);
                    t.add(y);
                    queue.add(t);
                    unInfect++;
                    flag = true;
                    nums[x - 1][y] = 2;
                }
                //down
                if (possible(x, y - 1, nums.length, nums[0].length, nums) && nums[x][y - 1] == 1) {
                    List<Integer> t = new ArrayList<>();
                    t.add(x);
                    t.add(y - 1);
                    queue.add(t);
                    unInfect++;
                    flag = true;
                    nums[x][y - 1] = 2;
                }
            }
            if(flag)
            min++;
        }
    }

    public int barRaiser(int[][] num) {
        int totalSystem = 0;
        int infectSystem = 0;
        List<List<Integer>> loc = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (num[i][j] == 2 || num[i][j] == 1) {
                    totalSystem++;
                }
                if (num[i][j] == 2) {
                    infectSystem++;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    loc.add(temp);
                }
            }
        }
        System.out.println(loc);


        solve(loc, num);
        if (unInfect + infectSystem == totalSystem)
            return min;
        return -1;
    }
}


class Main {

    public static void main(String[] args) {
//        Scanner myObj = new Scanner(System.in);
//        String line = myObj.nextLine();

        int[][] nums = new int[][]{{2, 1, 0}, {1, 1, 0}, {0, 1, 1}};
//        nums[0][0] =2;
//        nums[0][2] =1;
//        nums[0][1] =0;
//        nums[1][0] =2;
//        nums[1][1] =1;
//        nums[1][2] =0;
//        nums[2][0] =0;
//        nums[2][1] =1;
//        nums[2][2] =1;

        int ans = new BarRaiser().barRaiser(nums);
        System.out.println(ans);
    }
}
