package com.zq.lambda;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 21:00
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * 函数是编程的并行流统计质数的个数
 */
public class ParaellStream {
    public static void main(String[] args) {

        //串行的通知所有质数的个数
        System.out.println(System.currentTimeMillis());
        System.out.println(IntStream.range(1,10).filter(PrimeUtil::isPrime).count());
        System.out.println(System.currentTimeMillis());

        //并行的统计所有质数的个数
        System.out.println(IntStream.range(1,10000000).parallel().filter(PrimeUtil::isPrime).count());
        System.out.println(System.currentTimeMillis());
    }

    private static class PrimeUtil{
        public static boolean isPrime(int number){
            int temp = number;
            if (temp<2){
                return false;
            }
            for (int i = 2; i <= Math.sqrt(temp); i++) {
                if (temp%i ==0){
                    return false;
                }
            }
            return true;
        }
    }
}
