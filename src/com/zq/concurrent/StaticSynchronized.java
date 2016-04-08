package com.zq.concurrent;

import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 15:56
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class StaticSynchronized {
    public static void main(String[] args) {

        class ThreadA extends Thread {
            @Override
            public void run() {
                Service.PrintlnA();
            }
        }

        class ThreadB extends Thread {
            @Override
            public void run() {
                Service.PrintlnB();
            }
        }

        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();

    }


    static class Service {
        synchronized static void PrintlnA() {
            System.out.println("thread name :" + Thread.currentThread().getName() + " on " + System.currentTimeMillis() + " enter into printlnA");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name :" + Thread.currentThread().getName() + " on " + System.currentTimeMillis() + " exit printlnA");
        }

        synchronized static void PrintlnB() {
            System.out.println("thread name :" + Thread.currentThread().getName() + " on " + System.currentTimeMillis() + " enter into printlnB");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name :" + Thread.currentThread().getName() + " on " + System.currentTimeMillis() + " exit printlnB");
        }
    }
}
