package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 15:59
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */


public class IIncrementValueTest {
    public static void main(String[] args) {
        IIncrementValueTest inc = new IIncrementValueTest();
        int i = 0;
        //inc.fermin(i);
        i= i++;
        System.out.println(i);
        System.out.println(i);

    }
    void fermin(int i){
        i++;
    }
}