package com.zq.concurrent.example.sellticket;

import javax.swing.plaf.PanelUI;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午4:47
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class SellByThread extends Thread {


    private int ticket =100;

    public SellByThread(String name){
        super(name);
    }

    @Override
    public void run() {

        while (ticket!= 0){
            System.out.println(Thread.currentThread().getName()+" sell 第"+ (100-(ticket--)+1)+" 张票");
        }
    }
}
