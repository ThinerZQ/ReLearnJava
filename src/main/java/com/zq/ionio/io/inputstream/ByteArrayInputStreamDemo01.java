package com.zq.ionio.io.inputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Intellij IDEA
 * Date: 16-4-30
 * Time: 下午12:16
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class ByteArrayInputStreamDemo01 {
    public static void main(String[] args) {



    }

    /**
     * ByteArrayOutputStream 把数据写入到内存的数组中，
     *
     * ByteArrayInputStream 把内存中某一个字节数组中的数据读出来，
     */
    public static void test(){


        int a = 0;
        int b = 1;
        int c = 2;

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write(a);
        bout.write(b);
        bout.write(c);
        byte[] buff = bout.toByteArray();
        for (int i = 0; i < buff.length; i++)
            System.out.println(buff[i]);

        System.out.println("***********************");

        ByteArrayInputStream bin = new ByteArrayInputStream(buff);
        while ((b = bin.read()) != -1) {
            System.out.println(b);
        }

    }
}
