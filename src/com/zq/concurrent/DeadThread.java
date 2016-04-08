package com.zq.concurrent;

import java.lang.reflect.Executable;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 16:15
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class DeadThread {
    public static void main(String[] args) {

        DeadThread2 deadThread2 = new DeadThread2();
        deadThread2.setFlag("a");
        Thread thread = new Thread(deadThread2);
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deadThread2.setFlag("b");
        Thread thread1 = new Thread(deadThread2);
        thread1.start();


    }


}

class DeadThread2 implements Runnable {

    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("lock 1-> lock2");
                }
            }
        }
        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println("username = " + username);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("lock2 -> lock1");
                }
            }
        }
    }
}
