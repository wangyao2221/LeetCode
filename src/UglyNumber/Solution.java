package UglyNumber;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> primes = new ArrayList<Integer>();

    public int GetUglyNumber_Solution(int index) {
        if(index == 1) return 1;
        int count = index - 1;
        int result = 0;

        for(int i = 2; count > 0; i++) {
            if(isUgly(i)) {
                count--;
                if(count == 0) {
                    result = i;
                }
            }

            if(isPrime(i)) primes.add(i);
        }

        return result;
    }

    public boolean isUgly(int num) {
        if(num == 2 || num == 3 || num == 5) return true;
        boolean result = false;

        for(int i = 0; i < primes.size() && primes.get(i) < num; i++) {
            int prime = primes.get(i);
            if((prime == 2 || prime == 3 || prime == 5) && num % prime == 0) {
                result = true;
            }
            if(prime != 2 && prime != 3 && prime != 5 && num % prime == 0) {
                result = false;
            }
        }

        return result;
    }

    public boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.GetUglyNumber_Solution(300));
        System.out.println("4.1%".trim());
    }
}