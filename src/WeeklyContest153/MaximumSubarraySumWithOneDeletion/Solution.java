package WeeklyContest153.MaximumSubarraySumWithOneDeletion;

class Solution {
    public int maximumSum(int[] arr) {
        if (arr.length == 0) return 0;

        int curSum = 0;
        int max = Integer.MIN_VALUE;
        int flag = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                if (flag > 1) {
                    curSum = 0;
                }

                curSum += arr[i];

                if (curSum > max) {
                    max = curSum;
                }

                flag = 0;
            } else {
                if (i == 0) {
                    max = arr[i];
                }
                flag++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] arr = {-1, -1, -1, -1};
        int[] arr = {8, -1, 6, -7, -4, 5, -4, 7, -6};
        System.out.println(new Solution().maximumSum(arr));
    }
}