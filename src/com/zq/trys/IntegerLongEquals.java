package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/2
 * Time: 9:51
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class IntegerLongEquals {

    public static void main(String[] args) {
        Integer s=new Integer(9);
        Integer t=new Integer(9);
        Long u=new Long(9);

        System.out.println(s==t);
        //System.out.println(s==u);
        System.out.println(s.equals(t));
        System.out.println(s.equals(9));
        System.out.println(s.equals(new Integer(9)));
    }
}
