package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/31
 * Time: 14:07
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ConcurrencyTest {
    private static final long count = 1000000000l;

    public static void main(String[] args) throws InterruptedException {

        concurrentcy();
        serial();
    }

    private static void concurrentcy() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println("currency times:" + (end - start));
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long end = System.currentTimeMillis();
        System.out.println("serial times:" + (end - start));
    }
}
