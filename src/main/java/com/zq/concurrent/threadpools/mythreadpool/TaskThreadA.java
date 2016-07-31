package com.zq.concurrent.threadpools.mythreadpool;

/**
 * Created by Intellij IDEA
 * Date: 16-5-3
 * Time: 下午3:24
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class TaskThreadA implements Runnable {
    @Override
    public void run() {
        System.out.println("我是任务A,现在被执行");
    }
}
