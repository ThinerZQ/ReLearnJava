package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 9:59
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SuspendResumeLockStop {
    public static void main(String[] args) throws InterruptedException {

        Mythread mythread = new Mythread();
        mythread.start();
        Thread.sleep(1000);
        mythread.suspend();
        System.out.println("main end");
    }

    private static class Mythread extends Thread {
        private long i = 0;

        @Override
        public void run() {
            //suspend 之后，println的锁没有释放
            while (true) {
                i++;
                System.out.println(i);
            }
        }
    }
}
