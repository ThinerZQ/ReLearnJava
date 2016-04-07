package com.zq.virtualmechine.classload.generic;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/5
 * Time: 21:41
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class GenericTypes {

    //假的泛型，不能重载
    /*public static void method(List<String> list){

    }
    public static void method(List<Integer> list){

    }*/


    //假的泛型，返回值不一样就行了
   /* public static int method(List<String> list){

        return 1;
    }
    public static String method(List<Integer> list){

        return null;
    }*/
}
