package ForOffer.Multiply;

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int[][] matrix = new int[A.length][A.length];
        int[] B = new int[A.length];
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j) matrix[i][j] = 1;
                else if(j == 0) matrix[i][j] = A[0];
                else matrix[i][j] = matrix[i][j - 1] * A[j];
            }
        }
        
        for(int i = A.length - 1; i >= 0; i--) {
            for(int j = A.length - 1; j > i; j--) {
                if(j == A.length - 1) matrix[i][j] = A[A.length - 1];
                else matrix[i][j] = matrix[i][j + 1] * A[j];
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            B[i] = 1;
            for(int j = 0; j < A.length; j++) {
                B[i] *= matrix[i][j];
            }
        }
        
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2, 3, 4, 5};
        Solution solution = new Solution();
        solution.multiply(A);
    }
}