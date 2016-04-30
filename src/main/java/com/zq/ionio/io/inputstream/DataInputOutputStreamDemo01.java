package com.zq.ionio.io.inputstream;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Intellij IDEA
 * Date: 16-4-30
 * Time: 下午12:22
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class DataInputOutputStreamDemo01 {
    public static void main(String[] args) throws IOException, URISyntaxException {

        test02();
    }

    /**
     * DataOutputStream&DataInputStream的作用和功能,
     * 与ByteArrayOutputStream和ByteArrayInputSream使用将更方便.
     * 此时DataOutputStream&DataInputStream封闭了字节流,以适当的形式读出了字节数组中的数据.
     */
    public static void test() throws IOException, URISyntaxException {

        URL url = DataInputOutputStreamDemo01.class.getClassLoader().getResource("dataoutputstream.txt");

        //构建文件
        File f = new File(url.toURI());

        FileOutputStream fos=new FileOutputStream(f);

        DataOutputStream dos=new DataOutputStream(fos);


        String name = "zhengqiang";
        int age = 84;
        dos.writeUTF(name);
        dos.writeInt(age);
        dos.writeBytes("afda");

        dos.flush();
        dos.close();





    }
    public static void test02() throws IOException {
        DataInputStream d = new DataInputStream(new
                FileInputStream("/home/thinerzq/Workspace/IdeaWorkspace/ReLearnJava/src/main/resources/test.txt"));

        DataOutputStream out = new DataOutputStream(new
                FileOutputStream("/home/thinerzq/Workspace/IdeaWorkspace/ReLearnJava/src/main/resources/test1.txt"));

        String count;
        while((count = d.readUTF()) != null){
            String u = count.toUpperCase();
            System.out.println(u);
            out.writeBytes(u + "  ,");
        }
        d.close();
        out.close();
    }
}
