package com.zq.concurrent.threadpools.mythreadpool;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午2:39
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义线程池，学习线程池的原理
 */
public class MyThreadPool {

    //单例模式
    private static MyThreadPool instance = null;

    //空闲线程队列
    private List<MyThread> idelThreadList;

    private List<MyThread> workerThreadList;

    //总的线程数量
    private int threadCount;


    private boolean isShutdown=false;

    private MyThreadPool(){
        idelThreadList = Collections.synchronizedList(new ArrayList<>());
        workerThreadList = Collections.synchronizedList(new ArrayList<>());
        threadCount = 0 ;
    }

    //单例模式获取线程池实例
    public static synchronized MyThreadPool getInstance(){
        if (instance == null){
            instance = new MyThreadPool();
        }
        return instance;
    }

    public synchronized void  submit(Runnable target){

        MyThread workThread = null;
        if (idelThreadList.size() > 0){

            //随机取一个线程执行任务,这里取第1个空闲线程
            workThread = idelThreadList.get(0);
            idelThreadList.remove(workThread);
            //开始工作了
            workThread.setTarget(target);
        }else{
            //创建新的线程来执行任务
            threadCount ++;
            workThread = new MyThread(instance,target);
            workerThreadList.add(workThread);
            workThread.start();
        }


    }
    public boolean shutdown(){
        isShutdown = true;
        for (int i = 0; i < idelThreadList.size(); i++) {
            idelThreadList.get(i).shutdown();
        }
        return true;
    }

    public synchronized void rePushToIdeaThreadList(MyThread myThread){

        if (!isShutdown){
            idelThreadList.add(myThread);
        }else
            myThread.shutdown();
    }
    public synchronized void pullToWorkThreadList(MyThread myThread){
        if (!isShutdown){
            workerThreadList.remove(myThread);
        }else{
            myThread.shutdown();
        }
    }
    //得到线程池执行完所有任务
    public void awaitTermination() throws InterruptedException {

        while (workerThreadList.size()!=0){
            if (workerThreadList.size() == 0){
                Thread.sleep(1);
            }
        }
    }

    public int getThreadCount() {
        return threadCount;
    }


}
