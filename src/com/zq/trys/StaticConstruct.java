package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/2
 * Time: 9:48
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class StaticConstruct {
    public static StaticConstruct t1 = new StaticConstruct();
    public static StaticConstruct t2 = new StaticConstruct();
    {
        System.out.println("construct");
    }
    static
    {
        System.out.println("static");
    }
    public static void main(String[] args)
    {
        StaticConstruct t = new StaticConstruct();
    }
}
