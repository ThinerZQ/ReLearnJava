package com.zq.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2016/10/15 21:10
 * Project：learn
 * Package：com.zq.concurrent
 */

/**
 * notify唤醒的是对方和己方线程，不划算
 */
public class ProductOneConsumerOne {

    public static void main(String[] args) {

        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer(concurrentLinkedQueue);
            Thread t1 = new Thread(producer);
            t1.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(concurrentLinkedQueue);
            Thread t2 = new Thread(consumer);
            t2.start();
        }
    }


    static class Producer implements Runnable{

        private ConcurrentLinkedQueue<Integer> queue;
        private static Integer base=new Integer(0);
        public Producer(ConcurrentLinkedQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        while (!queue.isEmpty() && queue.size() > 10) {
                            queue.wait();
                        }
                        queue.offer(base++);
                        queue.notify();
                    } catch (Exception e) {
                        System.out.println("producer " + Thread.currentThread().getName() + " has problem");
                    }
                }
            }
        }
    }
    static class Consumer implements Runnable{

        private ConcurrentLinkedQueue<Integer> queue;

        public Consumer(ConcurrentLinkedQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                synchronized (queue) {
                    try {
                        while (queue.isEmpty()) {
                            queue.wait();
                        }
                        System.out.println(queue.poll());
                        queue.notify();
                    } catch (Exception e) {
                        System.out.println("consumer " + Thread.currentThread().getName() + " has problem");
                    }
                }
        }
        }
    }
}
