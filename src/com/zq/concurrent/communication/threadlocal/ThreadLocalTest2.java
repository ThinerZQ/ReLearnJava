package com.zq.concurrent.communication.threadlocal;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 15:36
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadLocalTest2 {
    public static ThreadLocal t1 = new ThreadLocal();
    public static void main(String[] args) {
        class ThreadA extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    ThreadLocalTest2.t1.set("ThreadA"+ (i+1));
                    System.out.println("Thread A get Value ="+ ThreadLocalTest2.t1.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        class ThreadB extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    ThreadLocalTest2.t1.set("ThreadB"+ (i+1));
                    System.out.println("Thread B get Value ="+ ThreadLocalTest2.t1.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        try{
            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();
            for (int i = 0; i < 100; i++) {
                ThreadLocalTest2.t1.set("main "+(i+1));
                System.out.println("Main get Value ="+ ThreadLocalTest2.t1.get());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
