# synchronized和volatile实现原理



使用方法：

1. 修饰代码块
2. 修饰方法
3. 修饰静态方法
4. 修饰类



1-1 多个线程访问同个对象的同步代码块

```java
public class SynchronziedTread implements Runnable {

    private static Integer count = 0;

    @Override
    public void run() {
        synchronized (this){for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
    }
    public static void main(String[] args) {
        //多个线程访问同一对象的同步代码块
        SynchronziedTread master1 = new SynchronziedTread();
        Thread thread1 = new Thread(master1,"t1");
        Thread thread2 = new Thread(master1,"t2");
        thread1.start();
        thread2.start();
    }
}
```

输出结果：

```
t1: 0
t1: 1
t1: 2
t1: 3
t1: 4
t2: 5
t2: 6
t2: 7
t2: 8
t2: 9
```

结论：当两个线程t1,t2同时访问同一个对象master1中，被synchronized修饰的同步代码块时，当且只有一个线程t1可以获得锁，并执行指令，另外一个处于堵塞状态，直到t1线程释放锁，下一个线程t2才能获得锁并执行指令。

1-2 多个线程访问不同对象的同步代码块

```java
public static void main(String[] args) {
        //多个线程访问不同对象的同步代码块
        SynchronziedTread master3 = new SynchronziedTread();
        SynchronziedTread master4 = new SynchronziedTread();
        Thread thread3 = new Thread(master3,"thread-3");
        Thread thread4 = new Thread(master4,"thread-4");
        thread3.start();
        thread4.start();    
    
}

```

参考：https://blog.csdn.net/zhangqiluGrubby/article/details/80500505









