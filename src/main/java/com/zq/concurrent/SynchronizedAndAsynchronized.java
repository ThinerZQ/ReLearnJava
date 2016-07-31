package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 14:57
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SynchronizedAndAsynchronized {
    public static void main(String[] args) {

        class MyThreadA extends Thread {
            private Task task;

            public MyThreadA(Task task) {
                this.task = task;
            }

            @Override
            public void run() {
                super.run();
                task.doLongTimeTask();
            }
        }
        class MyThreadB extends Thread {
            private Task task;

            public MyThreadB(Task task) {
                this.task = task;
            }

            @Override
            public void run() {
                super.run();
                task.doLongTimeTask();
            }
        }

        Task task = new Task();
        MyThreadA thread = new MyThreadA(task);
        MyThreadB threadB = new MyThreadB(task);
        thread.start();
        threadB.start();


    }


}

class Task {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName = " + Thread.currentThread().getName() + " i= " + (i + 1));
        }
        System.out.println("  ");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + " i= " + (i + 1));
            }
        }
    }
}