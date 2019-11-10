package WeeklyContest162.CellsWithOddValuesInAMatrix;

import java.util.Arrays;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        int result = 0;

        for (int i = 0; i < indices.length; i++) {
            int ri = indices[i][0];
            int ci = indices[i][1];

            for (int j = 0; j < m; j++) {
                arr[ri][j]++;
            }

            for (int j = 0; j < n; j++) {
                arr[j][ci]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}