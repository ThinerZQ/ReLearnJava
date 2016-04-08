package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 14:10
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SynchronizedMethodLockObject2 {
    public static void main(String[] args) {

        class ThreadA extends Thread {
            private MyObject object;

            public ThreadA(MyObject object) {
                this.object = object;
            }

            @Override
            public void run() {
                super.run();
                try {
                    object.methodA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class ThreadB extends Thread {
            private MyObject object;

            public ThreadB(MyObject object) {
                this.object = object;
            }

            @Override
            public void run() {
                super.run();
                try {
                    object.methodB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();

    }

    public static class MyObject {
        synchronized void methodA() throws InterruptedException {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end time " + System.currentTimeMillis());
        }

        synchronized void methodB() throws InterruptedException {
            System.out.println("begin methodB threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end time ");
        }
    }
}
