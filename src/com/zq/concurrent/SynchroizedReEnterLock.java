package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 14:21
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SynchroizedReEnterLock {

    //可重入锁支持父对象和子对象

    public static void main(String[] args) {

        class Mythread extends Thread {
            @Override
            public void run() {
                Service service = new Service();
                service.service1();
            }
        }


        Mythread mythread = new Mythread();
        mythread.start();
    }

    private static class Service {
        synchronized void service1() {
            System.out.println("service1");
            service2();
        }

        synchronized void service2() {
            System.out.println("service2");
            service3();
        }

        synchronized void service3() {
            System.out.println("service3");
        }
    }
}
