package ClimbingStairs;

class SolutionTimeLimitExceeded {
    private int result = 0;

    public int climbStairs(int n) {
        recur(n);
        return result;
    }

    public void recur(int n) {
        if (n == 0) {
            result++;
            return;
        }

        if (n < 0) {
            return;
        }

        recur(n - 1);
        recur(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new SolutionTimeLimitExceeded().climbStairs(4));
    }
}