package MeiTuan;

import java.util.Scanner;

/**
 * 超时，64%
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; m > 0; i++) {
            int tmp = m - arr[i % n];
            if (tmp >= 0) {
                res++;
                m = tmp;
            }
        }

//        if (m < 0) {
//            res--;
//        }
//        int sum = 0;
//        for (int i = 0; sum <= m; i++) {
//            sum += arr[i % n];
//            res++;
//        }

        System.out.println(res);
    }
}
