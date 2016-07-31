package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 14:33
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */


/**
 * 初始化过程是这样的：
 1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
 2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化；
 3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
 4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法；
 */
public class StaticInit {
    static int x=10;
    static {x+=5;}
    public static void main(String[] args) //4
    {
        System.out.println("x="+x);
    }
    static{x/=3;};
}//9