package MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 超时，18%
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] max = new int[n + 1][n + 1];
        int[][] min = new int[n + 1][n + 1];

        minAndMax(arr, min, max);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(max[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(min[i][j] + " ");
            }
            System.out.println();
        }

        int flag = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (flag == 0) {
                    res = max[i + 1][j + 1] ^ min[i + 1][j + 1];
                    flag = 1;
                } else {
                    res = res ^ max[i + 1][j + 1] ^ min[i + 1][j + 1];
                }
            }
        }

        System.out.println(res);
    }

    public static void minAndMax(int[] arr, int[][] min, int[][] max) {
        int min_ = 100000001;
        int max_ = 0;

        for (int i = 0; i < arr.length + 1; i++) {
            Arrays.fill(min[i], min_);
            Arrays.fill(max[i], max_);
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = i; j <= arr.length; j++) {
                if (arr[j - 1] > max[i][j - 1]) {
                    max[i][j] = arr[j - 1];
                } else {
                    max[i][j] = max[i][j - 1];
                }

                if (arr[j - 1] < min[i][j - 1]) {
                    min[i][j] = arr[j - 1];
                } else {
                    min[i][j] = min[i][j - 1];
                }
            }
        }
    }
}
