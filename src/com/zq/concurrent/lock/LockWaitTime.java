package com.zq.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 16:53
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

/**
 * tryLock()方法等待申请超时，自动返回false，如果没有等待时间直接返回false
 *
 */
public class LockWaitTime {


    public static void main(String[] args) {

        TimeLock timeLock = new TimeLock();
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);
        thread1.start();
        thread2.start();
    }
    private static class TimeLock implements Runnable{

        private static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    Thread.sleep(6000);
                } else {
                    System.out.println("get lock failed");
                }
            }catch (Exception e ){
                e.printStackTrace();
            }finally {
                if (lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }
}
