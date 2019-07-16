package MaximumSubarray;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
class Solution {
    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(input));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            if (tmp > max) {
                max = tmp;
            }

            if (tmp < 0) {
                tmp = Math.max(tmp, 0);
            }
        }

        return max;
    }
}