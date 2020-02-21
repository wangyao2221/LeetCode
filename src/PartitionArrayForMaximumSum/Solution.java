package PartitionArrayForMaximumSum;

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length + 1];
        dp[0] = 0;
        for (int i = 0; i < A.length; i++) {
            int tmpMax = A[i];
            for (int j = i; j > i - K && j >= 0; j--) {
                tmpMax = Math.max(tmpMax, A[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + tmpMax * (i - j + 1));
            }
        }
        return dp[A.length];
    }
}