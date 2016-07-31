package com.zq.concurrent.communication.threadlocal;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 15:34
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ThreadLocalTest {
    public static ThreadLocal t1 = new ThreadLocal();
    public static void main(String[] args) {
        if (t1.get() ==null){
            System.out.println("never put value");
            t1.set("my value");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
