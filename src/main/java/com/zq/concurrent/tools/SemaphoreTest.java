package com.zq.concurrent.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/14
 * Time: 15:25
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore =new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public  void run() {
                    try{
                        semaphore.acquire();
                        System.out.println("save data"+ finalI);
                        System.out.println("available permits:"+semaphore.availablePermits());
                        semaphore.release();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

        }
        threadPool.shutdown();
    }
}
