package PrintMatrix;

import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0) return new ArrayList<Integer>();

        int m = matrix.length;
        int n = matrix[0].length;
        
        int colStart = 0, colEnd = n - 1;
        int rowStart = 0, rowEnd = m - 1;
        while(colStart <= colEnd && rowStart <= rowEnd) {
            print(matrix, colStart, colEnd, rowStart, rowEnd);
            colStart++;
            colEnd--;
            rowStart++;
            rowEnd--;
        }
        
        return list;
    }
    
    public void print(int[][] matrix, int colStart, int colEnd, int rowStart, int rowEnd) {
        for(int i = colStart; i <= colEnd; i++) {
            list.add(matrix[rowStart][i]);
        }
        for(int i = rowStart + 1; i <= rowEnd; i++) {
            list.add(matrix[i][colEnd]);
        }
        for(int i = colEnd - 1; i >= colStart; i--) {
            list.add(matrix[rowEnd][i]);
        }
        for(int i = rowEnd - 1; i >= rowStart + 1 && colEnd != colStart; i--) {
            list.add(matrix[i][colStart]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        Solution solution = new Solution();
        ArrayList list = solution.printMatrix(matrix);
    }
}