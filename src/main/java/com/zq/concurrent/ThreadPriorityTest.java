package com.zq.concurrent;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 10:14
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadPriorityTest {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(1);
            thread2.start();
            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(10);
            thread1.start();

        }
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            long addResult = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 50000; j++) {
                    Random random = new Random();
                    random.nextInt();
                    addResult = addResult + i;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("********** thread 1 use time =" + (end - begin));
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            long addResult = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 50000; j++) {
                    Random random = new Random();
                    random.nextInt();
                    addResult = addResult + i;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(" zero * thread 1 use time =" + (end - begin));
        }
    }
}
