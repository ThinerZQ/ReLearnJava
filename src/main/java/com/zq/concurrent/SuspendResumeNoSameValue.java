package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 10:03
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SuspendResumeNoSameValue {
    public static void main(String[] args) throws InterruptedException {

        final MyObject myObject = new MyObject();
        Thread thread = new Thread() {
            @Override
            public void run() {
                myObject.setValue("a", "aa");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(500);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myObject.printUsernamePassword();
            }
        };
        thread1.start();
    }

    private static class MyObject {
        private String useranme = "1";
        private String password = "11";

        public void setValue(String u, String p) {
            this.useranme = u;
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("stop a thread");
                Thread.currentThread().suspend();
            }
            this.password = p;
        }

        public void printUsernamePassword() {
            System.out.println(useranme + " " + password);
        }
    }
}
