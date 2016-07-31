package com.zq.concurrent.paraellcompute;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 18:13
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ParaellLineCompute {
    public static void main(String[] args) {

        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Divide()).start();

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
                Plus.bq.add(msg);
            }

        }
    }
    private static class Msg{
        public double i;
        public double j;
        public String orgStr =null;
    }
    private static class Plus implements Runnable{
        public static BlockingQueue<Msg> bq =new LinkedBlockingDeque<>();

        @Override
        public void run() {
            while (true){
                try {
                    Msg msg = bq.take();
                    msg.j = msg.i+msg.j;
                    Multiply.bq.add(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Multiply implements Runnable{
        public static BlockingQueue<Msg> bq =new LinkedBlockingDeque<>();

        @Override
        public void run() {
            while (true){
                try {
                    Msg msg = bq.take();
                    msg.i = msg.i*msg.j;
                    Divide.bq.add(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Divide implements Runnable{
        public static BlockingQueue<Msg> bq =new LinkedBlockingDeque<>();

        @Override
        public void run() {
            while (true){
                try {
                    Msg msg = bq.take();
                    msg.i = msg.i/2;
                    System.out.println(msg.orgStr + " = " + msg.i);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
