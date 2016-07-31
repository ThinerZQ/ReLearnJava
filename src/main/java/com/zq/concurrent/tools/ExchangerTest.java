package com.zq.concurrent.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/14
 * Time: 15:33
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String a = "bank flow a";
                    exchanger.exchange(a);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String b ="bank flow b";
                try {
                    String A = exchanger.exchange(b);
                    System.out.println("the data of a and b is consistent:"+A.equals(b) +",,  a is :"+A+",, b is"+ b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        threadPool.shutdown();
    }
}
