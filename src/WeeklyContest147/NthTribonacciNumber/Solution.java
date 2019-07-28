package WeeklyContest147.NthTribonacciNumber;

class Solution {
    public int tribonacci(int n) {
        int t0 = 0,t1 = 1, t2 = 1, t3 = 0;

        if (n == 0) return t0;
        if (n == 1) return t1;
        if (n == 2) return t2;

        for (int i = 0; i < n - 2; i++) {
            t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        return t3;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(25));
    }
}