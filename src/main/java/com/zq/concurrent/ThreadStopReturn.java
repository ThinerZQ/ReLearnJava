package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 9:38
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadStopReturn {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    System.out.println("stoped");
                    return;
                }
                System.out.println("timer= " + System.currentTimeMillis());
            }
        }
    }
}
