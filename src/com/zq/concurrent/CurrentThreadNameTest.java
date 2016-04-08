package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 21:23
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class CurrentThreadNameTest {
    public static void main(String[] args) {
        System.out.println("main method, current code segment is called by :" + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();

    }


    private static class MyThread extends Thread {
        public MyThread() {
            System.out.println("construct method, current code segment is called by :" + Thread.currentThread().getName());
        }

        @Override
        public void run() {
            System.out.println("run method , current code segment is called by :" + Thread.currentThread().getName());
        }
    }

}
