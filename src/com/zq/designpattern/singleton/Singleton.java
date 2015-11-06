package com.zq.designpattern.singleton;

/**
 * Created by zhengshouzi on 2015/10/21.
 */

/**
 * ¶öººµ¥Àý
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * ÀÁººµ¥Àý
 */
class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}

class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        singleton = null;
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton1);

        System.out.println("----------------------------");
        //Singleton1 singleton11 = Singleton1.getInstance();
        //System.out.println(singleton11);

        for (int i = 0; i < 1000; i++) {

            new Thread() {
                @Override
                public void run() {
                    Singleton1 singleton12 = Singleton1.getInstance();
                    Singleton1 singleton19 = Singleton1.getInstance();
                    Singleton1 singleton13 = Singleton1.getInstance();
                    Singleton1 singleton14 = Singleton1.getInstance();
                    Singleton1 singleton15 = Singleton1.getInstance();
                    Singleton1 singleton16 = Singleton1.getInstance();
                    Singleton1 singleton17 = Singleton1.getInstance();
                    System.out.println(singleton12);
                    System.out.println(singleton19);
                    System.out.println(singleton13);
                    System.out.println(singleton14);
                    System.out.println(singleton15);
                    System.out.println(singleton16);
                    System.out.println(singleton17);
                }
            }.start();
        }


    }
}
