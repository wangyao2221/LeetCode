package RangeSumQueryImmutable;

class NumArray {
    private int[] dp;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;

        dp = new int[nums.length + 1];
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (dp.length == 0) return 0;
        return dp[j + 1] - dp[i];
    }

//    public NumArray(int[] nums) {
//        if (nums.length == 0) return;
//
//        dp = new int[nums.length];
//        dp[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = dp[i - 1] + nums[i];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if (dp.length == 0) return 0;
//        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
//    }

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