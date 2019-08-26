package Test;

public class FinalTest {
    public int a = 0;

    public static void main(String[] args) {
        final FinalTest finalTest = new FinalTest();
        int num = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(num);
            }
        });
    }
}
