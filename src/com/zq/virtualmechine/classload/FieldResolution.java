package com.zq.virtualmechine.classload;

/**
 * 字段解析
 * 书上说这里可能会拒绝编译，但是没有，还能够执行
 * Created by zhengshouzi on 2015/11/25.
 */
public class FieldResolution {
    interface Interface0{
        int A=0;
    }
    interface Interface1 extends Interface0{
        int A=1;
    }
    interface Interface2{
        int A=2;
    }
    static class Parent implements Interface1{
        public static int A=3;
    }
    static class Sub extends Parent implements Interface2{
        public static int A=4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
