package com.zq.concurrent.tools;

import com.zq.concurrent.forjoin.CountTask;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/14
 * Time: 14:59
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();

                for (int i = 4; i < 7; i++) {
                    System.out.println(i);
                }
            }
        }).start();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);
    }
}
