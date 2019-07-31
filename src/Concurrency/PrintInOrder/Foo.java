package Concurrency.PrintInOrder;

class Foo {
    private int i;

    public Foo() {
        i = 1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        fun(1, 2, printFirst);
//        while (i != 1) {
//            wait();
//        }
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        i = 2;
//        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        fun(2, 3, printSecond);
//        while (i != 2) {
//            wait();
//        }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        i = 3;
//        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        fun(3, 0, printThird);
//        while (i != 3) {
//            wait();
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
    }

    /**
     *
     * @param expect 执行当前打印任务需要的标记值
     * @param next 下一个打印任务需要的标记值
     * @param print 打印任务的线程
     * @throws InterruptedException
     */
    public void fun(int expect, int next, Runnable print) throws InterruptedException {
        while (i != expect) {
            wait();
        }

        print.run();
        i = next;
        notifyAll();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
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