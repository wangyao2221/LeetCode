package LeetCode5434;

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int pre = 0;
        int max = 0;

        while (right < nums.length) {
            if (right == left && nums[right] == 0) {
                left++;
                right++;
            }

            while (right < nums.length && nums[right] == 1) {
                right++;
            }

            if (pre + (right - left) > max) {
                max = pre + (right - left);
            }
            pre = right - left;
            left = right;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[]{1,1,0,0,1,1,1,0,1}));
    }
}