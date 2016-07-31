package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 15:22
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

/**
 * join后面的代码提前执行,,,实际不会。日了狗了
 */
public class JoinMoreTest {
    public static void main(String[] args) {

        class ThreadB extends Thread{
            @Override
            public void run() {
                try{
                    System.out.println("begin B ThreadName="+Thread.currentThread().getName()+" "+ System.currentTimeMillis());
                    Thread.sleep(5000);
                    System.out.println("end B ThreadName="+Thread.currentThread().getName()+" "+ System.currentTimeMillis());

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        class ThreadA extends Thread{
            private ThreadB b;

            public ThreadA(ThreadB b) {
                this.b = b;
            }

            @Override
            public void run() {
                try{
                    synchronized (b){
                        System.out.println("begin A ThreadName="+Thread.currentThread().getName()+" "+ System.currentTimeMillis());
                        Thread.sleep(5000);
                        System.out.println("end A ThreadName="+Thread.currentThread().getName()+" "+ System.currentTimeMillis());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);
        threadA.start();
        threadB.start();
        try {
            threadB.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end :" + System.currentTimeMillis());

    }
}
