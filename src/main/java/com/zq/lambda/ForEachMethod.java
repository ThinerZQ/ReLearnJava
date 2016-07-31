package com.zq.lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/18
 * Time: 20:56
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class ForEachMethod {
    public static void main(String[] args) {
        int[] arr = {1235,4562,19,32,2,1,4,76};
        IntConsumer out = System.out::println;
        IntConsumer err = System.out::println;

        Arrays.stream(arr).forEach(out.andThen(err));
    }
}
