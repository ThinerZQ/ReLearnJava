package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 9:59
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class VolatileNonAtomicity {
    public static void main(String[] args) {

        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
    }


    static class MyThread extends Thread{
        volatile static int count;
         private static void addCount() {
            for (int i = 0; i < 100; i++) {
                count++;
            }
            System.out.println("count =" + count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
