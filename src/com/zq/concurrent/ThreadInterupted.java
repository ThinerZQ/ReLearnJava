package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 22:15
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadInterupted {
    public static void main(String[] args) throws InterruptedException {
        MyThreadInterupt myThreadInterupt = new MyThreadInterupt();
        myThreadInterupt.start();
        Thread.sleep(2000);
        myThreadInterupt.interrupt();

        System.out.println("end");
    }

}

class MyThreadInterupt extends MyThread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("i will finish");
                break;
            }
            System.out.println("i= " + i);
        }
    }
}