package UniquePaths;

class SolutionTimeLimitExceeded {
    public int count;

    public int uniquePaths(int m, int n) {
        find(m, n);
        return count;
    }

    private void find(int m, int n) {
        if (m == 1 && n == 1) {
            count++;
            return;
        }

        if (m - 1 > 0) {
            find(m - 1, n);
        }

        if (n - 1 > 0) {
            find(m, n - 1);
        }
    }

    public static void main(String[] args) {
        int m = 7, n = 3;
        System.out.println(new SolutionTimeLimitExceeded().uniquePaths(m, n));
    }
}