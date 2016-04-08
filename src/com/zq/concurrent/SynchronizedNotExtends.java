package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 14:36
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

/**
 * 同步不具有继承性
 */
public class SynchronizedNotExtends {

    public static void main(String[] args) {


        class MythreadA extends Thread {
            private Sub sub;

            public MythreadA(Sub sub) {
                super();
                this.sub = sub;
            }

            @Override
            public void run() {
                try {
                    sub.serviceMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        class MythreadB extends Thread {
            private Sub sub;

            public MythreadB(Sub sub) {
                super();
                this.sub = sub;
            }

            @Override
            public void run() {
                try {
                    sub.serviceMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        Sub sub = new Sub();
        MythreadA a = new MythreadA(sub);
        a.setName("A");
        a.start();

        MythreadB b = new MythreadB(sub);
        b.setName("B");
        b.start();
    }


    static class Parent {
        synchronized void serviceMethod() throws InterruptedException {
            System.out.println("in parent 下一步 sleep begin threadName = " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("in parent 下一步 sleep end threadName = " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());

        }
    }

    static class Sub extends Parent {

        synchronized void serviceMethod() throws InterruptedException {
            System.out.println("in sub 下一步 sleep begin threadName = " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("in sub 下一步 sleep end threadName = " + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            super.serviceMethod();
        }
    }
}
