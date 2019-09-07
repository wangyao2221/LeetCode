package Test;

public class BinaryIntegerTest {
    public static void main(String[] args) {
        // 正数转负数的位运算过程：取反 → +1  也就是计算反码
        int int1 = 1;
        int1 = ~int1;
        int1 = int1 + 1;
        System.out.println(int1);
        System.out.println(Integer.toBinaryString(int1));
        System.out.println();

        // 负数转正数的位运算过程：-1 → 取反  也就是计算源码
        int int2 = -1;
        int2 = int2 - 1;
        int2 = ~int2;
        System.out.println(int2);
        System.out.println(Integer.toBinaryString(int2));
        System.out.println();

        System.out.println((~(-100)));
    }
}
