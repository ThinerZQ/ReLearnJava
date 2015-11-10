package com.zq.innerclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by zhengshouzi on 2015/11/8.
 */
public class Task {

    String transition =null;
    class Init{

        public void exit(){
            System.out.println("exit SolveVote");
            transition = "com.zq.innerclass.Task$Judge";
        }
    }
    class Judge{
        int count=0;
        //内部转移
        public synchronized void judge(){
            count++;
        }



        //外部转移

        public void toDivide(){

        }
        public void toSolve(){

        }



        public void entry(){
            System.out.println("entry SolveVote");
        }
        public void exit(){
            System.out.println("exit SolveVote");
        }

    }
    class Divide{
        int count=0;
        public void divide(){
            count++;
        }
        public void entry(){
            System.out.println("entry SolveVote");
        }
        public void exit(){
            System.out.println("exit SolveVote");
        }

    }
    class DivideVote{
        int count=0;
        public void vote(){
            count++;
        }
        public void entry(){
            System.out.println("entry SolveVote");
        }
        public void exit(){
            System.out.println("exit SolveVote");
        }

    }
    class Solve{
        int count=0;
        public void solve(){
            count++;
        }
        public void entry(){
            System.out.println("entry SolveVote");
        }
        public void exit(){
            System.out.println("exit SolveVote");
        }

    }
    class SolveVote{
        int count=0;

        public void entry(){
            System.out.println("entry SolveVote");
        }
        public void exit(){
            System.out.println("exit SolveVote");
        }
        public void vote(){
            vote();
        }
    }
    class Final{
        public void Entry(){

        }
    }
}

class Demo{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, InterruptedException {
        Task task = new Task();

        Task.Init init = task.new Init();
        Task.Judge judge= null;
        Task.Divide divide = null;
        Task.DivideVote divideVote =null;
        Task.Solve solve = null;
        Task.SolveVote solveVote =null;
        Task.Final finals = null;

        init.exit();

        Class  tempclass = Class.forName(task.transition);

        Constructor[] constructor = tempclass.getDeclaredConstructors();

        judge = (Task.Judge) constructor[0].newInstance(new Task());


        final Task.Judge finalJudge = judge;
        class JudgePeople implements Runnable{
            @Override
            public void run() {
                finalJudge.judge();
            }
        }
        JudgePeople judgePeople = new JudgePeople();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(judgePeople);
            thread.start();
        }
        Thread.sleep(1000);
        if (judge.count==3){
            System.out.println("判断完成");
        }


    }

        }
