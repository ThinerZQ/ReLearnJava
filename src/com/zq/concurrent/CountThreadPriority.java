package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 10:23
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class CountThreadPriority {

    public static void main(String[] args) throws InterruptedException {
        class Run1 extends Thread {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    count++;
                    System.out.println("current Thread" + Thread.currentThread().getName() + " " + count);
                }
            }

            public int getCount() {
                return count;
            }
        }
        class Run2 extends Thread {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    count++;
                    System.out.println("current Thread" + Thread.currentThread().getName() + " " + count);
                }
            }

            public int getCount() {
                return count;
            }
        }

        try {
            Run1 run1 = new Run1();
            Run2 run2 = new Run2();
            run1.setPriority(Thread.NORM_PRIORITY - 3);
            run1.start();
            run2.setPriority(Thread.NORM_PRIORITY + 3);
            run2.start();
            Thread.sleep(20000);
            run1.stop();
            run2.stop();
            System.out.println("a = " + run1.getCount());
            System.out.println("b = " + run2.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
