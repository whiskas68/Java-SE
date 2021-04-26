package ConcurrentDemo;

import java.util.concurrent.locks.LockSupport;

public class InterruptedMechanism {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{

            while (true) {
                System.out.println("t1线程运行中");
                System.out.println(Thread.currentThread().getState()+": 准备中断");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+"状态: "+Thread.currentThread().getState());

            }
            //
        },"t1");
        t1.start();


        LockSupport.unpark(t1);
        System.out.println(t1.getState());
        //
        //try {
        //    Thread.sleep(1000);
        //
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
    }
}
