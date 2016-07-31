package com.zq.ionio.io.inputstream;

import java.io.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Intellij IDEA
 * Date: 16-4-30
 * Time: 上午11:37
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */

/**
 * InputStream 流学习
 */
public class InputStreamDemo01 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        readTest02();
    }

    /**
     * 一次性直接存放到数组里面
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void readTest01() throws URISyntaxException, IOException {

        URL url = InputStreamDemo01.class.getClassLoader().getResource("inputstreamdemo01.txt");
        //构建文件
        File f = new File(url.toURI());
        //构建输入刘
        InputStream in = new FileInputStream(f);
        //取得流中文件大大小，新建数组
        byte b[]=new byte[(int)f.length()];
        //读取文件中的内容到b[]数组
        in.read(b);

        in.close();
        System.out.println(new String(b));
    }

    /**
     * 放一些在数组里面
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    private static void readTest02() throws URISyntaxException, IOException {

        URL url = InputStreamDemo01.class.getClassLoader().getResource("inputstreamdemo01.txt");
        //构建文件
        File f = new File(url.toURI());
        //构建输入刘
        InputStream in = new FileInputStream(f);

        byte b[] = new byte[1024];
        int temp=0;          //所有读取的内容都使用temp接收
        while((temp=in.read(b))!=-1){    //当没有读取完时，继续读取
            System.out.println(new String(b,0,temp).toString());
        }
        in.close();
    }
}
