package Test.threadTest;

import java.math.BigInteger;

public class FinalDomainTest {
    public final BigInteger[] arr;

    public FinalDomainTest(BigInteger[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        FinalDomainTest test = new FinalDomainTest(new BigInteger[]{BigInteger.valueOf(100)});
        BigInteger[] arr = test.arr;
        arr[0] = BigInteger.valueOf(10);
        System.out.println(test.arr[0]);
    }
}
