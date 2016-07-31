package com.zq.concurrent.locksupport;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 17:11
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

import java.util.concurrent.locks.LockSupport;

/**
 * park()方法阻塞当前线程,支持响应中断，但是不会不会抛出InterruptedException ,可以通过Thread.interrupted()方法活得中断标记
 */
public class LockSupportTest2 {
    public static Object u = new Object();
    static ChangeObjectThread thread1 = new ChangeObjectThread("t1");
    static ChangeObjectThread thread2 = new ChangeObjectThread("t2");
    private static class ChangeObjectThread extends  Thread{
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in"+ getName());
                LockSupport.park();
                if (Thread.interrupted()){
                    System.out.println(getName()+ ": is interrupted");
                }
            }
            System.out.println("execute done");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.interrupt();
        LockSupport.unpark(thread2);
    }
}
