package com.zq.virtualmechine.classload;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/3
 * Time: 21:25
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class StringIntern {
    public static void main(String[] args) {
        String str = new StringBuilder("¼ÆËã»ú").append("Èí¼þ").toString();
        System.out.println(str.intern() == str);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        System.out.println(args.length);
    }
}
