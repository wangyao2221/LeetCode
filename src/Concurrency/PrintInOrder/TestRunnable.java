package Concurrency.PrintInOrder;

public class TestRunnable {
    public static void main(String[] args) {
        Runnable runnableA = () -> {
            while (true) {
                System.out.println("runnableA");
            }
        };

        Runnable runnableB = () -> {
            while (true) {
                System.out.println("runnableA");
            }
        };

        Runnable runnableC = () -> {
            while (true) {
                System.out.println("runnableA");
            }
        };

        runnableA.run();
        runnableB.run();
        runnableC.run();
    }
}
