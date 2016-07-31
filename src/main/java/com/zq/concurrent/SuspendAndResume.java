package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 9:43
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SuspendAndResume {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5000);
        //suspend
        myThread.suspend();
        System.out.println("A = " + System.currentTimeMillis() + " i= " + myThread.getI());
        Thread.sleep(5000);
        System.out.println("A = " + System.currentTimeMillis() + " i= " + myThread.getI());

        //resume
        myThread.resume();
        Thread.sleep(5000);

        //suspend
        System.out.println("B = " + System.currentTimeMillis() + " i= " + myThread.getI());
        Thread.sleep(5000);
        System.out.println("B = " + System.currentTimeMillis() + " i= " + myThread.getI());
    }

    private static class MyThread extends Thread {
        private long i = 0;

        @Override
        public void run() {
            while (true) {
                i++;
            }
        }

        public long getI() {
            return i;
        }

        public void setI(long i) {
            this.i = i;
        }
    }
}
