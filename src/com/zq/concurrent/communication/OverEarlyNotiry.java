package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 12:15
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class OverEarlyNotiry {
    private String lock = new String();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("begin wait");
                    lock.wait();
                    System.out.println("end wait");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock){
                System.out.println("begin notify");
                lock.notify();
                System.out.println("end notify");
            }
        }
    };

    public static void main(String[] args) {
        OverEarlyNotiry overEarlyNotiry = new OverEarlyNotiry();
        Thread b = new Thread(overEarlyNotiry.runnable1);
        b.start();
        Thread a = new Thread(overEarlyNotiry.runnable);
        a.start();
    }
}
