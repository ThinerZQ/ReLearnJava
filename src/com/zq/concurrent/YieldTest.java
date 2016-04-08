package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 10:09
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class YieldTest {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            int count = 0;
            for (int i = 0; i < 50000000; i++) {
                Thread.yield();
                count = count + (i + 1);
            }
            long end = System.currentTimeMillis();
            System.out.println("use times: " + (end - begin) + " mill seconds !");
        }
    }
}
