package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 22:23
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadInterupted2 {
    public static void main(String[] args) {

        try {
            MyThreadInterupt2 t = new MyThreadInterupt2();
            t.start();
            Thread.sleep(2000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThreadInterupt2 extends MyThread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("i will finish");
                    throw new InterruptedException();
                }
                System.out.println("i= " + i);
            }
            System.out.println("after for");
        } catch (InterruptedException e) {
            System.out.println("enter into catch method");
            e.printStackTrace();
        }

    }
}