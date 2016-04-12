package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 12:00
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class WaitMeetInterrupt {
    public static void main(String[] args) throws InterruptedException {


        class ThreadA extends Thread{
            private Object loc;

            public ThreadA(Object loc) {
                this.loc = loc;
            }

            @Override
            public void run() {
                Service service = new Service();
                service.testMethod(loc);
            }
        }

        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        Thread.sleep(5000);
        a.interrupt();


    }


    static class Service{
        public void testMethod(Object lock){
            try{
                synchronized (lock){
                    System.out.println("begin wait");
                    lock.wait();
                    System.out.println(" end wait");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("exception throw");
            }
        }
    }
}
