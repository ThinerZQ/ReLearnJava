package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 14:26
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

/**
 * 出现异常自动释放锁
 */
public class ThrowExceptionNoLock {
    public static void main(String[] args) throws InterruptedException {

        class ThreadA extends Thread {
            private Service service;

            public ThreadA(Service service) {
                this.service = service;
            }

            @Override
            public void run() {
                service.testMethod();
            }
        }
        class ThreadB extends Thread {
            private Service service;

            public ThreadB(Service service) {
                this.service = service;
            }

            @Override
            public void run() {
                service.testMethod();
            }
        }


        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        Thread.sleep(500);
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();


    }

    private static class Service {

        synchronized void testMethod() {

            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("ThreadName = " + Thread.currentThread().getName() + " run beginTime = " + System.currentTimeMillis());
                int i = 1;
                while (i == 1) {
                    if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                        System.out.println("ThreadName = " + Thread.currentThread().getName() + " run exceptionTime = " + System.currentTimeMillis());
                        Integer.parseInt("a");
                    }
                }
            } else {
                System.out.println("Thread B run Time = " + System.currentTimeMillis());
            }
        }
    }
}
