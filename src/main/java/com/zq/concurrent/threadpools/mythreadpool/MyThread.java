package com.zq.concurrent.threadpools.mythreadpool;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午2:42
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class MyThread extends Thread {

    //当前线程所在的线程池
    private MyThreadPool pool;

    //当前线程需要执行的任务
    private Runnable target;

    //当前线程是不是结束了
    private boolean isShutDown = false;

    //当前线程是不是空闲的
    private boolean isIdle = false;

    public MyThread(MyThreadPool myThreadPool,Runnable target){
        this.pool = myThreadPool;
        this.target = target;
    }


    @Override
    public void run() {
        //当前线程的处理逻辑,只要当前现成没有结束，就不退出
        while (!isShutDown){

            //
            isIdle = false;

            if (target != null){
                //运行任务，单纯的调用target的run()方法
                target.run();
            }

            isIdle = true;
            pool.pullToWorkThreadList(this);
            try {
                //线程运行任务结束了，重新放入线程池
                pool.rePushToIdeaThreadList(this);
                synchronized (this){
                    //线程空闲，需要等待任务到来
                    wait();
                }
            }catch (Exception e){
                //放入线程池失败
                e.printStackTrace();
            }
            isIdle = false;
        }
    }
    public synchronized void setTarget(Runnable target){
        this.target = target;
        notify();
    }
    public void shutdown(){
        this.isShutDown = true;
        //要关闭的时候，要把wait()的本线程唤醒，然后再让其运行完。
        notify();
    }

    public boolean isIdle() {
        return isIdle;
    }
}
