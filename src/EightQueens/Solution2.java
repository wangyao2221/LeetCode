package EightQueens;

import java.util.Arrays;
import java.util.Map;

public class Solution2 {
    public static int count = 0;

    public void backtrack(int[] result, int n, int k) {
        if (k == n) {
            System.out.println(Arrays.toString(result));
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            result[k] = i;
            if (check(result, k)) {
                backtrack(result, n, k + 1);
            }
            result[k] = -1;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        new Solution2().backtrack(result, n, 0);
        System.out.println(Solution2.count);
    }

    public boolean check(int[] result, int k) {
        for (int i = 0; i < k; i++) {
            if (result[i] == result[k] || Math.abs(result[k] - result[i]) == k - i) {
                return false;
            }
        }
        return true;
    }
}
