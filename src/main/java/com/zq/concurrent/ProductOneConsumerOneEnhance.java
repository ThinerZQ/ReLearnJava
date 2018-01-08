package com.zq.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2016/10/15 21:40
 * Project：learn
 * Package：com.zq.concurrent
 */

/**
 * 为什么有错误了，没有获得对象的对象所
 */
public class ProductOneConsumerOneEnhance {public static void main(String[] args) {

    ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
    Object empty = new Object();
    Object full = new Object();


    for (int i = 0; i < 1; i++) {
        Consumer consumer = new Consumer(concurrentLinkedQueue,empty,full);
        Thread t2 = new Thread(consumer);
        t2.start();
    }
    for (int i = 0; i < 1; i++) {
        Producer producer = new Producer(concurrentLinkedQueue,empty,full);
        Thread t1 = new Thread(producer);
        t1.start();
    }
}


    static class Producer implements Runnable{

        private ConcurrentLinkedQueue<Integer> queue;
        Object empty ;
        Object full ;
        private static Integer base=new Integer(0);
        public Producer(ConcurrentLinkedQueue<Integer> queue,Object empty,Object full) {
            this.queue = queue;
            this.empty = empty;
            this.full = full;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        while (!queue.isEmpty() && queue.size() > 10) {
                            full.wait();
                        }
                        queue.offer(base++);
                        //没有获得这个对象的锁
                        empty.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("producer " + Thread.currentThread().getName() + " has problem");
                        break;
                    }
                }
            }
        }
    }
    static class Consumer implements Runnable{

        private ConcurrentLinkedQueue<Integer> queue;
        Object empty ;
        Object full ;
        public Consumer(ConcurrentLinkedQueue<Integer> queue,Object empty,Object full) {
            this.queue = queue;
            this.queue = queue;
            this.empty = empty;
            this.full = full;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue) {
                    try {
                        while (queue.isEmpty()) {
                            empty.wait();
                        }
                        System.out.println(queue.poll());
                        full.notify();
                    } catch (Exception e) {
                        System.out.println("consumer " + Thread.currentThread().getName() + " has problem");
                        break;
                    }
                }
            }
        }
    }
}
