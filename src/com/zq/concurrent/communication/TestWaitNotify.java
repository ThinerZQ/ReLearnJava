package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 11:10
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TestWaitNotify {

    public static void main(String[] args) {
        try{
            Object object = new Object();
            MyThread1 thread1 = new MyThread1(object);
            thread1.start();
            Thread.sleep(3000);
            MyThread2 thread2 = new MyThread2(object);
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    static class MyThread1 extends Thread{
        private Object lock;
        public MyThread1(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("begin wait time "+ System.currentTimeMillis());
                    lock.wait();
                    System.out.println("finish wait time "+ System.currentTimeMillis());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    static class MyThread2 extends Thread{
        private Object lock;
        public MyThread2(Object lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("begin notify time "+ System.currentTimeMillis());
                    lock.notify();
                    System.out.println("finish notify time "+ System.currentTimeMillis());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
