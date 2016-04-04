package com.zq.effective.java;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/26
 * Time: 19:14
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class AutoBoxingTimeComsuming {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        Long sum=0l;
        for (long i=0; i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        System.out.println(sum);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-begin);
        long sum2=0l;
        for (long i=0; i<Integer.MAX_VALUE;i++){
            sum2+=i;
        }
        System.out.println(sum2);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-end1);
    }
}
