package ClimbingStairs;

class Solution {
    public int climbStairs(int n) {
        int result = 0;

        int first = 0;
        int second = 1;

        while (n-- > 0){
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }

//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;
//
//        int ans1 = 1;
//        int ans2 = 2;
//
//        for (int i = 2; i < n; i++) {
//            int tmp = ans2;
//            ans2 = ans1 + ans2;
//            ans1 = tmp;
//        }
//
//        return ans2;
//    }


    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
    }
}