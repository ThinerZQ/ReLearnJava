package com.zq.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 15:29
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class NonDirtyReadIfElse {
    public static void main(String[] args) throws InterruptedException {


        MyOneList list = new MyOneList();
        Thread1 thread1 = new Thread1(list);
        thread1.setName("A");
        thread1.start();
        Thread2 thread2 = new Thread2(list);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(6000);
        System.out.println("listSize = " + list.getSize());
    }


    static class Thread1 extends Thread {
        private MyOneList list;

        public Thread1(MyOneList list) {
            this.list = list;
        }

        @Override
        public void run() {
            MyService service = new MyService();
            service.addServiceMethod(list, "A");
        }
    }

    static class Thread2 extends Thread {
        private MyOneList list;

        public Thread2(MyOneList list) {
            this.list = list;
        }

        @Override
        public void run() {
            MyService service = new MyService();
            service.addServiceMethod(list, "B");
        }
    }


    static class MyOneList {
        private List list = new ArrayList<>();

        synchronized public void add(String data) {
            list.add(data);
        }

        synchronized public int getSize() {
            return list.size();
        }
    }

    static class MyService {
        public MyOneList addServiceMethod(MyOneList list, String data) {
            try {
                synchronized (list) {
                    if (list.getSize() < 1) {
                        Thread.sleep(2000);
                        list.add(data);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
    }
}
