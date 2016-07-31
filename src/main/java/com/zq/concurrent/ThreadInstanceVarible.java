package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 11:12
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadInstanceVarible {
    public static void main(String[] args) {

        MyThread myThread = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        myThread.start();
        myThread2.start();
        myThread3.start();
    }

    private static class MyThread extends Thread {

        private int count = 5;

        public MyThread(String name) {
            super();
            this.setName(name);
        }

        @Override
        public void run() {
            super.run();
            while (count > 0) {
                count--;
                System.out.println("from " + this.currentThread().getName() + " compute count=" + count);
            }

        }
    }
}
