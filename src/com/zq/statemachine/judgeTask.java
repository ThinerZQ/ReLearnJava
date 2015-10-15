package com.zq.statemachine;

import java.util.Scanner;

/**
 * Created by zhengshouzi on 2015/10/14.
 */
public class judgeTask implements Runnable {
    private int judge;
    Scanner scanner = new Scanner(System.in);
    public int getJudge() {
        return judge;
    }

    public void setJudge(int judge) {
        this.judge = judge;
    }

    @Override
    public void run() {


        System.out.println("ÇëÊäÈëÅĞ¶Ï");
        setJudge(scanner.nextInt());
        //scanner.close();
        System.out.println("ÅĞ¶Ï½áÊø");

    }
}
