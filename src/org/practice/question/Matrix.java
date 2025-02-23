package org.practice.question;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int colStart = 0, colEnd = matrix[0].length-1,rowStart = 0, rowEnd = matrix.length-1;
        List<Integer> ans = new ArrayList<Integer>();
        while(colStart<=colEnd && rowStart<=rowEnd){
            for(int i=colStart; i<= colEnd;i++){
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;

            for(int i=rowStart; i<= rowEnd;i++){
                ans.add(matrix[i][colEnd]);
            }

            colEnd--;
            for(int i=colEnd; i>= colStart && rowStart<=rowEnd;i--){
                ans.add(matrix[rowEnd][i]);
            }

            rowEnd--;
            for(int i=rowEnd; i>= rowStart && colStart<=colEnd;i--){
                ans.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return ans;
    }
}
