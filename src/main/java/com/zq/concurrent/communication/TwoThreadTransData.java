package com.zq.concurrent.communication;

import javafx.scene.web.WebHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 10:49
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TwoThreadTransData {


    public static void main(String[] args) {
        class ThreadA extends Thread{
            private MyList list;

            public ThreadA(MyList list) {
                this.list = list;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (this) {
                        list.add();
                    }
                    System.out.println("add "+ (i+1)+" elements");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class ThreadB extends Thread{
            private MyList list;

            public ThreadB(MyList list) {
                this.list = list;
            }

            @Override
            public void run() {
                try {
                    while (true) {
                        //System.out.println("33");
                        //TODO:疑惑
                        if (list.size() == 5) {
                            System.out.println("==5 ,b exit");
                            throw new InterruptedException();
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }


        MyList list = new MyList();
        ThreadA a = new ThreadA(list);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(list);
        b.setName("B");
        b.start();
    }



    static class MyList{
        private List list = new ArrayList();
        public void add (){
            list.add("32");
        }
        public int size(){
            return list.size();
        }
    }
}
