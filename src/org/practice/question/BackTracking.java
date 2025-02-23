package org.practice.question;

import java.util.List;

public class BackTracking {
    public boolean isPossible(int x,int y, char[][] board, int[][] vis){
        if( (x>=0 && x<board[0].length) && (y>=0 && y< board.length) && vis[x][y] == 0 ){
            return true;
        }
        return false;
    }
    public boolean solve(int x,int y,char[][] board, String word,int[][] vis) {
        if(word.isEmpty()){
            return true;
        }
        if(isPossible(x+1,y+1,board,vis) && word.charAt(0) == board[x][y]){

        }

        return false;
    }

//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> res = List.of();
//        int m = board.length;
//        int n = board[0].length;
//        int[][] vis = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                vis[i][j] = 0;
//            }
//        }
//        for (String word : words) {
//            for(int i=0;i<m;i++){
//                for(int j=0;j<n;j++){
//
//                if (solve(board, word)) {
//                    res.add(word);
//                }
//                }
//            }
//        }
//        return res;
//    }
}
