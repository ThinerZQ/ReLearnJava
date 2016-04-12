package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 14:46
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class JoinTest1 {
    public static void main(String[] args) {
        class MyThread extends Thread{
            @Override
            public void run() {
                try{
                    int secondValue = (int) (Math.random()*1000);
                    System.out.println(secondValue);
                    try {
                        Thread.sleep(secondValue);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i want oto threadTest object ");
    }
}
