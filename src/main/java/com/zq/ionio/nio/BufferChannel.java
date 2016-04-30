package com.zq.ionio.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Intellij IDEA
 * Date: 16-5-1
 * Time: 上午12:01
 * User: thinerzq
 * Github: https://www.github.com/ThinerZQ
 * Blog: http://www.thinerzq.me
 * Email: thinerzq@gmail.com
 */
public class BufferChannel {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/home/thinerzq/Workspace/IdeaWorkspace/ReLearnJava/src/main/resources/bufferchannel.txt");

        FileChannel channel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(50);

        int len = channel.read(buffer);

        while (len!= -1){
            buffer.flip();
            while (buffer.hasRemaining()){
                byte[] temp = new byte[10];
                buffer.get(temp);
                System.out.println(new String(temp));
            }
            buffer.compact();
            len = channel.read(buffer);
        }
        channel.close();


    }
}
