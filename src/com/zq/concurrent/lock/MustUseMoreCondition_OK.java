package com.zq.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 16:30
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class MustUseMoreCondition_OK {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myService.singal_A();

    }


    private static class MyService{
        private Lock lock =new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void awaitA(){
            try{
                lock.lock();
                System.out.println("begin awaitA time "+System.currentTimeMillis()+ " ThreadName ="+ Thread.currentThread().getName());
                conditionA.await();
                System.out.println("end awaitA time "+System.currentTimeMillis()+ " ThreadName ="+ Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("waitA lock release");
            }
        }
        public void awaitB(){
            try{
                lock.lock();
                System.out.println("begin awaitB time "+System.currentTimeMillis()+ " ThreadName ="+ Thread.currentThread().getName());
                conditionB.await();
                System.out.println("end awaitB time "+System.currentTimeMillis()+ " ThreadName ="+ Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("waitB lock release");
            }
        }
        public void singal_A(){
            try{
                lock.lock();
                System.out.println("conditionA signalAll time is "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
                conditionA.signalAll();
            }finally {
                lock.unlock();
                System.out.println("conditionA signal lock release");
            }
        }
        public void singal_B(){
            try{
                lock.lock();
                System.out.println("conditionB signalAll time is "+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
                conditionB.signalAll();
            }finally {
                lock.unlock();
                System.out.println("conditionB signal lock release");
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
            myService.awaitA();
        }
    }
    static class ThreadB extends Thread{
        private MyService myService ;

        public ThreadB(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.awaitB();
        }
    }
}
