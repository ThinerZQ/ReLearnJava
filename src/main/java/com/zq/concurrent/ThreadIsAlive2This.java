package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 21:48
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadIsAlive2This {
    public static void main(String[] args) {

        CountOperate2 countOperate2 = new CountOperate2();
        Thread t1 = new Thread(countOperate2);
        System.out.println("main begin t1 is Alive = " + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 is Alive= " + t1.isAlive());
    }
}

class CountOperate2 extends Thread {
    public CountOperate2() {
        System.out.println("CountOperate2--begin");
        System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()" + Thread.currentThread().isAlive());
        System.out.println("this.getName()" + this.getName());
        System.out.println("this.isAlive()" + this.isAlive());
        System.out.println("CountOperate2--end");
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("run--begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()" + this.isAlive());
        System.out.println("run--end");
    }
}