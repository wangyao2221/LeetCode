package WeeklyContest153.MaximumSubarraySumWithOneDeletion;

class Solution2 {
    public int maximumSum(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int minNeg = 0;

            if (arr[i] < 0) {
                minNeg = arr[i];
            }

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < 0 && arr[j] < minNeg) {
                    sum += minNeg;
                    minNeg = arr[j];
                } else {
                    sum += arr[j];
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {8, -1, 6, -7, -4, 5, -4, 7, -6};
//        int[] arr = {-1,-1,-1,-1};
        System.out.println(new Solution2().maximumSum(arr));
    }
}