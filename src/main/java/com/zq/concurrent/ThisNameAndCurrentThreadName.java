package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 21:36
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThisNameAndCurrentThreadName {
    public static void main(String[] args) {

        CountOperate countOperate = new CountOperate();
        countOperate.setName("countOperateName");
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}

class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate--begin");
        System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName());
        System.out.println("this.getName()" + this.getName());
        System.out.println("CountOperate--end");
    }

    @Override
    public void run() {
        System.out.println("run--begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("run--end");
    }
}
