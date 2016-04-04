package com.zq.trys.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/1
 * Time: 15:33
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ReentrantLockExample {
    int a =0;
    ReentrantLock lock = new ReentrantLock();
    public void  writer(){
        lock.lock();
        try{
            a++;
            System.out.println("writer:"+a);
        }finally {
            lock.unlock();
        }
    }
    public void reader(){
        lock.lock();
        try{
            int i=a;
            System.out.println("reader:"+i);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.writer();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockExample.reader();
            }
        });
        thread.start();
        thread1.start();
    }
}
