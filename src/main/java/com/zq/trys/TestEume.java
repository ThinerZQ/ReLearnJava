package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 10:00
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TestEume {
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
        System.out.println(Math.floor(-8.5));
        System. out. println(10 % 3 * 2);
    }

}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}