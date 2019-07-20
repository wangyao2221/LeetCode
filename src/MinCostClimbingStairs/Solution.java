package MinCostClimbingStairs;

class Solution {
//    public int minCostClimbingStairs(int[] cost) {
//        // dp[0] = 0 作为辅助元素！！！
//        // dp[i + 1] 表示到达第i层楼需要的最小花费
//        // [到达第i层的最小花费(dp[i + 1])] = [经过第i层和不经过i层(也就必定经过i - 1)的最小值]
//        // 动态转移方程就是：dp[i + 1] = min(cost[i] + d[i], cost[i - 1] + dp[i - 1])
//        int[] dp = new int[cost.length + 1];
//
//        for (int i = 1; i < cost.length; i++) {
//            dp[i + 1] = Math.min(cost[i] + dp[i], cost[i - 1] + dp[i - 1]);
//        }
//
//        return dp[cost.length];
//    }

//    public int minCostClimbingStairs(int[] cost) {
//        int first = 0, second = 0, tmp = second;
//
//        for (int i = 1; i < cost.length; i++) {
//            second = Math.min(cost[i] + second, cost[i - 1] + first);
//            first = tmp;
//            tmp = second;
//        }
//
//        return second;
//    }

    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0, result = 0;

        for (int i = 1; i < cost.length; i++) {
            result = Math.min(cost[i] + second, cost[i - 1] + first);
            first = second;
            second = result;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {10, 15, 20};
//        int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] input = {0};
        System.out.println(new Solution().minCostClimbingStairs(input));
    }
}