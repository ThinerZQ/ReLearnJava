package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 12:11
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class WaitLongMethod {

    static private Object lock = new Object();
    public static void main(String[] args) {

        Thread t = new Thread(runnable1);
        t.start();
    }


    static private  Runnable runnable1 = new java.lang.Runnable(){

        @Override
        public void run() {
            synchronized (lock){
                System.out.println("wait begin timer = "+ System.currentTimeMillis());
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end timer =" + System.currentTimeMillis());
            }
        }
    };
}
