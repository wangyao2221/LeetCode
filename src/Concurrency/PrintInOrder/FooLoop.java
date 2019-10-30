package Concurrency.PrintInOrder;

class FooLoop {
    private volatile int i;

    public FooLoop() {
        i = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (i != 1);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        FooLoop foo = new FooLoop();
        Runnable printFirst = () -> {
            System.out.println(1);
        };

        Runnable printSecond = () -> {
            System.out.println(2);
        };

        Runnable printThird = () -> {
            System.out.println(3);
        };

        new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}