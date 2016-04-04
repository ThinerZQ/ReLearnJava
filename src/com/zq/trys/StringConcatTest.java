package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/2
 * Time: 9:36
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class StringConcatTest {
    public static void main (String[] args) {
        String classFile = "com. jd. ".replaceAll(".", "/") + "MyClass.class";
        System.out.println(classFile);

    }
}
