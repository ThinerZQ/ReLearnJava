package com.zq.concurrent.example.sellticket;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午4:49
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class Client {
    public static void main(String[] args) {

        //通过Thread实现
        SellByThread thread1 = new SellByThread("窗口1");
        SellByThread thread2 = new SellByThread("窗口2");
        SellByThread thread3 = new SellByThread("窗口3");

        /*thread1.start();
        thread2.start();
        thread3.start();*/

        //通过Runnable实现

        SellByRunnable runnable = new SellByRunnable();

        Thread thread4  = new Thread(runnable,"窗口1");
        Thread thread5  = new Thread(runnable,"窗口2");
        Thread thread6  = new Thread(runnable,"窗口3");

        thread4.start();
        thread5.start();
        thread6.start();
    }
}
