package com.zq.statemachine;

/**
 * Created by zhengshouzi on 2015/10/13.
 */
public class StateMachineTry {

    public State state;
    public static void main(String args[]) throws InterruptedException {


        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();



    }





}

enum State{

    init,judgement,solving,decomposing,decomposevoting,waitdecomposeapprove,solvevoting,waitsolveapproval,end

}
