package MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 答案错误，64%
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int res = 10001;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j >= i && arr[j] - arr[i] <= x && n - (j - i + 1) < res) {
                    res = n - (j - i + 1);
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
