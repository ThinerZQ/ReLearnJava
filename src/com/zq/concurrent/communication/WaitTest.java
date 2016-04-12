package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/9
 * Time: 11:08
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class WaitTest {
    public static void main(String[] args) {
        try{
            String lock = new String();
            System.out.println("syn before");
            synchronized (lock){
                System.out.println("syn first line");
                lock.wait();
                System.out.println("wait after");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
