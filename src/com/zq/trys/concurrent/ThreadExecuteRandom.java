package com.zq.trys.concurrent;



/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 11:00
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadExecuteRandom {

    public static void main(String[] args) {
        try{
            MyThread thread = new MyThread();
            thread.setName("myThread");
            thread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }




    private static class MyThread extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    int time = (int) (Math.random()*1000);
                    Thread.sleep(time);
                    System.out.println("run=" + Thread.currentThread().getName());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
