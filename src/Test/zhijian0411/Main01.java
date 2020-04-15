package Test.zhijian0411;

import java.util.ArrayList;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int[][] dp = new int[1001][1001];
        List<Integer[]> result = new ArrayList<>();

        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                if (i < j) {
                    dp[i][j] = sum(i + 1, j);
                } else if (j < i) {
                    dp[i][j] = sum(j, i - 1);
                }
            }
        }

        for (int i = 1; i < 1001; i++) {
            int n = i - 1;
            int m = i + 1;

            while (n >= 0 && m < 1001) {
                if (dp[i][n] < dp[i][m]) {
                    n--;
                } else if (dp[i][n] > dp[i][m]) {
                    m++;
                } else {
                    Integer[] tmp = new Integer[3];
                    tmp[0] = i;
                    tmp[1] = n--;
                    tmp[2] = m--;
                    result.add(tmp);
                }
            }
        }

        for (Integer[] r : result) {
            if (r[1] == 1) {
                System.out.println(r[1] + "-->" + (r[0] - 1) + ":" + r[0] + ":" + (r[0] + 1) + "-->" + r[2]);
            }
        }
    }

    public static int sum(int i, int j) {
        return (i + j) * (j - i + 1) / 2;
    }
}
