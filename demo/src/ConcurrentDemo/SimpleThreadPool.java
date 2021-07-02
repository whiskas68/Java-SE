package ConcurrentDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class SimpleThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,10,1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5,true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("HH:mm:ss");
        for (int i =0;i<20;i++){
            final int index = i;
            /**
             * 设置核心线程数为2，队列为5，存活时间为1分钟
             * 当0-1号任务来时，陆续创建2个线程，接着2-6号任务（5个任务无线程可以用）进入队列中
             * 7-9号任务，没有空闲线程，且队列已满，所以又创建3个线程
             * 因此可以发现7-9号任务先执行，由于线程存活1分钟，线程进行复用，故总共只创建5个线程
             * */

            threadPoolExecutor.execute(()->{
                System.out.println(sdf.format(System.currentTimeMillis()) + ": "+Thread.currentThread().getName()+"Number of Tasks in Queue: "+threadPoolExecutor.getQueue().size()+","+index+"号任务"+"， Active Threads: "+threadPoolExecutor.getActiveCount());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }) ;

        }
    }
}
