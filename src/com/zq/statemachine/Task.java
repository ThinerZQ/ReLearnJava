package com.zq.statemachine;

import java.util.Scanner;

/**
 * Created by zhengshouzi on 2015/10/14.
 */
public class Task implements Runnable {
    public State state =State.init;
    @Override
    public void run() {

        int step1=0;
        int step2=0;
        Task[] tasks;
        Scanner scanner = new Scanner(System.in);

        while(true){
            printEntryState(state);
            switch (state){
                case init:
                    printExitState(state);
                    state = State.judgement;
                    break;
                case judgement:
                    int complexCount=0,simpleCount=0;
                    judgeTask[] judgeTask=new judgeTask[3];
                    Thread[] thread=new Thread[3];
                    for (int i=0;i<3;i++){
                        judgeTask[i]= new judgeTask();
                        thread[i]= new Thread(judgeTask[i]);
                        thread[i].start();
                        try {
                            thread[i].join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    for (int i=0;i<3;i++){
                        if (judgeTask[i].getJudge() ==0){
                            complexCount++;
                        }else {
                            simpleCount++;
                        }
                    }
                    printExitState(state);
                    if (complexCount>simpleCount){
                        state=State.decomposing;
                    }else{
                        state = State.solving;
                    }
                    break;
                case decomposing:

                    DecomposeTask[] decomposeTasks = new DecomposeTask[2] ;
                    Thread[] decomposeThread=new Thread[2];
                    for (int i=0;i<2;i++){
                        decomposeTasks[i]= new DecomposeTask();
                        decomposeThread[i]= new Thread(decomposeTasks[i]);
                        decomposeThread[i].start();
                        try {
                            decomposeThread[i].join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    step1= decomposeTasks[0].getDecomposeStep();
                    step2= decomposeTasks[1].getDecomposeStep();
                    printExitState(state);
                    state = State.decomposevoting;
                    break;
                case decomposevoting:
                    int decomposer1=0,decomposer2=0;
                    DecomposeVoteTask[] decomposeVoteTasks=new DecomposeVoteTask[3];
                    Thread[] decomposeVoteThread=new Thread[3];
                    for (int i=0;i<3;i++){
                        decomposeVoteTasks[i]= new DecomposeVoteTask();
                        decomposeVoteThread[i]= new Thread(decomposeVoteTasks[i]);
                        decomposeVoteThread[i].start();
                        try {
                            decomposeVoteThread[i].join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    for (int i=0;i<3;i++){
                        if (decomposeVoteTasks[i].getDecomposeVote() ==1){
                            decomposer1++;
                        }else {
                            decomposer2++;
                        }
                    }
                    if (decomposer1>decomposer2){
                        tasks = new Task[step1];
                        Thread[] thread1 = new Thread[step1];
                        for (int i=0;i<step1;i++){
                            tasks[i] = new Task();
                            thread1[i] = new Thread(tasks[i]);
                            thread1[i].start();
                            try {
                                thread1[i].join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }else{
                        tasks = new Task[step2];
                        Thread[] thread1 = new Thread[step2];
                        for (int i=0;i<step1;i++){
                            tasks[i] = new Task();
                            thread1[i] = new Thread(tasks[i]);
                            thread1[i].start();
                            try {
                                thread1[i].join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    printExitState(state);
                    state = State.waitdecomposeapprove;
                    break;
                case waitdecomposeapprove:

                    break;





            }

        }


    }
    public void printEntryState(State state) {

        switch (state) {
            case init:
                System.out.println("�����ʼ��״̬");
                break;
            case judgement:
                System.out.println("�����ж�״̬");
                break;
            case decomposing:
                System.out.println("����ֽ���״̬");
                break;
            case decomposevoting:
                System.out.println("����ֽ�ͶƱ״̬");
                break;
            case waitdecomposeapprove:
                System.out.println("����ȴ��ֽ�ȷ��״̬");
                break;
            case solvevoting:
                System.out.println("������ͶƱ״̬");
                break;
            case solving:
                System.out.println("������״̬");
                break;
            case waitsolveapproval:
                System.out.println("����ȴ�ͶƱȷ��״̬");
                break;
            case end:
                System.out.println("�������״̬");
        }
    }
    public void printExitState(State state){

        switch (state){
            case init:
                System.out.println("�˳���ʼ��״̬");
                break;
            case judgement:
                System.out.println("�˳��ж�״̬");
                break;
            case decomposing:
                System.out.println("�˳��ֽ���״̬");
                break;
            case decomposevoting:
                System.out.println("�˳��ֽ�ͶƱ״̬");
                break;
            case waitdecomposeapprove:
                System.out.println("�˳��ȴ��ֽ�ȷ��״̬");
                break;
            case solvevoting:
                System.out.println("�˳����ͶƱ״̬");
                break;
            case solving:
                System.out.println("�˳����״̬");
                break;
            case waitsolveapproval:
                System.out.println("�˳��ȴ�ͶƱȷ��״̬");
                break;
        }


    }
}
