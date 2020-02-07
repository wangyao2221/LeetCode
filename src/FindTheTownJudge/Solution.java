package FindTheTownJudge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] incommings = new int[N + 1];
        int[] outgoings = new int[N + 1];

        for (int[] edge : trust) {
            incommings[edge[0]]++;
            outgoings[edge[1]]++;
        }

        for (int i = 1; i < incommings.length; i++) {
            if (incommings[i] == 0 && outgoings[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findJudge(2, new int[][]{{1, 2}}));
    }
}