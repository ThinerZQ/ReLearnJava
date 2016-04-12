package com.zq.concurrent.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 11:19
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class WaitNotifyTransfData {


    public static void main(String[] args) throws InterruptedException {
        class ThreadA extends Thread{
            private Object object;

            public ThreadA(Object object) {
                this.object = object;
            }

            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 10; i++) {
                        MyList.add();
                        if (MyList.size() ==5){
                            object.notify();
                            System.out.println("notify sent");
                        }
                        System.out.println("add " + (i+1) +" elements");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        class ThreadB extends Thread{
            private Object object;

            public ThreadB(Object object) {
                this.object = object;
            }

            @Override
            public void run() {
               synchronized (object){
                   if (MyList.size() !=5){
                       System.out.println("wait begin"+ System.currentTimeMillis());
                       try {
                           object.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("wait end"+ System.currentTimeMillis());
                   }
               }
            }
        }


        Object object = new Object();


        ThreadB b = new ThreadB(object);
        b.setName("B");
        b.start();
        Thread.sleep(1000);
        ThreadA a = new ThreadA(object);
        a.setName("A");
        a.start();
    }

    static class MyList{
        private static List list = new ArrayList();
        public static void add (){
            list.add("32");
        }
        public static int size(){
            return list.size();
        }
    }
}
