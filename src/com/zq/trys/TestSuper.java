package com.zq.trys;

import java.util.Date;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 10:39
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */


public class TestSuper extends Date {
    private static final long serialVersionUID = 1L;
    private void test(){


        System.out.println(super.getClass().getName());
    }

    public static void main(String[]args){
        new TestSuper().test();
    }
}