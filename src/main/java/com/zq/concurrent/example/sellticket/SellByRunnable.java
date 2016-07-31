package com.zq.concurrent.example.sellticket;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午4:53
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class SellByRunnable implements Runnable {

    private int ticket =100;



    @Override
    public  void run() {
        while (ticket!= 0){
            System.out.println(Thread.currentThread().getName()+" sell 第"+ (100-(ticket--)+1)+" 张票");
        }
    }
}
