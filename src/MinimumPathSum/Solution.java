package MinimumPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[grid[0].length];

        // 初始化第一行dp，因为这一行和后面几行有些不一样，没有上面一行
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }

        for (int i = 1; i < row; i++) {
            // dp的第一列要先算出（由于dp数组优化成了一维，所以事实上上就是dp的第一个元素），
            // 因为第一列计算跟后面几列计算方式有些不一样，没有前面一列
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}