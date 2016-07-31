package com.zq.concurrent.threadpools.mythreadpool;

import java.util.concurrent.*;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午3:26
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Runnable runnable = null;
            if (i%2 == 0 )
                runnable = new TaskThreadA();
            else
                runnable = new TaskThreadB();
            MyThreadPool.getInstance().submit(runnable);
        }
        //等待所有任务执行完成
        MyThreadPool.getInstance().awaitTermination();

        long end = System.currentTimeMillis();
        System.out.println("time consume : "+ (end-start)+" ms");
        System.out.println("一共启动了: "+MyThreadPool.getInstance().getThreadCount()+" 个线程");









    }
}
