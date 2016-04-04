package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/30
 * Time: 20:53
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class AbstractNormalClass {
    public static void main(String[] args) {
        new Child().test();
    }

    private static class Child extends Bases{

        public Child(){
            System.out.println("child");
        }

        @Override
        void test() {
            System.out.println("child");
        }
    }
}

abstract  class Bases{
        public int a ;

    abstract void test();
    public Bases(){
        System.out.println("bases");
    }
        }
