> LeetCode新出了一类多线程的题目，主要考察的是对编程语言中多线程的用法以及多线程的算法，目前只有四题，这篇博客是对第一个1114这个多线程题目的分析。

## 题目
Suppose we have a class:

```java
public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
```

The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Example 1:

> Input: [1,2,3] 
> Output: "firstsecondthird" 
> Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third()."firstsecondthird" is the correct output.

Example 2:

> Input: [1,3,2] 
> Output: "firstsecondthird" 
> Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 
Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

## 题意
题目给出了三个方法方法：

```java
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
```
后台的main方法将会以多线程的形式调用者三个方法，至于调用顺序，既然是多线程，那么调用顺序和执行顺序是没必然关联的，可能先创建的线程里的代码有更大概率先执行，但这不是绝对的。

题目给出的例子第一眼看过去似乎有点摸不着头脑（本人觉得），不就是按顺序打印三个单词嘛，结果只有一个，为什么还要给不同的输入？这其实就是告诉我们不管线程的调用顺序如何都要使结果按序输出。
## 代码
以下将采用Java中不同方法对这题进行实现，来体会一下Java中各种不同的多线程实现机制
### 1. 不加锁
看到题目之后，大家应该都会想到这一题貌似不用多线程的东西都可以解决，也就是使用一个标记变量来标记当前需要执行哪一个打印代码。当前面的打印任务没完成时，使用while循环来等待标记变成当前打印任务可执行的标记，当当前打印任务完成是将标记赋值为下一个打印任务可行的标记。具体代码如下：

```java
package Concurrency.PrintInOrder;

class Foo {
	//因为没有加锁，因此要加volatile关键字保证i的可见性
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
}
```
### 2. 使用synchronized对方法加锁
回头看一下上面不加锁的代码，可以想到不加锁会存在while不断循环提高内存消耗的问题（事实上就打印三个单词，体现不出内存消耗差别），因此我们考虑到以加锁和阻塞等待的方式改写代码。

同样的，我们首先要使用一个标记变量来标记当前需要执行哪一个打印代码，不同的是在标记不是当前打印任务可执行的标记时不是进行不断循环，而是进行等待（wait()方法），等待标记发生变化，当标记仍不是当前任务可执行的标记时继续等待，注意在每个方法上加上synchronized关键字：

```java
class Foo {
    private int i;

    public Foo() {
        i = 1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
    	// 其实i初始化为1此处就不用写这个while，但为了每个方法看起更统一(优雅︿(￣︶￣)︿)，也写上了，这不影响效率
        while (i != 1) {
            wait();
        }
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // 将标记赋值为2，让打印second的代码可以执行
        
        i = 2;
        //通知其他线程我打印完了，标记i有变化了
        notifyAll(); 
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (i != 2) {
            wait();
        }
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 3;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (i != 3) {
            wait();
        }
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
```
上面的代码似乎有些重复代码，来重构一下：

```java
class Foo {
    private int i;

    public Foo() {
        i = 1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        fun(1, 2, printFirst);
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        fun(2, 3, printSecond);
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        fun(3, 0, printThird);
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
}
```
这样子代码看起来就舒服多了(￣▽￣)~*
### 3. 使用具备CAS操作的原子类
CAS是一种乐观锁机制，其实是不加锁但是达到了加锁的效果、避免了阻塞，感兴趣的可以看这里[Java CAS 原理分析](https://www.imooc.com/article/40690)，下面就是使用Java中具备CAS操作的AtomicInteger的代码：
```java
// 注意导入这个原子类
import java.util.concurrent.atomic.AtomicInteger;

class Foo {
    private AtomicInteger i;

    public FooCAS() {
        i = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
    	// 如果i的值是1则将i的值设置为2，这涉及到CAS操作的，不懂的可以看前面给的链接
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
}
```
### 4. 使用重入锁
Java中的重入锁ReentrantLock是一种轻量级锁，而synchronized是重量级锁，轻量级锁配合好多项成算法可以提高程序的执行效率，关于轻量级锁可以看[浅谈偏向锁、轻量级锁、重量级锁](https://www.jianshu.com/p/36eedeb3f912)，其实以下这段和使用synchronized是一样的只是，将锁换成了ReentrantLock，把wait和notifyAll换成了Condition的await和signal，关于可以看[Java并发学习之ReentrantLock的工作原理及使用姿势](https://cloud.tencent.com/developer/article/1038499)。

这里可能有人会注意到，我使用了两个Condition，完全可以使用一个Condition，然后采用synchronized实现中一样的逻辑来写呀？关于这个我的想法是：在synchronized实现的代码中，使用的是notifyAll，是通知所有在等待的线程，而我这里使用两个Condition的话，下一个要执行的是哪个线程我就去通知哪个线程，这样其他线程中的while就不会在此进行循环了，虽然在这个程序中体现不出任何优势，但如果深入思考——如果线程很多且while中的wait之前要执行耗时操作（比如大量打印日志），此时每个线程分配一个单独的Condition就有优势了。这是我的想法，不知道在真实场景中对不对，如果大佬认为思路有问题，请评论告知呀。
```java
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
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 2;
        secondCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (i != 2) {
            secondCondition.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 3;
        thirdCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (i != 3) {
            thirdCondition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}
```
上面的代码好像也有些重复代码，再来重构一下：

```java
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
    }

    public void second(Runnable printSecond) throws InterruptedException {
        fun(2, 3, secondCondition, thirdCondition, printSecond);
    }

    public void third(Runnable printThird) throws InterruptedException {
        fun(3, 0, thirdCondition, null, printThird);
    }
    
    /**
     * 这重构的好像有点臭ε(┬┬﹏┬┬)3，不过看起来还是比上面舒服
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
}
```
### 测试
由于题目没有给出测试方法，我写了一个main方法作为测试，至于题目中不同的输入交换一下不同线程的顺序即可，其实没什么区别：

```java
public static void main(String[] args) {
        Foo foo = new Foo();
        
        Runnable printFirst = () -> {
            System.out.println("first");
        };

        Runnable printSecond = () -> {
            System.out.println("first");
        };

        Runnable printThird = () -> {
            System.out.println("third");
        };

        try {
            foo.first(printFirst);
            foo.second(printSecond);
            foo.first(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
```
## 总结
这道题其实使用上面四种实现方式执行时间和内存消耗上都几乎没什么差别，主要是因为这里只打印三个单词，完全体现不出差别，在LeetCode上执行代码的时间和空间完全取决于服务器的状态，其实也就是靠运气了┗( ▔, ▔ )┛，如果以上内容有任何不合理的地方欢迎大佬下方留言告知。
