package org.practice.question;

public class Graph {
    public static boolean check(int x,int y, int[][] grid, boolean[][] vis, int prev ){
        if((x>=0 && x<grid.length) && (y>=0 && y<grid[0].length) && prev< grid[x][y] && !vis[x][y]){
            return true;
        }
        return false;
    }
    public static void solve(int x,int y, int[][] grid,boolean[][] vis,int[] ans, int prev, int count){
        if(y==grid[0].length -1){
            ans[0] = Math.max(ans[0],count);
            return;
        }
        if(check(x-1,y+1,grid,vis,grid[x][y])){
            solve(x-1,y+1,grid,vis,ans,grid[x][y],count+1);
        }

        if(check(x,y+1,grid,vis,grid[x][y])){
            solve(x,y+1,grid,vis,ans,grid[x][y],count+1);
        }

        if(check(x+1,y+1,grid,vis,grid[x][y])){
            solve(x+1,y+1,grid,vis,ans,grid[x][y],count+1);
        }
    }
    public static int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int max = 0;
        int[] ans = new int[1];
        for(int i=0;i<n;i++){
            ans[0] = 0;
            solve(0,i,grid,vis,ans,-1,0);
            max = Math.max(max,ans[0]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println(maxMoves(grid));
    }
}
