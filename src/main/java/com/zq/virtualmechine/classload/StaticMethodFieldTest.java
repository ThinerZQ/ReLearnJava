package com.zq.virtualmechine.classload;

/**
 * 会报非法的向前编译，
 * Created by zhengshouzi on 2015/11/25.
 */
public class StaticMethodFieldTest {

    static {
        i=0; //给变量赋值，可以正常编译通过
        //System.out.println(i); //这句出错
    }

    static int i=1;

    public static void main(String[] args) {

    }
}
