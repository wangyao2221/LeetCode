package PrintFooBarAlternately;

import java.util.concurrent.atomic.AtomicInteger;

class FooBarWithAtomicIntegerWrong {
    private int n;
    private volatile AtomicInteger flag;

    public FooBarWithAtomicIntegerWrong(int n) {
        this.n = n;
        flag = new AtomicInteger(0);
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (!flag.compareAndSet(0, 1)) {
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (!flag.compareAndSet(1, 0)) {
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        }
    }
}