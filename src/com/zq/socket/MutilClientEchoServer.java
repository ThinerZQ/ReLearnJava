package com.zq.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/25
 * Time: 21:13
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class MutilClientEchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8789);
        while (true){
            try{
                Socket socket =serverSocket.accept();
                Runnable runnable = new ThreadEchoHandler(socket);
                Thread thread = new Thread(runnable);
                thread.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static class ThreadEchoHandler implements Runnable{

        private Socket socket;
        public ThreadEchoHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                try(Scanner in = new Scanner(inputStream)){
                    PrintWriter out = new PrintWriter(outputStream,true);
                    out.println("hello! Enter Bye to exit!");
                    boolean done = false;
                    while (!done && in.hasNext()){
                        String line = in.nextLine();
                        out.println("Echo: "+ line);
                        if (line.trim().equalsIgnoreCase("Bye"))
                            done= true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
