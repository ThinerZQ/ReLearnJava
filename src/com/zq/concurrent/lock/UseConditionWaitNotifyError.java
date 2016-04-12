package com.zq.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 16:01
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class UseConditionWaitNotifyError {

    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
    }

    private static class MyService{
        private Lock lock =new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void await(){
            try{
                lock.lock();
                System.out.println("A");
                condition.await();
                System.out.println("B");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("lock release");
            }
        }
    }
    static class ThreadA extends Thread{
        private MyService myService ;

        public ThreadA(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.await();
        }
    }
}
