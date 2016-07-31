package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 15:34
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class FinalExample{

    final int i;
    static FinalExample obj;
    public FinalExample(){
        obj=this;//(2)//(1),(2)可能被重排序
        i=1;//(1)
    }
    //线程1
    public static void writer(){
        new FinalExample();
    }
    //线程2
    public static void reader(){
        if(obj !=null){
            int temp =obj.i;
            System.out.println(temp);
        }
    }


    public static void main(String[] args) {


        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    FinalExample.writer();
                }
            });
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    FinalExample.reader();
                }
            });
            thread1.start();
            thread.start();
        }
    }

}
