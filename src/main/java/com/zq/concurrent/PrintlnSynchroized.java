package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 21:14
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class PrintlnSynchroized {
    public static void main(String[] args) {
        MyThread run = new MyThread();

        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(run);
            thread1.start();
        }
    }


}

class MyThread extends Thread {
    private int i = 100;

    @Override
    public void run() {
        System.out.println("i=" + (i--) + " threadName: " + Thread.currentThread().getName());
    }
}