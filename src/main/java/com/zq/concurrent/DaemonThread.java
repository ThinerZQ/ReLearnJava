package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 10:40
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(5000);
        System.out.println("我离开了，thread对象再也不答应了，也就是停止了");
    }

    static class MyThread extends Thread {
        private int i = 0;

        @Override
        public void run() {
            try {
                while (true) {
                    i++;
                    System.out.println("i = " + (i));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
