package com.zq.concurrent;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Money Zheng on 2016/7/31.
 */
public class ObjectWaitSignalTest {

    Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        class Producer implements Runnable{

            Queue<String> queue;

            public Producer(Queue<String> queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                int i=0;
                while (true) {
                    synchronized (queue) {
                        i++;
                        while (queue.size() == 100) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        queue.add(Thread.currentThread().getName()+" _ "+ i);

                    }
                }
            }
        }

        class Consumer implements Runnable{

            Queue<String> queue;

            public Consumer(Queue<String> queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                int i=0;
                while (true) {
                    synchronized (queue) {
                        i++;
                        while (queue.size() == 0) {
                            try {
                                queue.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        queue.add(Thread.currentThread().getName()+" _ "+ i);

                    }
                }
            }
        }


        ObjectWaitSignalTest test = new ObjectWaitSignalTest();

        ExecutorService producerThreadPools = Executors.newFixedThreadPool(10, new ThreadFactory() {
            private int i=1;
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Producer_"+i);
                i++;
                return thread;
            }
        });

        for (int i = 0; i < 10; i++) {
            producerThreadPools.submit(new Producer(test.queue));
        }

        ExecutorService comsumerThreadPools = Executors.newFixedThreadPool(5, new ThreadFactory() {
            private int i=1;
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("Consumer_"+i);
                i++;
                return thread;
            }
        });

        for (int i = 0; i < 10; i++) {
            comsumerThreadPools.submit(new Consumer(test.queue));
        }
    }
}
