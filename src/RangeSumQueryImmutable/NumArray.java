package RangeSumQueryImmutable;

class NumArray {
    private int[][] dp;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;

        dp = new int[nums.length][nums.length];

        dp[0][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[i][j] = dp[i - 1][j] - nums[i - 1];
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp.length; j++) {
//                System.out.print(dp[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }
    
    public int sumRange(int i, int j) {
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] input = {-2, 0, 3, -5, 2, -1};
        System.out.println(new NumArray(input).sumRange(0,2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */