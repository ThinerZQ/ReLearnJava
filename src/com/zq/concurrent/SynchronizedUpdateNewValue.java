package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 10:25
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SynchronizedUpdateNewValue {
    public static void main(String[] args) throws InterruptedException {


        class  ThreadA extends Thread{
            private Service service;

            public ThreadA(Service service) {
                this.service = service;
            }

            @Override
            public void run() {
                service.runMethod();
            }
        }
        class  ThreadB extends Thread{
            private Service service;

            public ThreadB(Service service) {
                this.service = service;
            }

            @Override
            public void run() {
                service.stopMethod();
            }
        }

        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(1000);
        ThreadB b = new ThreadB(service);
        b.start();
        System.out.println("order stop has been sent");


    }




    static class Service{
        private boolean isContinueRun= true;
        public void runMethod(){
            String anyString = new String();
            while (isContinueRun){
                synchronized (anyString){

                }
            }
            System.out.println("i am stopped");
        }
        public void stopMethod(){
            isContinueRun =false;
        }
    }

}
