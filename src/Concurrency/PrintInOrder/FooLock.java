package Concurrency.PrintInOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooLock {
    private int i = 1;
    private ReentrantLock lock;
    private Condition secondCondition, thirdCondition;

    public FooLock() {
        lock = new ReentrantLock();
        secondCondition = lock.newCondition();
        thirdCondition = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        fun(1, 2, null, secondCondition, printFirst);
//        lock.lock();
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        i = 2;
//        secondCondition.signal();
//        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        fun(2, 3, secondCondition, thirdCondition, printSecond);
//        lock.lock();
//        while (i != 2) {
//            secondCondition.await();
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        i = 3;
//        thirdCondition.signal();
//        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        fun(3, 0, thirdCondition, null, printThird);
//        lock.lock();
//        while (i != 3) {
//            thirdCondition.await();
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//        lock.unlock();
    }

    /**
     *
     * @param expect 执行当前打印任务需要的标记值
     * @param next 下一个打印任务需要的标记值
     * @param currentCondition 当前任务执行的Condition
     * @param nextCondition 下一个任务执行的Condition
     * @param print 打印任务的线程
     * @throws InterruptedException
     */
    public void fun(int expect, int next, Condition currentCondition, Condition nextCondition, Runnable print) throws InterruptedException {
        lock.lock();

        while (currentCondition != null && i != expect) {
            currentCondition.await();
        }

        print.run();
        i = next;

        if (nextCondition != null) {
            nextCondition.signal();
        }

        lock.unlock();
    }

    public static void main(String[] args) {
        FooLock foo = new FooLock();
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
            foo.third(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}