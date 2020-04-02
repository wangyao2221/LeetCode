package MeiTuan;

import java.util.Scanner;

/**
 * 答案错误，24%
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        float[] p = new float[n];
        float[] s = new float[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextFloat();
        }
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextFloat();
        }

        float pp = p[0];
        float res = 0;
        for (int i = 0; i < n; i++) {
            res += pp * s[0];
            pp *= p[0];
        }

        System.out.println(Math.round(res * 100) / 100.0);
    }
}
