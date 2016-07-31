package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/8
 * Time: 11:08
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class HasSelfPrivateNumTest2 {

    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        ThreadB threadB = new ThreadB(hasSelfPrivateNum);
        threadA.start();
        threadB.start();
    }


    private static class HasSelfPrivateNum {
        private int num = 0;

        public void addI(String username) {
            try {
                if (username.equals("a")) {
                    num = 100;
                    System.out.println("a set over");
                } else {
                    num = 200;
                    System.out.println("b set over");
                }
                System.out.println(username + " num=" + num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreadA extends Thread {
        private HasSelfPrivateNum numRef;

        public ThreadA(HasSelfPrivateNum numRef) {
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("a");
        }
    }

    private static class ThreadB extends Thread {
        private HasSelfPrivateNum numRef;

        public ThreadB(HasSelfPrivateNum numRef) {
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("b");
        }
    }
}
