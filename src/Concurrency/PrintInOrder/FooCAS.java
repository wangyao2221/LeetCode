package Concurrency.PrintInOrder;

import java.util.concurrent.atomic.AtomicInteger;

class FooCAS {
    private AtomicInteger i;

    public FooCAS() {
        i = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (!i.compareAndSet(1,2));
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!i.compareAndSet(2,3));
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while (!i.compareAndSet(3,4));
        printThird.run();
    }

    public static void main(String[] args) {
        FooCAS foo = new FooCAS();
        Runnable printFirst = () -> {
            System.out.println(1);
        };

        Runnable printSecond = () -> {
            System.out.println(2);
        };

        Runnable printThird = () -> {
            System.out.println(3);
        };

        try {
            foo.first(printFirst);
            foo.second(printSecond);
            foo.first(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}