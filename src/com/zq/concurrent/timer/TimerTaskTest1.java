package com.zq.concurrent.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 17:04
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TimerTaskTest1 {
    public static void main(String[] args) {

        System.out.println("current time is :"+ new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,10);
        Date runDate = calendar.getTime();

        MyTask task = new MyTask();
        MyTask task1 = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task,runDate);
        timer.schedule(task1,runDate);
    }
    private static class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("task is execute ,time is :"+ new Date());
        }
    }
}
