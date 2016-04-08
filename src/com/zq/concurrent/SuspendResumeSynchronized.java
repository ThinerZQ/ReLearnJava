package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 9:48
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SuspendResumeSynchronized {
    public static void main(String[] args) {


        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread.setName("a");
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 start, but it can enter into printString method");
                    System.out.println();
                    object.printString();
                }
            };
            thread1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static class SynchronizedObject {
        synchronized public void printString() {
            System.out.println("begin");
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("a thread suspend for ever");
                Thread.currentThread().suspend();
            }
            System.out.println("end");
        }
    }

}
