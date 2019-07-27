package UniquePaths;

/**
 * 为什么用一维数组和二维数组的耗时会一样
 * 本题其实是二项式系数，看二项式系数性质.jpg
 */
class SolutionPermutation {
    /**
     * 排列组合：因为向左向右走多少步是固定的，要计算的就是选择向左向右走的时机
     * 但计算出的数值太大，溢出了
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return (int) (fac(m + n - 2) / fac(m - 1) / fac(n - 1));
    }

    public long fac(long n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

//    public int uniquePaths(int m, int n) {
//        int range = (m - 1) + (n - 1);
//        int min = m > n ? n : m;
//        long numberator = 1;
//        long denominator = 1;
//        for (int x = min - 1; x > 0; x--) {
//            numberator *= range--;
//            denominator *= x;
//        }
//        return (int) (numberator / denominator);
//    }

    public static void main(String[] args) {
        int m = 36, n = 7;
        System.out.println(new SolutionPermutation().uniquePaths(m, n));
    }
}