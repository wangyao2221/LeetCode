package WeeklyContest162.ReconstructA2RowBinaryMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        int[] row1 = new int[colsum.length];
        int[] row2 = new int[colsum.length];
        int colSum = 0;

        for (int i = 0; i < colsum.length; i++) {
            colSum += colsum[i];
        }

        if (colSum != upper + lower) {
            return result;
        }

        int upperTmp = 0;

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                row1[i] = 1;
                row2[i] = 1;
                upperTmp++;
            }
        }

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upperTmp < upper) {
                    row1[i] = 1;
                    row2[i] = 0;
                    upperTmp++;
                } else {
                    row1[i] = 0;
                    row2[i] = 1;
                }
            }
        }

        if (upperTmp < upper) {
            return result;
        }

        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        List<Integer> list1 = result.get(0);
        List<Integer> list2 = result.get(1);

        for (int i = 0; i < colsum.length; i++) {
            list1.add(row1[i]);
            list2.add(row2[i]);
        }

        return result;
    }

    public static void main(String[] args) {
//        List<List<Integer>> result = new Solution().reconstructMatrix(2, 1, new int[]{1, 1, 1});
//        List<List<Integer>> result = new Solution().reconstructMatrix(5, 5, new int[]{2,1,2,0,1,0,1,2,0,1});
        List<List<Integer>> result = new Solution().reconstructMatrix(9, 2, new int[]{0,1,2,0,0,0,0,0,2,1,2,1,2});
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}