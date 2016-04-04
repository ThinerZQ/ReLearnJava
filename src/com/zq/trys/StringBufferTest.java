package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 14:30
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y); y = x;
    }
}