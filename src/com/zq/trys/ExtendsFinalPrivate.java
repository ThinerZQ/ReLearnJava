package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/2
 * Time: 9:32
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ExtendsFinalPrivate extends Vehicle{
    public static void main(String[] args) {

        new ExtendsFinalPrivate().run();
    }
    private final void run(){
        System.out.println("Car");
    }

}
class Vehicle{
    private final void run(){
        System.out.println("Vehicle");
    }
}
