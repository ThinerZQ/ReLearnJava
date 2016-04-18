package com.zq.lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 20:44
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class PrintlnFounction {
    static int[] arr = {1,3,5,6,7,8,4,33};
    public static void main(String[] args) {
        for (int i:arr) {
            System.out.println(i);
        }

        //-------------------

        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });

        //------------------------
        Arrays.stream(arr).forEach((int x )->{
            System.out.println(x);
        });

        //---------------
        Arrays.stream(arr).forEach((x)-> System.out.println(x));

        //-------------
        Arrays.stream(arr).forEach(System.out::println);


    }
}
