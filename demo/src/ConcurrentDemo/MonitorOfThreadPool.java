package ConcurrentDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitorOfThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,10,1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5,true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
        );
        threadPoolExecutor.execute(()->{
            System.out.println("ThreadPool Size: "+threadPoolExecutor.getPoolSize());
            System.out.println("Active Threads: "+threadPoolExecutor.getActiveCount());
            System.out.println("Number of Tasks"+threadPoolExecutor.getCompletedTaskCount());
            System.out.println("Number of Tasks in Queue: "+threadPoolExecutor.getQueue().size());
        });
        threadPoolExecutor.shutdown();
    }
}
