package com.zq.statemachine;

import java.util.Scanner;

/**
 * Created by zhengshouzi on 2015/10/14.
 */
public class DecomposeVoteTask implements Runnable {
    private int decomposeVote;
    Scanner scanner = new Scanner(System.in);

    public int getDecomposeVote() {
        return decomposeVote;
    }

    public void setDecomposeVote(int decomposeVote) {
        this.decomposeVote = decomposeVote;
    }

    @Override
    public void run() {


        System.out.println("请输入投给谁");
        setDecomposeVote(scanner.nextInt());
        //scanner.close();
        System.out.println("投票结束");

    }
}
