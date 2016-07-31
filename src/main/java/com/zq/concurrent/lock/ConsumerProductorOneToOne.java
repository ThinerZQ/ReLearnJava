package com.zq.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 16:34
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ConsumerProductorOneToOne {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
    }
    private static class MyService{
        private Lock lock =new ReentrantLock();
        private Condition condition = lock.newCondition();
        private boolean hasValue=false;

        public void set(){
            try{
                lock.lock();
                while (hasValue == true){
                    condition.await();
                }
                System.out.println("*****");
                hasValue =true;
                condition.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        public void get(){

            try{
                lock.lock();
                while (hasValue ==false) {
                    condition.await();
                }
                System.out.println("----");
                hasValue =false;
                condition.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
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
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                myService.set();
            }
        }
    }
    static class ThreadB extends Thread{
        private MyService myService ;

        public ThreadB(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                myService.get();
            }
        }
    }
}
