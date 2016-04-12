package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 13:11
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ProducterAndConsumer {




    public static void main(String[] args) {


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
        ProductorThread productorThread = new ProductorThread(producter);
        ConsumerThread consumerThread = new ConsumerThread(consumer);

        productorThread.start();
        consumerThread.start();
    }


    static class Producter{
        private Object lock;

        public Producter(Object lock) {
            this.lock = lock;
        }
        public void product() throws InterruptedException {
            synchronized (lock){
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set value ="+ value);
                ValueObject.value = value;
                lock.notify();
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
                if (ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get value = "+ ValueObject.value);
                ValueObject.value="";
                lock.notify();
            }
        }
    }



    static class ValueObject{
        public static String value="";
    }



}


