package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 21:45
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadIsAlive {
    public static void main(String[] args) throws InterruptedException {

        MyThreadIsAlive t = new MyThreadIsAlive();
        System.out.println("begin == " + t.isAlive());
        t.start();
        Thread.sleep(1000);
        System.out.println("end == " + t.isAlive());
    }
}

class MyThreadIsAlive extends Thread {
    @Override
    public void run() {
        System.out.println("run = " + this.isAlive());
    }
}
