package com.zq.statemachine;

import java.util.Scanner;

/**
 * Created by zhengshouzi on 2015/10/14.
 */
public class DecomposeTask implements Runnable {
    private int decomposeStep;
    Scanner scanner = new Scanner(System.in);
    public int getDecomposeStep() {
        return decomposeStep;
    }

    public void setDecomposeStep(int decomposeStep) {
        this.decomposeStep = decomposeStep;
    }

    @Override
    public void run() {


        System.out.println("请输入你要把这个任务分为几步");
        setDecomposeStep(scanner.nextInt());
        //scanner.close();
        System.out.println("输入结束");

    }
}
