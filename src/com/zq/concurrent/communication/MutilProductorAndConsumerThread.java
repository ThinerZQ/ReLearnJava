package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 13:27
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class MutilProductorAndConsumerThread {

    public static void main(String[] args) throws InterruptedException {
        class ProductorThread extends Thread{
            private Producter producter;

            public ProductorThread(Producter producter) {
                this.producter = producter;
            }

            @Override
            public void run() {
                try {
                    while (true)
                        producter.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        class ConsumerThread extends Thread{
            private Consumer consumer;

            public ConsumerThread(Consumer consumer) {
                this.consumer = consumer;
            }

            @Override
            public void run() {
                try {
                    while (true)
                        consumer.comsume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        Object lock = new Object();
        Producter producter = new Producter(lock);
        Consumer consumer = new Consumer(lock);
        ProductorThread[] productorThreads = new ProductorThread[2];
        ConsumerThread[] consumerThread = new ConsumerThread[2];

        for (int i = 0; i < 2; i++) {
            productorThreads[i] = new ProductorThread(producter);
            productorThreads[i].setName("Productor"+(i+1));
            consumerThread[i] = new ConsumerThread(consumer);
            consumerThread[i].setName("Consumer"+(i+1));
            productorThreads[i].start();
            consumerThread[i].start();
        }


        Thread.sleep(5000);

        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() +"  "+ threads[i].getState());
        }
    }




    static class Producter{
        private Object lock;

        public Producter(Object lock) {
            this.lock = lock;
        }
        public void product() throws InterruptedException {
            synchronized (lock){
               while (!ValueObject.value.equals("")){
                   System.out.println("Productor "+Thread.currentThread().getName() +" Waiting");
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("Producotr "+Thread.currentThread().getName()+" Runnable");
                ValueObject.value = value;
                lock.notifyAll();
            }
        }
    }

    static class Consumer{
        private Object lock;

        public Consumer(Object lock) {
            this.lock = lock;
        }
        public void comsume() throws InterruptedException {
            synchronized (lock){
                while (ValueObject.value.equals("")){
                    System.out.println("Consumer "+Thread.currentThread().getName() +" Waiting");
                    lock.wait();
                }
                System.out.println("Consumer "+Thread.currentThread().getName() +" Runnable");
                ValueObject.value="";
                lock.notifyAll();
            }
        }
    }



    static class ValueObject{
        public static String value="";
    }
}
