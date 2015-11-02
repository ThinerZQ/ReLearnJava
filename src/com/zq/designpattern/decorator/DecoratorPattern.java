package com.zq.designpattern.decorator;

import java.util.Random;

/**
 * Created by zhengshouzi on 2015/10/28.
 */

interface OutputStream{
    void write(String string);
}

class StringOutputStream implements OutputStream{

    @Override
    public void write(String string) {
        System.out.println("写  "+ string + "  到文件");
    }
}

abstract class FilterOutputStream implements OutputStream{


}
class EncryptString_1_OutputStream extends FilterOutputStream{
    OutputStream outputStream;

    public EncryptString_1_OutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    @Override
    public void write(String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println("源字符串:  "+string+"   开始简单加密（装饰）：每一字符自身加上1");
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='z'){
                chars[i] = (char) (chars[i]+1);
            }else {
                chars[i] = 'a';
            }
            //System.out.print(chars[i]);
            sb.append(chars[i]);
        }
        System.out.println("随机加密后字符串：" + sb.toString());
        System.out.println("------------------------------------------------");
        outputStream.write(sb.toString());
    }
}

class EncryptString_2_OutputStream extends FilterOutputStream{
    OutputStream outputStream;
    public EncryptString_2_OutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    @Override
    public void write(String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println("源字符串:  "+string+"   开始自身加密（装饰）：每一字符加上自己然后除以3");
        for (int i=0;i<chars.length;i++){

            chars[i] = (char) ((chars[i]+chars[i])/3);
            //System.out.print(chars[i]);
            sb.append(chars[i]);
        }
        System.out.println("随机加密后字符串：" + sb.toString());
        System.out.println("------------------------------------------------");
        outputStream.write(sb.toString());
    }
}

class EncryptString_3_OutputStream extends FilterOutputStream{
    OutputStream outputStream;
    public EncryptString_3_OutputStream(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    @Override
    public void write(String string) {
        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        System.out.println("源字符串:  "+string+"   开始随机加密（装饰）：每一字符加上一个5以内的随机数");
        for (int i=0;i<chars.length;i++){

            chars[i] = (char) ((chars[i]+new Random().nextInt(5)-5));
            //System.out.print(chars[i]);
            sb.append(chars[i]);
        }
        System.out.println("随机加密后字符串：" + sb.toString());
        System.out.println("------------------------------------------------");
        outputStream.write(sb.toString());
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        OutputStream outputStream = new StringOutputStream();

        EncryptString_1_OutputStream encryptString_1_outputStream = new EncryptString_1_OutputStream(outputStream);
        EncryptString_2_OutputStream encryptString_2_outputStream = new EncryptString_2_OutputStream(encryptString_1_outputStream);
        EncryptString_3_OutputStream encryptString_3_outputStream = new EncryptString_3_OutputStream(encryptString_2_outputStream);
        //encryptString_1_outputStream.write("output");
        encryptString_3_outputStream.write("zhengqiang");
    }
}





