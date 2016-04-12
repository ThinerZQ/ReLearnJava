package com.zq.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 10:13
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class AtomicIntegerNotSafe {
    public static void main(String[] args) throws InterruptedException {

        AddCountThread addCountThread = new AddCountThread();
        Thread thread = new Thread(addCountThread);
        thread.start();
        Thread thread1 = new Thread(addCountThread);
        thread1.start();
        Thread thread2 = new Thread(addCountThread);
        thread2.start();
        Thread thread3 = new Thread(addCountThread);
        thread3.start();
        Thread thread4 = new Thread(addCountThread);
        thread4.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(addCountThread.count.get());

    }

    static class AddCountThread extends  Thread{
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public void run() {

                System.out.println(Thread.currentThread().getName()+" add 100 then :"+count.addAndGet(100));
                count.addAndGet(1);

        }
    }
}
