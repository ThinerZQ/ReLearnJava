package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 10:35
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TestNull {
    private static void testMethod(){
    System.out.println("testMethod");
}
    public static void main(String[] args) {
        ((TestNull)null).testMethod();
    }

}
