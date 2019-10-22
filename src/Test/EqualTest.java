package Test;

public class EqualTest {
    private int a;
    private int b;

    public static void main(String[] args) {
        EqualTest equalTestA = new EqualTest();
        EqualTest equalTestB = new EqualTest();
        System.out.println(equalTestA == equalTestB);
        System.out.println(equalTestA.equals(equalTestB));
    }
}
