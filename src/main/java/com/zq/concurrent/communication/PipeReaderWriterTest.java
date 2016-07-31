package com.zq.concurrent.communication;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 14:17
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class PipeReaderWriterTest {
    public static void main(String[] args) {
        class ThreadWrite extends Thread{
            private WriteData write;
            private PipedWriter out;

            public ThreadWrite(WriteData write, PipedWriter out) {
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
            private PipedReader in;

            public ThreadRead(ReadData read, PipedReader in) {
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

        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();

        try {
            pipedWriter.connect(pipedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadRead threadRead = new ThreadRead(readData,pipedReader);

        threadRead.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadWrite threadWrite = new ThreadWrite(writeData,pipedWriter);

        threadWrite.start();






    }
    private static class WriteData{
        public void write(PipedWriter out){
            try{
                System.out.println("write:" );
                for (int i = 0; i < 300;) {
                    String data = "woai"+(i++);
                    out.write(data);
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
        public void read(PipedReader in){
            try{
                System.out.println("begin read :");
                char[] chars = new char[20];
                int readLength = in.read(chars);
                System.out.println("reading");
                while (readLength != -1){
                    String newData = new String(chars,0,readLength);
                    System.out.println(newData);
                    readLength = in.read(chars);
                }
                System.out.println();
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
