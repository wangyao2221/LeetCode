package EightQueens;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    int count = 0;
    int n = 8;
    int[] col = new int[n];
    int[] result = new int[n];
    Set<String> set = new HashSet<>();

    public int eightQueens() {
        Arrays.fill(result, - 1);
        backtrack(0);
        return count;
    }

    public void backtrack(int i) {
        if (i == n) {
            count++;
//            System.out.println(Arrays.toString(result));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (check(i, j)) {
                col[j] = 1;
                set.add(i + "" + j);
                backtrack(i + 1);
                col[j] = 0;
                set.remove(i + "" + j);
            }
        }
    }

    public boolean check(int i, int j) {
        if (col[j] == 1) {
            return false;
        }

        for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
            if (set.contains(k + "" + l)) {
                return false;
            }
        }

        for (int k = i - 1, l = j + 1; k >= 0 && l < n; k--, l++) {
            if (set.contains(k + "" + l)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().eightQueens());
    }
}
