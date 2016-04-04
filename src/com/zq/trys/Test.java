package com.zq.trys;

import sun.misc.Unsafe;

import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/30
 * Time: 11:15
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
class Base {

    public int i=0;
    public Base(){
        System.out.println("base构造");
       test();
    }
    public void fun(){
        System.out.println("base "+i);
    }
    public void test(){
        fun();
    }
}
class Child extends Base{




    private int k=0;

    public Child(){
        k=34;
        System.out.println("child构造");
        test();
    }
    public void fun(){
        System.out.println(k);
        ++i;
        System.out.println("child "+i);
    }
}

public class Test{
    public static void main(String[] args) {
        Base base = new Child();
        base.test();
    }
}