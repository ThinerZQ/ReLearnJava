package com.zq.concurrent.communication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 13:56
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class PipeInputOutputTest {

    public static void main(String[] args) {

        class ThreadWrite extends Thread{
            private WriteData write;
            private PipedOutputStream out;

            public ThreadWrite(WriteData write, PipedOutputStream out) {
                this.write = write;
                this.out = out;
            }

            @Override
            public void run() {
                write.write(out);
            }
        }
        class ThreadRead extends Thread{
            private ReadData read;
            private PipedInputStream in;

            public ThreadRead(ReadData read, PipedInputStream in) {
                this.read = read;
                this.in = in;
            }

            @Override
            public void run() {
                read.read(in);
            }
        }



        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();

        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        try {
            outputStream.connect(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadRead threadRead = new ThreadRead(readData,inputStream);

        threadRead.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadWrite threadWrite = new ThreadWrite(writeData,outputStream);

        threadWrite.start();


    }





    private static class WriteData{
        public void write(PipedOutputStream out){
            try{
                System.out.println("write:" );
                for (int i = 0; i < 300;) {
                    String data = ""+(i++);
                    out.write(data.getBytes());
                    System.out.println(data);
                }
                System.out.println();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static class ReadData{
        public void read(PipedInputStream in){
            try{
                System.out.println("begin read :");
                byte[] bytes = new byte[20];
                int readLength = in.read(bytes);
                System.out.println("reading");
                while (readLength != -1){
                    String newData = new String(bytes,0,readLength);
                    System.out.println(newData);
                    readLength = in.read(bytes);
                }
                System.out.println();
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
