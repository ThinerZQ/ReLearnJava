package com.zq.annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2017/8/26 23:00
 * Project：learn
 * Package：com.zq
 */
public class AnnotationExample {
    public static void main(String[] args) {

    }


    @Override
    @MethodInfo(author = "zhengqiang", comments = "this is a method", date = "time", revision = 1)
    public String toString() {
        return "hehe";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "date")
    public static void oldMethod() {
        System.out.println("don't use it");
    }

    @SuppressWarnings({ "no warning" })
    @MethodInfo(author = "zq", comments = "main method", date = "data", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("hehe");
        oldMethod();
    }

}
