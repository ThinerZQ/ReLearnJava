package com.zq.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 16:58
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TryLockNoneTime {
    public static void main(String[] args) {


        TryLock tryLock1 = new TryLock(1);
        TryLock tryLock2 = new TryLock(2);
        Thread thread1 = new Thread(tryLock1);
        Thread thread2 = new Thread(tryLock2);
        thread1.start();
        thread2.start();


    }
    private static class TryLock implements Runnable{
        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();
        int lock;

        public TryLock(int lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            if (lock ==1){
                while (true){
                    if (lock1.tryLock()){
                        try{
                            try{
                                Thread.sleep(500);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            if (lock2.tryLock()){
                                try{
                                    System.out.println(Thread.currentThread().getName()+" : My Job Done");
                                    return;
                                }finally {
                                    lock2.unlock();
                                }
                            }
                        }finally {
                            lock1.unlock();
                        }
                    }
                }
            }else {
                while (true){
                    if (lock2.tryLock()){
                        try{
                            try{
                                Thread.sleep(500);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            if (lock1.tryLock()){
                                try{
                                    System.out.println(Thread.currentThread().getName()+" : My Job Done");
                                    return;
                                }finally {
                                    lock1.unlock();
                                }
                            }
                        }finally {
                            lock2.unlock();
                        }
                    }
                }
            }
        }
    }
}
