package MeiTuan;

import java.util.Scanner;

/**
 * 超时，9%
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();

        int res = 0;
        int minLen = 2 * k + 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + minLen - 1; j < s.length(); j++) {
                if (isABA(s.substring(i, j + 1), k)) {
//                    System.out.println(i + " " + j);
//                    System.out.println(s.substring(i, j + 1));
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static boolean isABA(String s, int k) {
        int tmp = 0;
//        for (int i = 0, j = s.length() - 1; i <= j - 2; i++, j--) {
//            if (s.charAt(i) == s.charAt(j)) {
//                tmp++;
//                if (tmp >= k) {
//                    return true;
//                }
//            } else if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//        }

        boolean b = false;
        for (int i = k; i <= (s.length() - 1) / 2; i++) {
            boolean tmpB = true;
            for (int m = 0, n = s.length() - i; m < n - 2 && m < k - 1; m++, n--) {
                if (s.charAt(m) != s.charAt(n)) {
                    tmpB = false;
                    break;
                }
            }
            b = b || tmpB;
        }
        return b;
    }
}
