package WeeklyContest152;

// TODO
class Solution {
    public int numPrimeArrangements(int n) {
        int result = 0;

        int primeNum = 0;
        int notPrimeNum = 0;

        for (int i = 1; i <= n; i++) {
            if (checkPrime(i)) {
                primeNum++;
            }
        }

        notPrimeNum = n - primeNum;
        result = (int) ((permutate(primeNum) * permutate(notPrimeNum)) % 1000000007);

        return result;
    }

    public boolean checkPrime(long n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public long permutate(long n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (int) (result * i) % 1000000007;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numPrimeArrangements(100));
    }
}