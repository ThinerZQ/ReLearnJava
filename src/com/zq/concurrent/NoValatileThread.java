package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 9:47
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class NoValatileThread {
    public static void main(String[] args) throws InterruptedException {


        class RunThread extends Thread{
            /*// 死循环
            private boolean isRunning =true;*/
            private volatile boolean isRunning =true;
            public boolean isRunning(){
                return isRunning;
            }
            public void setRunning(boolean isRunning){
                this.isRunning = isRunning;
            }

            @Override
            public void run() {
                System.out.println("enter into run method");
                while (isRunning == true){

                }
                System.out.println("Thread stopped");
            }
        }

        RunThread run =new RunThread();
        run.start();
        Thread.sleep(1000);
        run.setRunning(false);
        System.out.println("to be false");


    }

}
