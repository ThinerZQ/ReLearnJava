package com.zq.riddle.expression;

/**
 * 而精致浮点对货币计算是非常不合适的，他不可能将0.1或者其他10的任何负幂精确的表示为一个长度有限的二进制小数
 * <p/>
 * 解决方法使用int带单位，或者bigdecimal 的string参数构造bigdicimal
 * Created by zhengshouzi on 2015/7/7.
 */

public class FindZoro {
    public static void main(String[] args) {
        double k = 2.00 - 1.10;
        System.out.println(k);
        System.out.printf("%.2f%n", k);
        System.out.println(2.00 - 1.10);

        System.out.println(2.00 - 1.15);
    }
}
