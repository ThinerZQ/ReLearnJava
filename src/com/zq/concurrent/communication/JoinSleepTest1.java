package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 15:08
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

/**
 * sleep方法不释放锁
 */
public class JoinSleepTest1 {
    public static void main(String[] args) throws InterruptedException {

        class ThreadB extends Thread{
            @Override
            public void run() {
                try{
                    System.out.println("b run begin timer ="+ System.currentTimeMillis());
                    Thread.sleep(5000);
                    System.out.println("b run end timer="+ System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            synchronized  public void Bservice(){
                System.out.println("print b service timer = "+ System.currentTimeMillis());
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
                        b.start();
                        Thread.sleep(6000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        class ThreadC extends Thread{
            private ThreadB b;

            public ThreadC(ThreadB b) {
                this.b = b;
            }

            @Override
            public void run() {
                b.Bservice();
            }
        }

        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);
        threadA.start();
        Thread.sleep(1000);
        ThreadC c = new ThreadC(threadB);
        c.start();

    }
}
