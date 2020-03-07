package Fibonacci;

/**
 * @author wangyao2221
 * 注意爆栈问题
 */
public class Solution {
    public static void main(String[] args) {
        long n = 50;
        long a = 1;
        long b = 1;
        for (int i = 2; i < 50; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }
}
