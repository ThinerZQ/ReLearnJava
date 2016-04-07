package com.zq.trys.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 11:25
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadInstanceVarible2 {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"c");
        Thread d = new Thread(myThread,"d");
        Thread e = new Thread(myThread,"e");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
    private static class MyThread extends Thread{
        private int count=5;

        @Override
        public synchronized void run() {
            count--;
            System.out.println("from "+this.currentThread().getName()+" compute count="+count);
        }
    }

}
