package HouseRobber;

class Solution {
//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//
//        int first = 0, second = 0, third = 0,result = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (first + nums[i] > second) {
//                result = first + nums[i];
//                first = second;
//                second = result;
//            } else {
//                result = second;
//                second = first + nums[i];
//                first = result;
//            }
//        }
//
//        return result;
//    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int result = 0;

        int[] dp = new int[nums.length + 3];

        for (int i = 0; i < nums.length; i++) {
            dp[i + 3] = Math.max(nums[i] + dp[i],nums[i] + dp[i + 1]);
            if (dp[i + 3] > result) {
                result = dp[i + 3];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input =  {2,7,9,3,1};
//        int[] input =  {1,1};
//        int[] input = {2,1,1,2};
        System.out.println(new Solution().rob(input));
    }
}