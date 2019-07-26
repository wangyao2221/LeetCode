package UniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + 2;
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.println(new Solution().uniquePaths(m, n));
    }
}