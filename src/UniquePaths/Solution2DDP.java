package UniquePaths;

/**
 * 为什么用一维数组和二维数组的耗时会一样
 * 本题其实是二项式系数，看二项式系数性质.jpg
 */
class Solution2DDP {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

//    public int uniquePaths(int m, int n) {
//        int range = (m - 1) + (n - 1);
//        int min = m > n ? n : m;
//        long numberator = 1;
//        long denominator = 1;
//        for (int x = min - 1; x > 0; x--) {
//            numberator *= range--;
//            denominator *= x;
//        }
//        return (int) (numberator / denominator);
//    }

    public static void main(String[] args) {
        int m = 1, n = 2;
        System.out.println(new Solution2DDP().uniquePaths(m, n));
    }
}