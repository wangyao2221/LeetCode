package Test;

public class NewThreadTest {
    public static long i = 0;
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(i++);
                }
            }).start();
        }
    }
}
