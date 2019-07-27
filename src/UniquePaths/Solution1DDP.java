package UniquePaths;

/**
 * 为什么用一维数组和二维数组的耗时会一样
 * 本题其实是二项式系数，看二项式系数性质.jpg
 */
class Solution1DDP {

    /**
     * 只需要一辅助数组就能计算最后的结果
     * 比如：3 4
     * 第一次 1 1 1
     * 第二次 1 2 3
     * 第三次 1 3 6
     * 第四次 1 4 10
     * 观察可知每个除第一个位置外，其他位置的值都是前一个数字加上当要求位置数字的和
     * 例如：第二次的第二个位置 2 = 1 + 1 第三个位置 3 = 1 + 2
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;


        if(m > n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[m - 1];
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
        System.out.println(new Solution1DDP().uniquePaths(m, n));
    }
}