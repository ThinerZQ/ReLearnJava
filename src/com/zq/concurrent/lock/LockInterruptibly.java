package com.zq.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 16:47
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class LockInterruptibly {
    public static void main(String[] args) throws InterruptedException {

        InterruptLock lock = new InterruptLock(1);
        InterruptLock lock2 = new InterruptLock(2);

        Thread thread1 = new Thread(lock);
        Thread thread2 = new Thread(lock2);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread2.interrupt();

    }


    private static class InterruptLock implements Runnable{

        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();

        int lock;

        public InterruptLock(int lock) {
            this.lock = lock;
        }


        @Override
        public void run() {


            try{
                if (lock==1){
                    lock1.lockInterruptibly();
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    lock2.lockInterruptibly();
                }else{
                    lock2.lockInterruptibly();;
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    lock1.lockInterruptibly();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (lock1.isHeldByCurrentThread())
                    lock1.unlock();
                if (lock2.isHeldByCurrentThread())
                    lock2.unlock();
                System.out.println(Thread.currentThread().getName()+": thread exit");
            }


        }
    }
}
