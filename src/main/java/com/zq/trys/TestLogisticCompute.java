package com.zq.trys;

import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 16:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class TestLogisticCompute {
    private static int j = 0;

    private static Boolean methodB(int k) {
        //int[][] array = new int[3][]{new int[3]{5,6,2}, new int[5]{6,9,7,8,3}, new int[2]{3,2}};
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);

    }

    public static void main(String args[]) {
        methodA(0);
        System.out.println(j);
    }
}
